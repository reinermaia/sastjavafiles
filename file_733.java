  @Override
  public List<Assignment> assign(Collection<String> suiteNames, int slaves, long seed) {
    // Read hints first.
    final Map<String,List<Long>> hints = ExecutionTimesReport.mergeHints(resources, suiteNames);

    // Preprocess and sort costs. Take the median for each suite's measurements as the 
    // weight to avoid extreme measurements from screwing up the average.
    final List<SuiteHint> costs = new ArrayList<>();
    for (String suiteName : suiteNames) {
      final List<Long> suiteHint = hints.get(suiteName);
      if (suiteHint != null) {
        // Take the median for each suite's measurements as the weight
        // to avoid extreme measurements from screwing up the average.
        Collections.sort(suiteHint);
        final Long median = suiteHint.get(suiteHint.size() / 2);
        costs.add(new SuiteHint(suiteName, median));
      }
    }
    Collections.sort(costs, SuiteHint.DESCENDING_BY_WEIGHT);

    // Apply the assignment heuristic.
    final PriorityQueue<SlaveLoad> pq = new PriorityQueue<SlaveLoad>(
        slaves, SlaveLoad.ASCENDING_BY_ESTIMATED_FINISH);
    for (int i = 0; i < slaves; i++) {
      pq.add(new SlaveLoad(i));
    }

    final List<Assignment> assignments = new ArrayList<>();
    for (SuiteHint hint : costs) {
      SlaveLoad slave = pq.remove();
      slave.estimatedFinish += hint.cost;
      pq.add(slave);

      owner.log("Expected execution time for " + hint.suiteName + ": " +
          Duration.toHumanDuration(hint.cost),
          Project.MSG_DEBUG);

      assignments.add(new Assignment(hint.suiteName, slave.id, (int) hint.cost));
    }

    // Dump estimated execution times.
    TreeMap<Integer, SlaveLoad> ordered = new TreeMap<Integer, SlaveLoad>();
    while (!pq.isEmpty()) {
      SlaveLoad slave = pq.remove();
      ordered.put(slave.id, slave);
    }
    for (Integer id : ordered.keySet()) {
      final SlaveLoad slave = ordered.get(id);
      owner.log(String.format(Locale.ROOT, 
          "Expected execution time on JVM J%d: %8.2fs",
          slave.id,
          slave.estimatedFinish / 1000.0f), 
          verbose ? Project.MSG_INFO : Project.MSG_DEBUG);
    }

    return assignments;
  }
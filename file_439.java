  public List<E> getBetterOrEqual(int threshold) {

    List<E> bests = new ArrayList<>();
    for (E element : this.map.keySet()) {
      Ranking ranking = this.map.get(element);
      if ((ranking != null) && (ranking.rank >= threshold)) {
        bests.add(element);
      }
    }
    return bests;
  }
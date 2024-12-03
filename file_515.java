	public List<ClassStats> caculateHistogram(int excactAge, int minAge) {
		HashMap<Klass, ClassStats> classStatsMap = new HashMap<>(2048, 0.2f);
		CollectedHeap heap = HeapUtils.getHeap();
		ObjectHeap objectHeap = HeapUtils.getObjectHeap();

		// 获取Survivor区边界
		Address fromBottom = null;
		Address fromTop = null;

		if (HeapUtils.isCMSGC(heap)) {
			DefNewGeneration youngGen = HeapUtils.getYoungGenForCMS(heap);
			ContiguousSpace from = youngGen.from();
			fromBottom = from.bottom();
			fromTop = from.top();

			from.printOn(tty);
			tty.println("");
		} else if (HeapUtils.isParallelGC(heap)) {
			PSYoungGen psYoung = HeapUtils.getYongGenForPar(heap);
			MutableSpace from = psYoung.fromSpace();
			fromBottom = from.bottom();
			fromTop = from.top();

			from.printOn(tty);
			tty.println("");
		} else {
			throw new IllegalArgumentException(
					"Only support CMS and Parallel GC. Unsupport heap:" + heap.getClass().getName());
		}

		// 记录分年龄统计
		long[] ageSize = new long[50];
		int[] ageCount = new int[50];
		int maxAge = 1;

		// 遍历Survivor区
		OopHandle handle = fromBottom.addOffsetToAsOopHandle(0);

		while (handle.lessThan(fromTop)) {
			Oop obj = null;
			try {
				obj = objectHeap.newOop(handle);
			} catch (UnknownOopException ex) {
				// ok
			}

			if (obj == null) {
				throw new UnknownOopException();
			}

			long objectSize = obj.getObjectSize();

			// handle指针指向下一个对象，后面的处理如果失败，直接进入下一个循环
			handle = handle.addOffsetToAsOopHandle(objectSize);

			Klass klass = obj.getKlass();
			if (klass == null) {
				continue;
			}

			int age = obj.getMark().age();

			ageCount[age]++;
			ageSize[age] += objectSize;
			if (age > maxAge) {
				maxAge = age;
			}

			// 如果设定了精确匹配age
			if (excactAge != -1) {
				if (age != excactAge) {
					continue;
				}
			} else if (age < minAge) {
				// 否则判断age>=minAge
				continue;
			}

			ClassStats stats = HeapUtils.getClassStats(klass, classStatsMap);
			stats.survivorCount++;
			stats.survivorSize += objectSize;
		}

		tty.printf("%n#age    #count  #bytes%n");

		for (int i = 1; i <= maxAge; i++) {
			tty.printf("%3d: %9d %7s%n", i, ageCount[i], FormatUtils.toFloatUnit(ageSize[i]));
		}

		return HeapUtils.getClassStatsList(classStatsMap);
	}
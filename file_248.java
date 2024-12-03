	@SuppressWarnings("unchecked")
	public static <T> List<T> range(Iterable<T> items, int from, int to) {
		U.must(from <= to, "'from' (%s) must be <= 'to' (%s)!", from, to);

		if (from == to) {
			return Collections.emptyList();
		}

		if (items instanceof Results) {
			Results results = (Results) items;
			return results.page(from, to - from);
		}

		List<?> list = (items instanceof List<?>) ? (List<?>) items : U.list(items);

		from = Math.min(from, list.size());
		to = Math.min(to, list.size());

		return U.cast(list.subList(from, to));
	}
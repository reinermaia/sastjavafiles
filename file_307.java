	public static <A> A[] arrayFilter(A[] arr, Predicate<A> accept) {
		if (arr == null || arr.length == 0)
			return arr;
		A[] accepted = newArray(arr, arr.length);
		int j = 0;
		for (int i = 0; i < arr.length; i++)
			if (accept.test(arr[i]))
				accepted[j++] = arr[i];
		return j == arr.length ? arr : copyOf(accepted, j);
	}
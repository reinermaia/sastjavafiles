    protected Find addRange(Find find, Integer start, Integer count) {
        if (start != null) {
            find = find.skip(start);

            if (count != null) {
                find = find.limit(count);
            }
        }

        return find;
    }
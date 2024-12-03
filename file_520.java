    public Long zrevrank(K key, V member) {
        return await(c.zrevrank(key, member));
    }
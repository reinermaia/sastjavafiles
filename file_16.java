    public void addExtractResultItem(ExtractResultItem extractResultItem) {
        List<ExtractResultItem> list = extractResultItems.get(extractResultItem.getField());
        if(list == null){
            list = new ArrayList<>();
            extractResultItems.put(extractResultItem.getField(), list);
        }
        list.add(extractResultItem);
    }
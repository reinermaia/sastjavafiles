    private List<String> convertSort(String sortStr) {
        List<String> list = new ArrayList<String>();
        if(sortStr != null && sortStr.length() != 0){
            list = Arrays.asList(sortStr.split("\\|"));
        }
        return list;
    }
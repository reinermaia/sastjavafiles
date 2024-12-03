    protected List<String> getParentShas(Object commit) {
        Object parents = restClient.getAsObject(commit, "parents");
        Object nodes = restClient.getAsObject(parents, "nodes");
        List<String> parentShas = new ArrayList<>();

        if (nodes instanceof JSONArray) {
            JSONArray parentNodes = (JSONArray) nodes;
            for (Object parentObj : parentNodes) {
                parentShas.add(restClient.getString(parentObj, "oid"));
            }
        }

        return parentShas;
    }
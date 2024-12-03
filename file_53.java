    private int countNonDefaultGroups(String pathTemplate) {
        int count = 0;
        for (String bit : pathTemplate.split("/")) {
            if (bit.startsWith("{") && bit.endsWith("}") && bit.contains(":")) {
                count++;
            }
        }
        return count;
    }
    private Set<String> convertCsvToSet(String csv) {
        // A null line in the file indicates an empty file so return an empty
        // set as it means no APARs were found
        if (csv == null) {
            return Collections.emptySet();
        }

        // If we got this far then we must of found the CSV file so process it
        // to find the APAR IDs
        Set<String> fixPackAparIds = new HashSet<String>();
        String[] aparIds = csv.split(",");
        for (String id : aparIds) {
            fixPackAparIds.add(id);
        }
        return fixPackAparIds;
    }
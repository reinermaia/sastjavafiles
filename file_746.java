    public synchronized void save() {
        if (BulkChange.contains(this)) {
            return;
        }
        
        File file = getConfigFile();
        try {
            List<String> allSignatures = new ArrayList<>(whitelistSignaturesFromUserControlledList);
            blacklistSignaturesFromUserControlledList.stream()
                    .map(signature -> "!" + signature)
                    .forEach(allSignatures::add);
            
            FileUtils.writeLines(file, allSignatures);
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "Failed to save " + file.getAbsolutePath(), e);
        }
    }
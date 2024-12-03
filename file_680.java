    private Map<String, String> parseCSVFile() throws IOException {
        final InputStream inputStream = Files.newInputStream(Paths.get(config.path()));
        final InputStreamReader fileReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        final ImmutableMap.Builder<String, String> newLookupBuilder = ImmutableMap.builder();

        try (final CSVReader csvReader = new CSVReader(fileReader, config.separatorAsChar(), config.quotecharAsChar())) {
            int line = 0;
            int keyColumn = -1;
            int valueColumn = -1;

            while (true) {
                final String[] next = csvReader.readNext();
                if (next == null) {
                    break;
                }
                line++;

                if (line == 1) {
                    // The first line in the CSV file provides the column names
                    int col = 0;
                    for (final String column : next) {
                        if (!isNullOrEmpty(column)) {
                            if (config.keyColumn().equals(column)) {
                                keyColumn = col;
                            }
                            if (config.valueColumn().equals(column)) {
                                valueColumn = col;
                            }
                        }
                        col++;
                    }
                } else {
                    // The other lines are supposed to be data entries
                    if (keyColumn < 0 || valueColumn < 0) {
                        throw new IllegalStateException("Couldn't detect column number for key or value - check CSV file format");
                    }
                    if (config.isCaseInsensitiveLookup()) {
                        newLookupBuilder.put(next[keyColumn].toLowerCase(Locale.ENGLISH), next[valueColumn]);
                    } else {
                        newLookupBuilder.put(next[keyColumn], next[valueColumn]);
                    }
                }
            }
        } catch (Exception e) {
            LOG.error("Couldn't parse CSV file {} (settings separator=<{}> quotechar=<{}> key_column=<{}> value_column=<{}>)", config.path(),
                    config.separator(), config.quotechar(), config.keyColumn(), config.valueColumn(), e);
            setError(e);
        }

        return newLookupBuilder.build();
    }
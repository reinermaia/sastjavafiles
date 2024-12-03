    private List<String[]> readFile(String absolutePath, boolean headerRowOnly) {

        try (InputStream in = new BOMInputStream(new FileInputStream(absolutePath));
                Reader reader = new InputStreamReader(in, pm.getCsvCharset())) {

            RFC4180Parser rfc4180Parser = new RFC4180ParserBuilder().build();
            CSVReaderBuilder csvReaderBuilder = new CSVReaderBuilder(reader)
                    .withCSVParser(rfc4180Parser);

            try (CSVReader csvReader = csvReaderBuilder.build()) {

                if (headerRowOnly) {
                    return Collections.singletonList(csvReader.readNext());
                } else {
                    return csvReader.readAll();
                }

            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
    public String toCsv(Csv... records) {
        if (records != null && records.length > 0) {
            String[] header = records[0].getCsvHeader();
            StringWriter writer = new StringWriter();
            try (CSVPrinter printer = getCSVFormat().withHeader(header).print(writer)) {
                for (Csv record : records) {
                    Object [] data = record.getCsvData();
                    if (data == null || data.length == 0) {
                        log.debug("Skipping null or empty record");
                        continue;
                    }

                    for (Object column : data) {
                        printer.print(objectToString(column));
                    }
                    printer.println();
                }
            } catch (IOException e) {
                log.error("Failed to generate CSV", e);
            }

            return writer.toString();
        }

        return null;
    }
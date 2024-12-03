    public void exportObjects2Excel(List<?> data, List<String> header, String sheetName,
                                    boolean isXSSF, OutputStream os)
            throws IOException {

        try (Workbook workbook = exportExcelBySimpleHandler(data, header, sheetName, isXSSF)) {
            workbook.write(os);
        }
    }
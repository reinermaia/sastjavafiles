    public void exportObjects2Excel(List<?> data, Class clazz, boolean isWriteHeader,
                                    String sheetName, boolean isXSSF, String targetPath)
            throws Excel4JException, IOException {

        try (FileOutputStream fos = new FileOutputStream(targetPath);
             Workbook workbook = exportExcelNoTemplateHandler(data, clazz, isWriteHeader, sheetName, isXSSF)) {
            workbook.write(fos);
        }
    }
    public TableData readCsv(String file) {

        List<String> allLines = new ArrayList<String>();
        try {
            // csvファイルの読み込み
            String text = IOUtils.toString(FileIOUtils.getInputStream(file),
                    FileIOUtils.getFileEncoding());

            // 改行コードでsplitしリストに格納
            for (String line : FileIOUtils.splitToLines(text)) {
                allLines.add(line);
            }

        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

        TableData tableData = new TableData();

        // データヘッダをリストから除外し、schemaに設定
        Map<String, Integer> schema = retriveSchema(allLines.remove(0));
        LOG.debug(MessageManager.getMessage("header"), schema);

        for (int i = 0; i < allLines.size(); i++) {
            RowData row = readRow(schema, allLines.get(i));
            tableData.add(row);

            LOG.debug(MessageManager.getMessage("row.loaded"), i + 1,
                    FileIOUtils.escapeReturn(row));
        }

        LOG.info(MessageManager.getMessage("csv.loaded"), tableData.getRowCount());

        return tableData;
    }
    public void writeExcelFile() throws IOException, WriteException {
        WritableWorkbook excelWrkBook = null;
        int curDsPointer = 0;

        try {
            final String[] columnNames = ds.getColumns();
            final List<String> exportOnlyColumnsList = getExportOnlyColumns() != null ? Arrays.asList(exportOnlyColumns) : null;
            final List<String> excludeFromExportColumnsList = getExcludeFromExportColumns() != null ? Arrays.asList(excludeFromExportColumns) : null;
            final List<String> numericColumnList = getNumericColumns() != null ? Arrays.asList(getNumericColumns()) : new ArrayList<>();
            // get the current position of the DataSet. We have to go to the top
            // to do this write,
            // and we will put the pionter back where it was after we are done
            curDsPointer = ds.getIndex();
            ds.goTop();

            excelWrkBook = Workbook.createWorkbook(xlsFile);
            final WritableSheet wrkSheet = excelWrkBook.createSheet("results", 0);

            final WritableFont times10ptBold = new WritableFont(WritableFont.TIMES, 10, WritableFont.BOLD);
            final WritableFont times10pt = new WritableFont(WritableFont.TIMES, 10, WritableFont.NO_BOLD);
            // write the column headings in the spreadsheet
            WritableCellFormat cellFormat = new WritableCellFormat(times10ptBold);
            int colOffset = 0;
            for (int i = 0; i < columnNames.length; i++) {
                if (exportOnlyColumnsList != null && !exportOnlyColumnsList.contains(columnNames[i])
                        || excludeFromExportColumnsList != null && excludeFromExportColumnsList.contains(columnNames[i])) {
                    colOffset++;
                    continue;
                }

                final Label xlsTextLbl = new Label(i - colOffset, 0, columnNames[i], cellFormat);
                wrkSheet.addCell(xlsTextLbl);
            }

            cellFormat = new WritableCellFormat(times10pt);
            int row = 1;
            while (ds.next()) {
                if (!ds.isRecordID(FPConstants.DETAIL_ID)) {
                    continue;
                }

                colOffset = 0;
                for (int i = 0; i < columnNames.length; i++) {
                    if (exportOnlyColumnsList != null && !exportOnlyColumnsList.contains(columnNames[i])
                            || excludeFromExportColumnsList != null && excludeFromExportColumnsList.contains(columnNames[i])) {
                        colOffset++;
                        continue;
                    }

                    WritableCell wc = null;
                    if (numericColumnList.contains(columnNames[i])) {
                        wc = new Number(i - colOffset, row, ds.getDouble(columnNames[i]), cellFormat);
                    } else {
                        wc = new Label(i - colOffset, row, ds.getString(columnNames[i]), cellFormat);
                    }

                    wrkSheet.addCell(wc);
                }

                row++;
            }

            excelWrkBook.write();

        } finally {
            if (curDsPointer > -1) {
                ds.absolute(curDsPointer);
            }
            if (excelWrkBook != null) {
                excelWrkBook.close();
            }
        }

    }
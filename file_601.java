    public static File exportTemplate() throws FileNotFoundException,
            IOException, InvalidFormatException {
        File template = new File("Template.xls");
        template.createNewFile();
        org.apache.poi.ss.usermodel.Workbook wb = new HSSFWorkbook();
        org.apache.poi.ss.usermodel.Sheet sheet = wb.createSheet();
        wb.setSheetName(0, "Steps");
        int column = 0;
        CellStyle cs = wb.createCellStyle();
        cs.setDataFormat(getBuiltinFormat("text"));
        Font f = wb.createFont();
        f.setFontHeightInPoints((short) 12);
        f.setBold(true);
        f.setColor((short) Font.COLOR_NORMAL);
        cs.setFont(f);
        Row newRow = sheet.createRow(0);
        for (String label : COLUMNS) {
            Cell newCell = newRow.createCell(column);
            newCell.setCellStyle(cs);
            newCell.setCellValue(label);
            column++;
        }

        try (FileOutputStream out = new FileOutputStream(template)) {
            wb.write(out);
            out.close();
        } catch (FileNotFoundException e) {
            LOG.log(Level.SEVERE, null, e);
        } catch (IOException e) {
            LOG.log(Level.SEVERE, null, e);
        }
        return template;
    }
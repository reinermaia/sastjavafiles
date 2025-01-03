  public static void main(String args[]) throws Exception {
    try {
      SheetJS sjs = new SheetJS();

      /* open file */
      SheetJSFile xl = sjs.read_file(args[0]);

      /* get sheetnames */
      String[] sheetnames = xl.get_sheet_names();
      System.err.println(sheetnames[0]);

      /* convert to CSV */
      SheetJSSheet sheet = xl.get_sheet(0);
      String csv = sheet.get_csv();

      System.out.println(csv);

    } catch(Exception e) {
      throw e;
    } finally {
      SheetJS.close();
    }
  }
    public static Report loadDemoReport() throws FileNotFoundException, LoadReportException {
    	String location = DemoUtil.NEXTREPORTS_HOME + File.separator + "output" +
	            File.separator + def.getDatabaseName() + File.separator + "Reports";
		
		String file = location + File.separator + def.getReportName();    	        
        // use "Mike2.report" to test for Arabic characters
        
        Report report = ReportUtil.loadReport(new FileInputStream(file));
        // copy report images if any to directory where exported file is generated : works for HTML export
        // for PDF, RTF & EXCEL export the directory where we copy images must be in the CLASSPATH!
        copyImages(report, location, ".");
        return report;    	
    }
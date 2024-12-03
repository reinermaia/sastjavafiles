    public void exportDataSet(Method method) {
        ExportDataSet exportDataSet = resolveExportDataSet(method);
        if(exportDataSet != null){
            DataSetExportConfig exportConfig = DataSetExportConfig.from(exportDataSet);
            String outputName = exportConfig.getOutputFileName();
            if(outputName == null || "".equals(outputName.trim())){
                outputName = method.getName().toLowerCase()+"."+exportConfig.getDataSetFormat().name().toLowerCase();
            }
            exportConfig.outputFileName(outputName);
            try {
                DataSetExporter.getInstance().export(dataSetExecutor.getRiderDataSource().getDBUnitConnection(),exportConfig);
            } catch (Exception e) {
                log.warn("Could not export dataset after method " + method.getName(), e);
            }
        }
    }
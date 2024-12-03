	@Override
	public RecordReader<Text, SpreadSheetCellDAO> createRecordReader(InputSplit split, TaskAttemptContext ctx) {
	// send configuration option to ms excel. The format of the Excel (old vs new) is detected automaitcally
	ctx.getConfiguration().set(HadoopOfficeReadConfiguration.CONF_MIMETYPE,"ms-excel");
	return new ExcelCellRecordReader(ctx.getConfiguration(), (FileSplit) split);
	}
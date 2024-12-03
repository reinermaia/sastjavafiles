	public boolean isCheckBoxChecked(String text)
	{
		if(config.commandLogging){
			Log.d(config.commandLoggingTag, "isCheckBoxChecked(\""+text+"\")");
		}
		
		return checker.isButtonChecked(CheckBox.class, text);
	}
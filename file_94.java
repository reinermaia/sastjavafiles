	public static CheckBox newCheckBox(final String id, final IModel<Boolean> model)
	{
		final CheckBox checkBox = new CheckBox(id, model);
		checkBox.setOutputMarkupId(true);
		return checkBox;
	}
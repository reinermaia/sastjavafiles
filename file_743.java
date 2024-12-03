	public static void replaceInFile(File file, String regex,
			String replacement)
	{
		replaceInFile(file.getAbsolutePath(), regex, replacement);
	}
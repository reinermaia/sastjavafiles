	public StringBuffer append(Reader source, StringBuffer buffer) throws IOException
	{
		BufferedReader _bufferedReader = new BufferedReader(source);
		char[] _buffer = new char[getBufferSize()]; // load by chunk of 4 ko
		try
		{
			for (int _countReadChars = 0; _countReadChars >= 0;)
			{
				buffer.append(_buffer, 0, _countReadChars);
				_countReadChars = _bufferedReader.read(_buffer);
			}
		}
		finally
		{
			_bufferedReader.close();
		}
		return buffer;
	}
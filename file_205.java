    public static String readTextFile(File file) throws IOException
    {
        //create reader to file (with default encoding)
        InputStream inputStream=new FileInputStream(file);
        Reader reader=IOHelper.createReader(inputStream,null);

        //read text
        String text=IOHelper.readTextStream(reader);
        
        return text;
    }
    public static void concatenate(List<File> files, File concatenatedFile) {

        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(concatenatedFile.getAbsoluteFile(),
                    false), DataUtilDefaults.charSet));

            FileInputStream inputStream;
            for(File input : files) {
                inputStream = new FileInputStream(input);
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                String line;
                while((line = reader.readLine()) != null) {
                    writer.write(line + DataUtilDefaults.lineTerminator);
                }
                inputStream.close();
            }
            writer.flush();
            writer.close();
        } catch (UnsupportedEncodingException e) {
            throw new DataUtilException(e);
        } catch (FileNotFoundException e) {
            throw new DataUtilException(e);
        } catch (IOException e) {
            throw new DataUtilException(e);
        }
    }
    private static String getTextFromStream(InputStream inputStream) throws IOException {
        BufferedReader fileCheck;
        fileCheck = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder fileText = new StringBuilder();
        String line;
        while (null != (line = fileCheck.readLine())) {
            fileText.append(line).append("\n");
        }
        try {
            fileCheck.close();
        } catch (IOException e) {
            // doesn't matter.
        }
        return fileText.toString();
    }
    private static String readTextFile(BufferedReader reader) {
        StringBuilder text = new StringBuilder();

        try {
            char[] buffer = new char[8192]; // default BufferedReader size
            int read;
            while ((read = reader.read(buffer)) >= 0) {
                if (read > 0) {
                    text.append(buffer, 0, read);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return text.toString();
    }
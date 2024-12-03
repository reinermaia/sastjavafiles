    private void replaceInFile(String oldText, String newText) {
        StringBuilder oldContent = new StringBuilder();

        try (FileReader fr = new FileReader(file); BufferedReader reader = new BufferedReader(fr)) {
            String line;
            while ((line = reader.readLine()) != null) {
                oldContent.append(line);
                oldContent.append("\r\n");
            }
        } catch (IOException e) {
            log.error(e);
        }

        // replace a word in a file
        String newContent = oldContent.toString().replaceAll(oldText, newText);

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(newContent);
        } catch (IOException ioe) {
            log.error(ioe);
        }
    }
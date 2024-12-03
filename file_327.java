    public static void writeFile(ArrayList<String> content, String ruleFile) {
        ArrayList<String> output = new ArrayList<String>();
        File file = new File(ruleFile);
        BufferedWriter reader = null;
        try {
            reader = new BufferedWriter(new FileWriter(file));

            // read rules line by line to construct the regular expression
            for (String line : content) {
                reader.write(line + "\n");
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
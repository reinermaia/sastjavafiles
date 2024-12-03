    public boolean replaceStringsInFile(String filePath, Map<String, String> replaceValues, String outputFilePath) {
        String method = "replaceStringsInFile";
        if (filePath == null || filePath.isEmpty()) {
            Log.info(c, method, "No file path provided");
            return false;
        }
        try {
            Log.info(c, method, "Source file name: " + filePath);

            File inp = new File(filePath);
            InputStreamReader inputStream = new InputStreamReader(new FileInputStream(inp));
            BufferedReader dataStream = new BufferedReader(inputStream);

            Vector<String> vec = new Vector<String>(200, 200);

            String currentLine = null;
            boolean changeMade = false;
            while ((currentLine = dataStream.readLine()) != null) {
                for (String key : replaceValues.keySet()) {
                    String origLine = currentLine;
                    String replaceVal = replaceValues.get(key);
                    currentLine = currentLine.replace(key, replaceVal);
                    if (!origLine.equals(currentLine)) {
                        changeMade = true;
                        // comment out for now to reduce size of output.txt
                        //                        Log.info(c, method, "origStr: [" + key + "], newStr: [" + replaceVal + "]");
                        //                        Log.info(c, method, "Before : " + origLine);
                        //                        Log.info(c, method, "After  : " + currentLine);
                    }
                }
                vec.addElement(currentLine);
            }

            dataStream.close();

            if (changeMade) {
                if (outputFilePath == null || outputFilePath.isEmpty()) {
                    Log.info(c, method, "Null or empty output file path provided; will write changes to original file");
                    outputFilePath = filePath;
                }
                Log.info(c, method, "Change detected; writing changes to file: " + outputFilePath);
                OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(outputFilePath));
                PrintWriter ps = new PrintWriter(osw, true);

                int totalLines = vec.size();
                for (int j = 0; j < totalLines; j++) {
                    currentLine = vec.elementAt(j);
                    ps.println(currentLine);
                }
                ps.close();
            } else {
                Log.info(c, method, "No changes detected - file was not written!");
            }
        } catch (Exception e) {
            Log.error(c, method, e);
            return false;
        }
        return true;
    }
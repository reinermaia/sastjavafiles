    protected void renderFile(Map<String, Object> options, File f) throws IOException {
        File filtered = getFilteredVersion(f);
        boolean unfiltered;

        if (filtered == null) {
            // It was not copied.
            getLog().error("Cannot find the filtered version of " + f.getAbsolutePath() + ", " +
                    "using unprocessed file.");
            filtered = f;
            unfiltered = true;
        } else {
            // It was copied.
            unfiltered = false;
        }

        instance.renderFile(filtered, options);

        // Move the file to the expected place if not filtered
        if (unfiltered) {
            String name = filtered.getName().substring(0, filtered.getName().lastIndexOf(".")) + ".html";
            File output = new File(filtered.getParentFile(), name);
            if (output.isFile()) {
                // Move...
                File finalFile = getOutputFile(filtered, "html");
                FileUtils.moveFile(output, finalFile);
            } else {
                getLog().error("Cannot find the output file for " + filtered.getAbsolutePath());
            }
        }
    }
    private static String invertFilename(File file, String compression) {
        // first invert the filename
        String[] name = StringUtils.split(file.getName(), '.');
        if (name.length < 2)
            return null;
        String extension = name[name.length - 1];
        boolean compressed = false;
        if (extension.equalsIgnoreCase("gz")) {
            extension = name[name.length - 2];
            compressed = true;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < (compressed ? name.length - 2 : name.length - 1); i++)
            result.append(name[i]).append(".");
        result.append(extension.equalsIgnoreCase("xml") ? "txt" : "xml");
        if (compressed)
            result.append(".gz");

        // then update the extension using the requested compression
        String newName = result.toString();
        if ("gz".equals(compression)) {
            if (newName.endsWith(".xz"))
                newName = newName.replace(".xz", "");
            if (!newName.endsWith(".gz"))
                newName = newName + ".gz";
        }
        else if ("xz".equals(compression)) {
            if (newName.endsWith(".gz"))
                newName = newName.replace(".gz", "");
            if (!newName.endsWith(".xz"))
                newName = newName + ".xz";
        }
        else if ("none".equals(compression)) {
            if (newName.endsWith(".gz"))
                newName = newName.replace(".gz", "");
            else if (newName.endsWith(".xz"))
                newName = newName.replace(".xz", "");
        }

        return new File(file.getParentFile(), newName).getName();
    }
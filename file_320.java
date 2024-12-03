    private void advance() throws IOException {
        if (!entries.hasNext()) {
            if (!files.hasNext()) {
                next = null;
                return;
            }
            File file = files.next();
            if (hasExtension(file.getName(), ".jar")) {
                ZipFile zip = new JarFile(file);
                zips.add(zip);
                entries = new ZipIterator(zip);
            } else if (hasExtension(file.getName(), ".zip")) {
                ZipFile zip = new ZipFile(file);
                zips.add(zip);
                entries = new ZipIterator(zip);
            } else if (file.isDirectory()) {
                entries = new FileIterator(file);
            } else {
                throw new IllegalArgumentException("Do not know how to handle " + file);
            }
        }

        boolean foundClass = false;
        while (!foundClass && entries.hasNext()) {
          next = entries.next();
          foundClass = isClass(next.getName());
        }
        if (!foundClass) {
          advance();
        }
    }
    public static String concatFilePath(boolean _includeTrailingDelimiter, String..._parts) {
        if (_parts == null) {
            return null;
        }
        StringBuilder allParts = new StringBuilder();

        for (int i = 0; i < _parts.length; i++) {
            if (_parts[i] == null) {
                continue;
            }
            allParts.append(_parts[i]);

            if (!_parts[i].endsWith(File.separator)) {
                allParts.append(File.separator);
            }
        }

        if (!_includeTrailingDelimiter && allParts.length() > 0) {
            return allParts.substring(0, allParts.lastIndexOf(File.separator));
        }

        return allParts.toString();
    }
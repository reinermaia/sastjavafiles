    public static String createUniqueName(XNameAccess _xElementContainer, String _sElementName) {
        boolean bElementexists = true;
        int i = 1;
        String sIncSuffix = "";
        String BaseName = _sElementName;
        while (bElementexists) {
            bElementexists = _xElementContainer.hasByName(_sElementName);
            if (bElementexists) {
                i += 1;
                _sElementName = BaseName + Integer.toString(i);
            }
        }
        return _sElementName;
    }
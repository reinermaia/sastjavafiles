    public int getDimension(DependencyPath path) {
        String endToken = path.last().word();

        // Extract out how the current word is related to the last word in the
        // path.  
        String relation = path.getRelation(path.length() - 1);
        return getDimensionInternal(endToken + "+" + relation);
    }
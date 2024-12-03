    private int findToken(String token, int integer, int location) {
        int index = location - 1;
        while (index >= 0) {
            Object o = parserList.get(index);
            if (o instanceof DroolsToken) {
                if ("(".equals(((DroolsToken) o).getText())) {
                	if (getNextInteger(index) == integer){
                		return index;
                	}
//                    o = parserList.get(index + 1);
//                    if (o instanceof Integer) {
//                        if (integer == (Integer) o) {
//                            return index;
//                        }
//                    }
                }
            }
            index--;
        }
        return -1;
    }
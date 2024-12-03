    public XMLElement getParentElement() {
        XMLNode parent = getParentNode();
        if (parent != null && parent.getInner().getNodeType() == Node.ELEMENT_NODE) {
            return (XMLElement) parent;
        }
        return null;
    }
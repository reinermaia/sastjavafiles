    @Override
    XMLList children() {
        XMLList rv = newXMLList();
        XMLName all = XMLName.formStar();
        rv.setTargets(this, all.toQname());
        XmlNode[] children = this.node.getMatchingChildren(XmlNode.Filter.TRUE);
        for (int i=0; i<children.length; i++) {
            rv.addToList( toXML(children[i]) );
        }
        return rv;
    }
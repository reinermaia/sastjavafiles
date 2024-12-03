    XML xmlFromNode(XmlNode node) {
        if (node.getXml() == null) {
            node.setXml( newXML(node) );
        }
        return node.getXml();
    }
    private static List<OSMNode> getNodes(NodeList children, Map<String, OSMNode> nodes) {
        List<OSMNode> result = new ArrayList<OSMNode>();

        Node node;
        String nodeName;
        
        for (int i = 0; i < children.getLength(); i++) {
            
            node = children.item(i);
            nodeName = node.getNodeName();

            if (nodeName.equals("nd")) {

                result.add(nodes.get(node.getAttributes().
                        getNamedItem("ref").getNodeValue()));
                
            }
        }

        return result;
    }
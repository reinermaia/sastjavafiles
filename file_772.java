  public static void main(String[] args) throws Exception {
    StringBuffer prettyPrint = new StringBuffer();
    prettyPrint.append("             0\n");
    prettyPrint.append("            /|\\\n");
    prettyPrint.append("           / | \\\n");
    prettyPrint.append("          1  2  1\n");
    prettyPrint.append("         / \\    |\\ \n");
    prettyPrint.append("        /   \\   | \\ \n");
    prettyPrint.append("      4     5   6  7 \n");
    prettyPrint.append("               /|\\ \n");
    prettyPrint.append("              / | \\ \n");
    prettyPrint.append("             8  9  10 \n");

    System.out.println("Constructing tree:\n" + prettyPrint.toString());

    prettyPrint.delete(0, prettyPrint.length());
    prettyPrint.append("             0 \n");
    prettyPrint.append("            / \\ \n");
    prettyPrint.append("           /   \\ \n");
    prettyPrint.append("          1     2 \n");
    prettyPrint.append("         /|\\  \n");
    prettyPrint.append("        / | \\ \n");
    prettyPrint.append("       /  | |\\ \n");
    prettyPrint.append("      /   | | \\ \n");
    prettyPrint.append("     4    5 6  7 \n");
    prettyPrint.append("           /|\\ \n");
    prettyPrint.append("          / | \\ \n");
    prettyPrint.append("         8  9  10 \n");

    System.out.println("Assuming tree:\n" + prettyPrint.toString());

    ITreeNode root = new TreeNodeUniqueChildren(new Integer(0), new ITreeNode[] {
        new DefaultTreeNode(new Integer(1), new ITreeNode[] {new DefaultTreeNode(new Integer(4)),
            new DefaultTreeNode(new Integer(5)) }),
        new DefaultTreeNode(new Integer(2)),
        new DefaultTreeNode(new Integer(1), new ITreeNode[] {
            new DefaultTreeNode(new Integer(6), new ITreeNode[] {
                new DefaultTreeNode(new Integer(8)), new DefaultTreeNode(new Integer(9)),
                new DefaultTreeNode(new Integer(10)) }), new DefaultTreeNode(new Integer(7)) })

    });
    System.out.println("The tree:");
    System.out.println(root.toString());
  }
    public void visit(ListItemNode node) {
        if (node instanceof TaskListNode) {
            // vsch: #185 handle GitHub style task list items, these are a bit messy because the <input> checkbox needs to be
            // included inside the optional <p></p> first grand-child of the list item, first child is always RootNode
            // because the list item text is recursively parsed.
            Node firstChild = node.getChildren().get(0).getChildren().get(0);
            boolean firstIsPara = firstChild instanceof ParaNode;
            int indent = node.getChildren().size() > 1 ? 2 : 0;
            boolean startWasNewLine = printer.endsWithNewLine();

            printer.println().print("<li class=\"task-list-item\">").indent(indent);
            if (firstIsPara) {
                printer.println().print("<p>");
                printer.print("<input type=\"checkbox\" class=\"task-list-item-checkbox\"" + (((TaskListNode) node).isDone() ? " checked=\"checked\"" : "") + " disabled=\"disabled\"></input>");
                visitChildren((SuperNode) firstChild);

                // render the other children, the p tag is taken care of here
                visitChildrenSkipFirst(node);
                printer.print("</p>");
            } else {
                printer.print("<input type=\"checkbox\" class=\"task-list-item-checkbox\"" + (((TaskListNode) node).isDone() ? " checked=\"checked\"" : "") + " disabled=\"disabled\"></input>");
                visitChildren(node);
            }
            printer.indent(-indent).printchkln(indent != 0).print("</li>")
                    .printchkln(startWasNewLine);
        } else {
            printConditionallyIndentedTag(node, "li");
        }
    }
    private ObservableList<Node> getParentChildren(Parent parent){
        try {
            return (ObservableList<Node>) parentChildrenField.get(parent);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
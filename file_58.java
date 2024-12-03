    private void addErrorLabel(Validator validator, Label label, Widget widget) {
        errors.put(label, widget); // keep a list of the errors for easily iteration later
        validatorLabels.put(validator, label); // connect the label and the validator
    }
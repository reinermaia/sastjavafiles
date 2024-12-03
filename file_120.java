    public Widget asWidget() {
        TextBoxItem name = new TextBoxItem("name", "Name", true);
        ComboBoxItem baseRole = new ComboBoxItem("baseRole", "Base Role");
        baseRole.setDefaultToFirstOption(true);
        Collection<String> roleNames = Collections2.transform(StandardRole.values(), StandardRole::getId);
        baseRole.setValueMap(roleNames);

        ComboBoxItem type = new ComboBoxItem("type", "Type");
        type.setDefaultToFirstOption(true);
        type.setValueMap(new String[]{"Host", "Server Group"});

        ListItem scope = new ListItem("scope", "Scope");
        scope.setRequired(true);
        CheckBoxItem includeAll = new CheckBoxItem("includeAll", "Include All");

        Form<RoleBean> form = new Form<>(RoleBean.class);
        if (scoped) {
            form.setFields(name, baseRole, type, scope, includeAll);
        } else {
            form.setFields(name, includeAll);
        }
        if (this.existingRole != null) {
            name.setEnabled(false);
            type.setEnabled(false);
            form.edit(modelToBean(existingRole));
        }

        form.addFormValidator((formItems, outcome) -> {
            if (existingRole == null && duplicateNameAndType(beanToModel(form.getUpdatedEntity()))) {
                outcome.addError("name");
                name.setErrMessage("Role already exists");
                name.setErroneous(true);
            }
        });

        VerticalPanel layout = new VerticalPanel();
        layout.setStyleName("window-content");
        layout.add(new HelpPanel().asWidget());
        layout.add(form.asWidget());

        DialogueOptions options = new DialogueOptions(
                event -> {
                    FormValidation validation = form.validate();
                    if (!validation.hasErrors()) {
                        if (existingRole == null) {
                            circuit.dispatch(new AddScopedRole(beanToModel(form.getUpdatedEntity())));
                        } else if (existingRole.isScoped()) {
                            circuit.dispatch(new ModifyScopedRole(beanToModel(form.getUpdatedEntity())));
                        } else {
                            circuit.dispatch(new ModifyStandardRole(beanToModel(form.getUpdatedEntity())));
                        }
                        presenter.closeWindow();
                    }
                },
                event -> presenter.closeWindow()
        );

        return new WindowContentBuilder(layout, options).build();
    }
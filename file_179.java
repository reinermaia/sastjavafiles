    public void check() {
        getDispatcher().beforeCheck(this);
        
        RemoteWebElement e = (RemoteWebElement) getElement();
        while (!e.isSelected()) {
            e.click();
        }
        if (Config.getBoolConfigProperty(ConfigProperty.ENABLE_GUI_LOGGING)) {
            logUIAction(UIActions.CHECKED);
        }
        
        getDispatcher().afterCheck(this);
    }
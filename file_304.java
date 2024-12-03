    public static void initializeCDI(Application application){
        JSFExtensionFactory factory = instance.get();
        if(factory != null){
            if(factory.cdiJSFInitializerService != null){
                CDIJSFInitializer cdiInitializer = factory.cdiJSFInitializerService.getService();
                if(cdiInitializer != null){
                    cdiInitializer.initializeCDIJSFELContextListenerAndELResolver(application);
                    cdiInitializer.initializeCDIJSFViewHandler(application);
                }
            }
        }
    }
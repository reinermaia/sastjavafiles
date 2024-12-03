    public void init(String pin) {
        keygen.setWallet(getDescriptor(false));
        log.info( "Initializing wallet: " + descriptor.key + " pin enabled: " + pinEnabled);
        try {
            keygen.init(pinEnabled, pinSalt, pin);
        } catch (Exception e) {
            System.out.println("Error while initializing Keygen...");
            log.error("Error initializing wallet: " + descriptor.key + " pin enabled: " + pinEnabled);
        }
    }
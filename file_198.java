    public static boolean isCheckBoxChecked(String text) throws Exception {
        return Client.getInstance().map(Constants.ROBOTIUM_SOLO, "isCheckBoxChecked", text).getBoolean(0);
    }
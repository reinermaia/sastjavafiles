    protected boolean setCustom(Boolean isResponse, String pathName, String custom) {
        // first remove the custom entry for this path if it is the custom request
        if (!isResponse) {
            this.removeCustomRequest(pathName);
        }

        // now add it(-1 is the custom response identifier)
        if (isResponse) {
            this.addMethodToResponseOverride(pathName, "-1");
        } else {
            this.addMethodToResponseOverride(pathName, "-2");
        }

        // now set the string
        String command = "customResponse";
        if (!isResponse) {
            command = "customRequest";
        }

        try {
            BasicNameValuePair[] params = {
                new BasicNameValuePair(command, custom),
                new BasicNameValuePair("profileIdentifier", this._profileName)
            };

            JSONObject response = new JSONObject(doPost(BASE_PATH + uriEncode(pathName), params));

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
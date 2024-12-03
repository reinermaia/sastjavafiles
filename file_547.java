    private void outputLicenseRestrictionMessage() {
        try {
            // TODO need to work out how to strip the IBM branding knowledge out of here.
            ProductInfo pi = ProductInfo.getAllProductInfo().get("com.ibm.websphere.appserver");
            if (pi != null && pi.getReplacedBy() == null) {
                String edition = String.valueOf(pi.getEdition()).toLowerCase();
                String licenseType = String.valueOf(pi.getProperty("com.ibm.websphere.productLicenseType")).toLowerCase();
                String key = "audit.licenseRestriction." + edition + '.' + licenseType;
                ResourceBundle rb = TraceNLS.getBaseResourceBundle(FrameworkManager.class, tc.getResourceBundleName());
                if (rb.containsKey(key)) {
                    String file = getLang(Locale.getDefault()) + ".html";
                    Tr.audit(tc, key, "https://public.dhe.ibm.com/ibmdl/export/pub/software/websphere/wasdev/license/" +
                                      edition + '/' + licenseType + '/' + pi.getVersion() + "/lafiles/" + file);
                }
            }
        } catch (ProductInfoParseException e) {
        } catch (DuplicateProductInfoException e) {
        } catch (ProductInfoReplaceException e) {
        }
    }
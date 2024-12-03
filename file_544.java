  static void readWmoXmlTableB(InputStream ios, TableB b) throws IOException {
    org.jdom2.Document doc;
    try {
      SAXBuilder builder = new SAXBuilder();
      doc = builder.build(ios);
    } catch (JDOMException e) {
      throw new IOException(e.getMessage());
    }

    Element root = doc.getRootElement();

    String[] elems = null;
    for (Version v : Version.values()) {
      elems = v.getElemNamesB();
      List<Element> featList = root.getChildren(elems[0]);
      if (featList != null && featList.size() > 0) {
        break;
      }
    }

    // if not found using element name, assume its BUFR_WMO
    if (elems == null) {
      elems = Version.BUFR_WMO.getElemNamesB();
    }

    List<Element> featList = root.getChildren();
    for (Element elem : featList) {
      Element ce = elem.getChild(elems[1]);
      if (ce == null) continue;

      String name = Util.cleanName(elem.getChildTextNormalize(elems[1]));
      String units = cleanUnit(elem.getChildTextNormalize("BUFR_Unit"));
      int x = 0, y = 0, scale = 0, reference = 0, width = 0;

      String fxy = null;
      String s = null;
      try {
        fxy = elem.getChildTextNormalize("FXY");
        int xy = Integer.parseInt(cleanNumber(fxy));
        x = xy / 1000;
        y = xy % 1000;

      } catch (NumberFormatException e) {
        System.out.printf(" key %s name '%s' fails parsing %n", fxy, name);
      }

      try {
        s = elem.getChildTextNormalize("BUFR_Scale");
        scale = Integer.parseInt(cleanNumber(s));
      } catch (NumberFormatException e) {
        System.out.printf(" key %s name '%s' has bad scale='%s'%n", fxy, name, s);
      }

      try {
        s = elem.getChildTextNormalize("BUFR_ReferenceValue");
        reference = Integer.parseInt(cleanNumber(s));
      } catch (NumberFormatException e) {
        System.out.printf(" key %s name '%s' has bad reference='%s' %n", fxy, name, s);
      }

      try {
        s = elem.getChildTextNormalize("BUFR_DataWidth_Bits");
        width = Integer.parseInt(cleanNumber(s));
      } catch (NumberFormatException e) {
        System.out.printf(" key %s name '%s' has bad width='%s' %n", fxy, name, s);
      }

      b.addDescriptor((short) x, (short) y, scale, reference, width, name, units, null);
    }
    ios.close();
  }
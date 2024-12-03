  public Bioml parse() throws FileParsingException {
    //ClassLoader classLoaderOrig = Thread.currentThread().getContextClassLoader();
    try {

      //String filePath = "D:\\projects\\GPMDB\\gpm-xml-parser\\GPM32310000038_indented_cropped.xml";
      //String filePath = "D:\\projects\\GPMDB\\gpm-xml-parser\\GPM64510013519.xml";
      Path filePath = Paths.get(this.getPath());
      FileInputStream fis = new FileInputStream(filePath.toFile());
      BufferedInputStream bis = new BufferedInputStream(fis, 1024 * 1024 * 32); // 32 MB buffer

      Class<Bioml> clazz = Bioml.class;

      JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
      Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
      Object unmarshalled = unmarshaller.unmarshal(bis);

      Bioml bioml = convertJAXBObjectToDomain(clazz, unmarshalled);
      return bioml;

    } catch (JAXBException | FileNotFoundException e) {
      throw new FileParsingException(e);
    } finally {
//            Thread.currentThread().setContextClassLoader(classLoaderOrig);
    }
  }
  private PackageData parseDataFromSourceFile(InputFile file) throws IOException {
    PackageDataBuilder builder = new PackageDataBuilder();
    String pkgInfo = fileUtil.readFile(file);

    // @ObjectiveCName
    int i = pkgInfo.indexOf("@ObjectiveCName");
    if (i == -1) {
      i = pkgInfo.indexOf("@com.google.j2objc.annotations.ObjectiveCName");
    }
    if (i > -1) {
      // Extract annotation's value string.
      i = pkgInfo.indexOf('"', i + 1);
      if (i > -1) {
        int j = pkgInfo.indexOf('"', i + 1);
        if (j > -1) {
          builder.setObjectiveCName(pkgInfo.substring(i + 1, j));
        }
      }
    }

    // @ParametersAreNonnullByDefault
    if (pkgInfo.contains("@ParametersAreNonnullByDefault")
        || pkgInfo.contains("@javax.annotation.ParametersAreNonnullByDefault")) {
      builder.setParametersAreNonnullByDefault();
    }

    // @ReflectionSupportLevel
    if (hasAnnotation(pkgInfo, "com.google.j2objc.annotations.ReflectionSupport")) {
      Pattern p = Pattern.compile(REFLECTION_SUPPORT_REGEX);
      Matcher m = p.matcher(pkgInfo);
      if (m.find()) {
        String level = m.group(1);
        builder.setReflectionSupportLevel(ReflectionSupport.Level.valueOf(level));
      } else {
        ErrorUtil.warning("Invalid ReflectionSupport Level in " + file.getUnitName());
      }
    }
    return builder.build();
  }
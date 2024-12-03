  public void connect(String line, DispatchCallback callback) throws Exception {
    String example = "Usage: connect <url> <username> <password> [driver]"
        + SqlLine.getSeparator();

    String[] parts = sqlLine.split(line);
    if (parts == null) {
      callback.setToFailure();
      return;
    }

    Properties connectProps = new Properties();
    int offset = 1;
    for (int i = 1; i < parts.length; i++) {
      if ("-p".equals(parts[i])) {
        if (parts.length - i > 2) {
          connectProps.setProperty(parts[i + 1], parts[i + 2]);
          i = i + 2;
          offset += 3;
        } else {
          callback.setToFailure();
          sqlLine.error(example);
          return;
        }
      }
    }
    if (parts.length - offset < 2) {
      callback.setToFailure();
      sqlLine.error(example);
      return;
    }

    String url = parts.length < offset + 1 ? null : parts[offset];
    String user = parts.length < offset + 2 ? null : parts[offset + 1];
    String pass = parts.length < offset + 3 ? null : parts[offset + 2];
    String driver = parts.length < offset + 4 ? null : parts[offset + 3];
    Properties props = new Properties();
    if (url != null) {
      props.setProperty("url", url);
    }
    if (driver != null) {
      props.setProperty("driver", driver);
    }
    if (user != null) {
      props.setProperty("user", user);
    }
    if (pass != null) {
      props.setProperty("password", pass);
    }
    if (!connectProps.isEmpty()) {
      props.put(CONNECT_PROPERTY, connectProps);
    }
    connect(props, callback);
  }
  public void save() {
    if (catListBox != null) catListBox.save();

    if (prefs != null) {
      if (fileChooser != null)
        fileChooser.save();
      if (catgenFileChooser != null)
        catgenFileChooser.save();
      prefs.putInt(HDIVIDER, split.getDividerLocation());
    }
  }
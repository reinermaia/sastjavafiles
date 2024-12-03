  public Text read() throws IOException {
    if (this.mCurrentReader == null) {
      updateReader();
    }
    Text ret = this.mCurrentReader.read();
    if (ret != null)
      return ret;

    this.mCurrentIndex++;
    if (this.mCurrentIndex < this.mFiles.size()) {
      this.updateReader();
      return read();
    }

    return null;
  }
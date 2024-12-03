  public boolean copyTopicsToClipboard(final boolean cut, @Nonnull @MustNotContainNull final Topic... topics) {
    boolean result = false;

    if (this.lockIfNotDisposed()) {
      try {
        if (topics.length > 0) {
          final Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
          clipboard.setContents(new MMDTopicsTransferable(topics), this);

          if (cut) {
            deleteTopics(true, ensureNoRootInArray(topics));
          }

          result = true;
        }
      } finally {
        this.unlock();
      }
    }

    return result;
  }
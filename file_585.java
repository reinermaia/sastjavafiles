    public void read() throws Exception {
      long endTime = System.currentTimeMillis() + rtc.max_time;
      while (System.currentTimeMillis() < endTime) {
        // Randomly pick a datanode from victims
        int idx = rb.nextInt(rtc.victims.length);
        // Randomly pick a file to read
        ArrayList<Path> fileList = nsPickLists.get(rtc.victims[idx].getHostName()); 
        int fid = rb.nextInt(fileList.size());
        Path readFile = fileList.get(fid); 
        FSDataInputStream in = null;
        try {
          in = fs.open(readFile);
          if (in.isUnderConstruction()) {
            LOG.info("file " + readFile + " is still open");
          }
          FileStatus fileStatus = fs.getFileStatus(readFile);
          long offset = rb.nextInt((int)Math.max(
              fileStatus.getLen() - rtc.buffer_size, 0) + 1);
          int size = 0;
          in.seek(offset);
          size = in.read(buffer, 0, rtc.buffer_size);
          if (size < 0) {
            continue;
          }
          processed_size += size;
          read_size += size;
          LOG.info("Read file " + readFile + " from " + 
              offset + " to " + (offset + size));
        } catch (Exception e) { 
          LOG.error("Error in read file: " + readFile, e);
          this.errors.add(e);
        } finally {
          IOUtils.closeStream(in);
        }
        files_processed++;
        Thread.sleep(5);
      }
    }
	void copyFile(boolean deletesrc, byte[]src, byte[] dst, CopyOption... options)
        throws IOException
    {
		checkWritable();
        if (Arrays.equals(src, dst))
            return;    // do nothing, src and dst are the same

        beginWrite();
        try {
            ensureOpen();
            org.apache.hadoop.fs.Path eSrc_path = new HadoopPath(this, src).getRawResolvedPath();
            FileStatus eSrc = this.fs.getFileStatus(eSrc_path);
            if (!this.fs.exists(eSrc_path))
                throw new NoSuchFileException(getString(src));
            if (eSrc.isDirectory()) {    // specification says to create dst directory
                createDirectory(dst);
                return;
            }
            boolean hasReplace = false;
            boolean hasCopyAttrs = false;
            for (CopyOption opt : options) {
                if (opt == REPLACE_EXISTING)
                    hasReplace = true;
                else if (opt == COPY_ATTRIBUTES)
                    hasCopyAttrs = true;
            }
            org.apache.hadoop.fs.Path eDst_path = new HadoopPath(this, dst).getRawResolvedPath();
//            FileStatus eDst = this.fs.getFileStatus(eDst_path); //if eDst_path not exist, it will throw an error
    
            if (fs.exists(eDst_path)) {
                if (!hasReplace)
                    throw new FileAlreadyExistsException(getString(dst));

                if(!fs.delete(eDst_path, false)) {
                	throw new AccessDeniedException("cannot delete hdfs file " + getString(dst));
                }
            } else {
                //checkParents(dst);
            }
            
            //Simply use FileUtil.copy here. Can we use DistCp for very big files here? zongjie@novelbio.com
            boolean isCanDeleteSourceFile = FileUtil.copy(fs, eSrc_path, fs, eDst_path, deletesrc, fs.getConf());
            if (!isCanDeleteSourceFile) {
            	throw new AccessDeniedException("cannot delete source file " + eSrc_path.toString());
            }
            
//            org.apache.hadoop.fs.Path[] srcs = new org.apache.hadoop.fs.Path[] {eSrc_path};
//			this.fs.concat(eDst_path, srcs);
            
            /*
            Entry u = new Entry(eSrc, Entry.COPY);    // copy eSrc entry
            u.name(dst);                              // change name
            if (eSrc.type == Entry.NEW || eSrc.type == Entry.FILECH)
            {
                u.type = eSrc.type;    // make it the same type
                if (!deletesrc) {      // if it's not "rename", just take the data
                    if (eSrc.bytes != null)
                        u.bytes = Arrays.copyOf(eSrc.bytes, eSrc.bytes.length);
                    else if (eSrc.file != null) {
                        u.file = getTempPathForEntry(null);
                        Files.copy(eSrc.file, u.file, REPLACE_EXISTING);
                    }
                }
            }
            if (!hasCopyAttrs)
                u.mtime = u.atime= u.ctime = System.currentTimeMillis();
            update(u);
            if (deletesrc)
                updateDelete(eSrc);*/
        } finally {
            endWrite();
        }
    }
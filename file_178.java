    public void save(@NonNull File meanFile, @NonNull File stdFile) throws IOException {
        Nd4j.saveBinary(getMean(), meanFile);
        Nd4j.saveBinary(getStd(), stdFile);
    }
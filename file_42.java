    private void readObject(java.io.ObjectInputStream in)
     throws IOException, ClassNotFoundException
    {
        this.timezoneSensitive = in.readBoolean();
        long time = in.readLong();
        if (!this.timezoneSensitive)
        {
            // convert the time from UTC to local
            int offset = getDefaultOffset(this);
            time -= offset;
        }
        this.setTime(time);
        this.setNanos(in.readInt());
    }
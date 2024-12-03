    public <T> T render(Class<T> bean) throws Exception {
        if (bodyType.equals(BodyType.TEXT)) {
            return parse(bean, this.content);
        } else {
            throw new SeimiProcessExcepiton("can not parse struct from binary");
        }
    }
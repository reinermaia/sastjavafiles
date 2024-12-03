    public String valueNumberToString(ValueNumber vn, FlowValue value ) {
        StringBuilder buf = new StringBuilder();

        buf.append(vn.getNumber());
        buf.append("->");

        buf.append(value);
        if (value != FlowValue.TOP) {
            Set<? extends SourceSinkInfo> always = getSourceSinkInfoSet(whereAlways, vn);
            Set<? extends SourceSinkInfo> never = getSourceSinkInfoSet(whereNever, vn);
            if (value != FlowValue.UNKNOWN || !always.equals(never)) {
                buf.append("[");
                if (!always.isEmpty()) {
                    appendSourceSinkInfos(buf, "YES=", always);
                }
                if (!always.isEmpty() && !never.isEmpty()) {
                    buf.append(",");
                }
                if (!never.isEmpty()) {
                    appendSourceSinkInfos(buf, "NO=", never);
                }
                buf.append("]");
            }
        }

        return buf.toString();
    }
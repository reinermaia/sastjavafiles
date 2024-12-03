    static BigDecimal toBigDecimal(Oid oid, String value) {
        switch (oid) {
            case UNSPECIFIED: // fallthrough
            case INT2: // fallthrough
            case INT4: // fallthrough
            case INT8: // fallthrough
            case NUMERIC: // fallthrough
            case FLOAT4: // fallthrough
            case FLOAT8:
                return new BigDecimal(value);
            default:
                throw new SqlException("Unsupported conversion " + oid.name() + " -> BigDecimal");
        }
    }
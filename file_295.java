    public static BigDecimal decimalPart(final BigDecimal val) {
        return BigDecimalUtil.subtract(val, val.setScale(0, BigDecimal.ROUND_DOWN));
    }
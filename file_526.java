    public static ConfusionMatrix createCumulativeMatrix(ConfusionMatrix... matrices)
    {
        ConfusionMatrix result = new ConfusionMatrix();

        for (ConfusionMatrix matrix : matrices) {
            for (Map.Entry<String, Map<String, Integer>> gold : matrix.map.entrySet()) {
                for (Map.Entry<String, Integer> actual : gold.getValue().entrySet()) {
                    result.increaseValue(gold.getKey(), actual.getKey(), actual.getValue());
                }
            }
        }

        return result;
    }
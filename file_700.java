    public ConfusionMatrix getTransposedMatrix()
    {
        ConfusionMatrix result = new ConfusionMatrix();

        for (Map.Entry<String, Map<String, Integer>> gold : this.map.entrySet()) {
            for (Map.Entry<String, Integer> predicted : gold.getValue().entrySet()) {
                int value = predicted.getValue();

                // add reverted values
                result.increaseValue(predicted.getKey(), gold.getKey(), value);
            }
        }

        return result;
    }
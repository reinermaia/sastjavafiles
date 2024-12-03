    protected void printResultSummary(ResultsSummary s, List<FeatureToken> featuresList) {
        new FailureSummaryWriter().printFailureSummary(featuresList, this::printMessage);
        new ResultSummaryWriter().printResultSummary(s, this::printMessage);
    }
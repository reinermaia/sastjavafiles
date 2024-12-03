  private static void summarizeDeepLearningModel(ModelSummary summary, hex.deeplearning.DeepLearningModel model) {
    // add generic fields such as column names
    summarizeModelCommonFields(summary, model);

    summary.model_algorithm = "DeepLearning";

    JsonObject all_params = (model.get_params()).toJSON();
    summary.critical_parameters = whitelistJsonObject(all_params, DL_critical_params);
    summary.secondary_parameters = whitelistJsonObject(all_params, DL_secondary_params);
    summary.expert_parameters = whitelistJsonObject(all_params, DL_expert_params);
  }
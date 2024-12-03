  private static void summarizeNBModel(ModelSummary summary, hex.nb.NBModel model) {
    // add generic fields such as column names
    summarizeModelCommonFields(summary, model);

    summary.model_algorithm = "Naive Bayes";

    JsonObject all_params = (model.get_params()).toJSON();
    summary.critical_parameters = whitelistJsonObject(all_params, NB_critical_params);
    summary.secondary_parameters = whitelistJsonObject(all_params, NB_secondary_params);
    summary.expert_parameters = whitelistJsonObject(all_params, NB_expert_params);
  }
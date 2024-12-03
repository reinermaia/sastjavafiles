  private static void summarizeGLMModel(ModelSummary summary, hex.glm.GLMModel model) {
    // add generic fields such as column names
    summarizeModelCommonFields(summary, model);

    summary.model_algorithm = "GLM";

    JsonObject all_params = (model.get_params()).toJSON();
    summary.critical_parameters = whitelistJsonObject(all_params, GLM_critical_params);
    summary.secondary_parameters = whitelistJsonObject(all_params, GLM_secondary_params);
    summary.expert_parameters = whitelistJsonObject(all_params, GLM_expert_params);
  }
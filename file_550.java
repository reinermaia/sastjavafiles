  public static Map<String, ModelSummary> generateModelSummaries(Set<String>keys, Map<String, Model> models, boolean find_compatible_frames, Map<String, Frame> all_frames, Map<String, Set<String>> all_frames_cols) {
      Map<String, ModelSummary> modelSummaries = new TreeMap<String, ModelSummary>();

      if (null == keys) {
        keys = models.keySet();
      }

      for (String key : keys) {
        ModelSummary summary = new ModelSummary();
        Models.summarizeAndEnhanceModel(summary, models.get(key), find_compatible_frames, all_frames, all_frames_cols);
        modelSummaries.put(key, summary);
      }

      return modelSummaries;
  }
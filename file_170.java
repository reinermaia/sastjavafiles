   @Override
   public long lastUsed() {
      return params.find(MetaLastUsed.class).map(ml -> ml.get()).orElse(0L);
   }
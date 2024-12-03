  @Override
  public void exitStandardFileOptionOptimizeFor(final StandardFileOptionOptimizeForContext ctx) {
    verifyOptionNameUnique("optimizeFor", ctx.getStart());
    scopes.getFileOptions().setOptimizeFor(OptimizeMode.valueOf(ctx.optimizeMode().getText()));
  }
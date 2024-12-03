    public boolean doOptimization(OptimizedTagContext context) {
        boolean optimize = false;
        if (context.getParent() != null && context.getParent() instanceof JSTLChooseOptimizedTag) {
            optimize = true;
        }
        return optimize;
    }
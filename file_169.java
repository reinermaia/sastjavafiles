    public boolean doOptimization(OptimizedTagContext context) {
        boolean optimize = true;
        
        if (context.isJspAttribute("var")) {
            optimize = false;
        }
        else if (context.isJspAttribute("test")) {
            optimize = false;
        }
        
        return optimize;
    }
    public boolean doOptimization(OptimizedTagContext context) {
        boolean optimize = true;
        
        if (context.hasAttribute("varStatus")) {
            optimize = false;
        }
        else if (context.isJspAttribute("var")) {
            optimize = false;
        }
        else if (context.isJspAttribute("items")) {
            optimize = false;
        }
        else if (context.isJspAttribute("step")) {
            optimize = false;
        }
        else if (context.isJspAttribute("begin")) {
            optimize = false;
        }
        else if (context.isJspAttribute("end")) {
            optimize = false;
        }

        return optimize;
    }
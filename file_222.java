    private String stats(boolean suppressWarnings, boolean includeConfusion, boolean logConfusionSizeWarning){
        String actual, predicted;
        StringBuilder builder = new StringBuilder().append("\n");
        StringBuilder warnings = new StringBuilder();
        ConfusionMatrix<Integer> confusion = confusion();
        if(confusion == null){
            confusion = new ConfusionMatrix<>();    //Empty
        }
        List<Integer> classes = confusion.getClasses();

        List<Integer> falsePositivesWarningClasses = new ArrayList<>();
        List<Integer> falseNegativesWarningClasses = new ArrayList<>();
        for (Integer clazz : classes) {
            //Output possible warnings regarding precision/recall calculation
            if (!suppressWarnings && truePositives.getCount(clazz) == 0) {
                if (falsePositives.getCount(clazz) == 0) {
                    falsePositivesWarningClasses.add(clazz);
                }
                if (falseNegatives.getCount(clazz) == 0) {
                    falseNegativesWarningClasses.add(clazz);
                }
            }
        }

        if (!falsePositivesWarningClasses.isEmpty()) {
            warningHelper(warnings, falsePositivesWarningClasses, "precision");
        }
        if (!falseNegativesWarningClasses.isEmpty()) {
            warningHelper(warnings, falseNegativesWarningClasses, "recall");
        }

        int nClasses = confusion.getClasses().size();
        DecimalFormat df = new DecimalFormat("0.0000");
        double acc = accuracy();
        double precisionMacro = precision(EvaluationAveraging.Macro);
        double recallMacro = recall(EvaluationAveraging.Macro);
        double f1Macro = f1(EvaluationAveraging.Macro);
        builder.append("\n========================Evaluation Metrics========================");
        builder.append("\n # of classes:    ").append(nClasses);
        builder.append("\n Accuracy:        ").append(format(df, acc));
        if (topN > 1) {
            double topNAcc = topNAccuracy();
            builder.append("\n Top ").append(topN).append(" Accuracy:  ").append(format(df, topNAcc));
        }
        builder.append("\n Precision:       ").append(format(df, precisionMacro));
        if (nClasses > 2 && averagePrecisionNumClassesExcluded() > 0) {
            int ex = averagePrecisionNumClassesExcluded();
            builder.append("\t(").append(ex).append(" class");
            if (ex > 1)
                builder.append("es");
            builder.append(" excluded from average)");
        }
        builder.append("\n Recall:          ").append(format(df, recallMacro));
        if (nClasses > 2 && averageRecallNumClassesExcluded() > 0) {
            int ex = averageRecallNumClassesExcluded();
            builder.append("\t(").append(ex).append(" class");
            if (ex > 1)
                builder.append("es");
            builder.append(" excluded from average)");
        }
        builder.append("\n F1 Score:        ").append(format(df, f1Macro));
        if (nClasses > 2 && averageF1NumClassesExcluded() > 0) {
            int ex = averageF1NumClassesExcluded();
            builder.append("\t(").append(ex).append(" class");
            if (ex > 1)
                builder.append("es");
            builder.append(" excluded from average)");
        }
        if (nClasses > 2 || binaryPositiveClass == null) {
            builder.append("\nPrecision, recall & F1: macro-averaged (equally weighted avg. of ").append(nClasses)
                            .append(" classes)");
        }
        if(nClasses == 2 && binaryPositiveClass != null){
            builder.append("\nPrecision, recall & F1: reported for positive class (class ").append(binaryPositiveClass);
            if(labelsList != null){
                builder.append(" - \"").append(labelsList.get(binaryPositiveClass)).append("\"");
            }
            builder.append(") only");
        }
        if (binaryDecisionThreshold != null) {
            builder.append("\nBinary decision threshold: ").append(binaryDecisionThreshold);
        }
        if (costArray != null) {
            builder.append("\nCost array: ").append(Arrays.toString(costArray.dup().data().asFloat()));
        }
        //Note that we could report micro-averaged too - but these are the same as accuracy
        //"Note that for “micro�?-averaging in a multiclass setting with all labels included will produce equal precision, recall and F,"
        //http://scikit-learn.org/stable/modules/model_evaluation.html

        builder.append("\n\n");
        builder.append(warnings);

        if(includeConfusion){
            builder.append("\n=========================Confusion Matrix=========================\n");
            builder.append(confusionMatrix());
        } else if(logConfusionSizeWarning){
            builder.append("\n\nNote: Confusion matrix not generated due to space requirements for ")
                    .append(nClasses).append(" classes.\n")
                    .append("Use stats(false,true) to generate anyway");
        }

        builder.append("\n==================================================================");
        return builder.toString();
    }
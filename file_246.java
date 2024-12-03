  protected void printGeneralConfusionTable() {
    printHeader("Confusion matrix");

    SortedSet<String> labels = getConfusionMatrixTagset();

    double[][] confusionMatrix = getConfusionMatrix();

    printStream.append("\nTags with 100% accuracy: ");
    int line = 0;
    for (String label : labels) {
      if (confusionMatrix[line][confusionMatrix[0].length - 1] == 1) {
        printStream.append(label).append(" (")
            .append(Integer.toString((int) confusionMatrix[line][line]))
            .append(") ");
      }
      line++;
    }

    printStream.append("\n\n");

    printStream.append(matrixToString(labels, confusionMatrix, true));

    printFooter("Confusion matrix");
  }
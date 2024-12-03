  private List<String> filterMWE(String[] arr) {
    if(arr == null) return null;
    List<String> out = new ArrayList<String>(arr.length);
    for (String t : arr) {
      if (!(t.startsWith("B-") || t.startsWith("I-")))
        out.add(t);
    }
    return out;
  }
  List<List<Double>> multiplyWithOutAMP(List<List<Double>> list1, List<List<Double>> list2) {
    List<List<Double>> c ;
    List<Double> cTemp;

    c = new ArrayList<>() ;
    for (int row = 0; row < list1.size(); row++) {
      cTemp = new ArrayList<>() ;
      for (int col = 0; col < list2.get(0).size(); col++) {
        cTemp.add(0.0);
      }
      c.add(cTemp);
    }

    for (int row = 0; row < list1.size(); row++) {
      for (int col = 0; col < list2.get(row).size(); col++) {
        for (int inner = 0; inner < list1.get(0).size(); inner++) {
          double val = c.get(row).get(col) ;
          c.get(row).set(col, val + list1.get(row).get(inner) * list2.get(inner).get(col));
        }
      }
    }
    return c;
  }
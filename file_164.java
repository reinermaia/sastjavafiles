  public void setUnacceptable(E element) {

    Ranking ranking = this.map.get(element);
    if (ranking == null) {
      ranking = new Ranking();
      this.map.put(element, ranking);
    }
    ranking.setUnacceptable();
  }
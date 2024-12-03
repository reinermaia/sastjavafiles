  public FilterReply getFilterChainDecision(E event) {
    final Filter<E>[] filterArrray = filterList.asTypedArray();
    final int len = filterArrray.length;

    for (int i = 0; i < len; i++) {
      final FilterReply r = filterArrray[i].decide(event);
      if (r == FilterReply.DENY || r == FilterReply.ACCEPT) {
        return r;
      }
    }

    // no decision
    return FilterReply.NEUTRAL;
  }
  private void updateCoordinates() {
    // Top-left of heat map.
    int x = margin + axisThickness + yAxisLabelSize.height;
    x += (yValuesHorizontal ? yAxisValuesWidthMax : yAxisValuesHeight);
    int y = titleSize.height + margin;
    heatMapTL = new Point(x, y);

    // Top-right of heat map.
    x = heatMapTL.x + heatMapSize.width;
    y = heatMapTL.y + heatMapSize.height;
    heatMapBR = new Point(x, y);

    // Centre of heat map.
    x = heatMapTL.x + (heatMapSize.width / 2);
    y = heatMapTL.y + (heatMapSize.height / 2);
    heatMapC = new Point(x, y);
  }
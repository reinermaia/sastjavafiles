    private Coordinate[] getOrderedNodes( Coordinate c, Coordinate coordinate1, Coordinate coordinate2, Coordinate coordinate3 ) {
        double d = distance3d(c, coordinate1, null);
        Coordinate nearest = coordinate1;
        Coordinate c2 = coordinate2;
        Coordinate c3 = coordinate3;

        double d2 = distance3d(c, coordinate2, null);
        if (d2 < d) {
            nearest = coordinate2;
            d = d2;
            c2 = coordinate1;
            c3 = coordinate3;
        }
        double d3 = distance3d(c, coordinate3, null);
        if (d3 < d) {
            nearest = coordinate3;
            c2 = coordinate1;
            c3 = coordinate2;
        }
        return new Coordinate[]{nearest, c2, c3};
    }
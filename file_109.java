	public static AxisAlignedBoundingBox3D getBoundingBox3D(List<IfcCartesianPoint> points) throws GeometryException {
		AxisAlignedBoundingBox3D box3d = new AxisAlignedBoundingBox3D();
		for (IfcCartesianPoint ifcCartesianPoint : points) {
			EList<Double> coordinates = ifcCartesianPoint.getCoordinates();
			if (coordinates.size() < 2) {
				throw new GeometryException("Not enough dimensions (" + coordinates.size() + ") for 3D boundingbox");
			}
			box3d.process(coordinates);
		}
		return box3d;
	}
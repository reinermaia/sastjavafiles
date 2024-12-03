	public List<Point2D3D> createObservations( Se3_F64 worldToCamera , int total ) {

		Se3_F64 cameraToWorld = worldToCamera.invert(null);

		// transform from pixel coordinates to normalized pixel coordinates, which removes lens distortion
		Point2Transform2_F64 pixelToNorm = LensDistortionFactory.narrow(intrinsic).undistort_F64(true,false);

		List<Point2D3D> observations = new ArrayList<>();

		Point2D_F64 norm = new Point2D_F64();
		for (int i = 0; i < total; i++) {
			// randomly pixel a point inside the image
			double x = rand.nextDouble()*intrinsic.width;
			double y = rand.nextDouble()*intrinsic.height;

			// Convert to normalized image coordinates because that's what PNP needs.
			// it can't process pixel coordinates
			pixelToNorm.compute(x,y,norm);

			// Randomly pick a depth and compute 3D coordinate
			double Z = rand.nextDouble()+4;
			double X = norm.x*Z;
			double Y = norm.y*Z;

			// Change the point's reference frame from camera to world
			Point3D_F64 cameraPt = new Point3D_F64(X,Y,Z);
			Point3D_F64 worldPt = new Point3D_F64();

			SePointOps_F64.transform(cameraToWorld,cameraPt,worldPt);

			// Save the perfect noise free observation
			Point2D3D o = new Point2D3D();
			o.getLocation().set(worldPt);
			o.getObservation().set(norm.x,norm.y);

			observations.add(o);
		}

		return observations;
	}
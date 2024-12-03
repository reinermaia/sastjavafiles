	private void getLatLonsForPolygon( List<Double> polLons, List<Double> polLats){

		Gridset gridset = gridDataset.getGridsets().get(0);

		GridCoordSystem coordSystem = gridset.getGeoCoordSystem();
		ProjectionImpl fromProj = coordSystem.getProjection();
		coordSystem.getLatLonBoundingBox();

		if( coordSystem.getYHorizAxis() instanceof CoordinateAxis1D &&  coordSystem.getXHorizAxis() instanceof CoordinateAxis1D ){

			CoordinateAxis1D xAxis = (CoordinateAxis1D) coordSystem.getXHorizAxis();
			CoordinateAxis1D yAxis  =(CoordinateAxis1D) coordSystem.getYHorizAxis();			

			if(coordSystem.isGlobalLon()) {

				double maxy = yAxis.getMaxValue();
				double miny = yAxis.getMinValue();

				polLons.add(0.0);
				polLats.add(miny);
				
				polLons.add(360.0);
				polLats.add(miny);
				
				polLons.add(360.0);
				polLats.add(maxy);
				
				polLons.add(0.0);
				polLats.add(maxy);
				
				polLons.add(0.0);
				polLats.add(miny);				
				
				//polygonWKT.append("-180 "+ miny +", 180 "+ miny +", 180 "+ maxy +", -180 "+ maxy +", -180 "+ miny +"] ))");
				//polygonWKT.append("0 "+ miny +", 360 "+ miny +", 360 "+ maxy +", 0 "+ maxy +", 0 "+ miny +"] ))");
				//return polygonWKT.toString();

			}else{

				double[] xCoords = xAxis.getCoordValues();
				double[] yCoords = yAxis.getCoordValues();


				LatLonPoint prev = fromProj.projToLatLon(xCoords[0], yCoords[0]);

				//Bottom edge
				for( double x : xCoords  ){
					LatLonPoint point = fromProj.projToLatLon(x, yCoords[0]);

					if( point.getLongitude() < minLon ) minLon = point.getLongitude();  
					if( point.getLongitude() > maxLon ) maxLon = point.getLongitude();

					if( Math.abs(prev.getLongitude() - point.getLongitude() ) > maxDiff   )
						maxDiff = Math.abs(prev.getLongitude() - point.getLongitude() );

					polLons.add(point.getLongitude());
					polLats.add(point.getLatitude());
					prev = point;
				}

				//Right edge
				for( double y : yCoords  ){
					LatLonPoint point = fromProj.projToLatLon(xCoords[xCoords.length-1], y);

					if( point.getLongitude() < minLon ) minLon = point.getLongitude();  
					if( point.getLongitude() > maxLon ) maxLon = point.getLongitude();	

					if( Math.abs(prev.getLongitude() - point.getLongitude() ) > maxDiff   )
						maxDiff = Math.abs(prev.getLongitude() - point.getLongitude() );				

					polLons.add(point.getLongitude());
					polLats.add(point.getLatitude());				
					prev = point;

				}	  

				//Top
				for( int i = xCoords.length-1; i>=0; i--  ){
					LatLonPoint point = fromProj.projToLatLon(xCoords[i], yCoords[yCoords.length-1]);

					if( point.getLongitude() < minLon ) minLon = point.getLongitude();  
					if( point.getLongitude() > maxLon ) maxLon = point.getLongitude();

					if( Math.abs(prev.getLongitude() - point.getLongitude() ) > maxDiff   )
						maxDiff = Math.abs(prev.getLongitude() - point.getLongitude() );

					polLons.add(point.getLongitude());
					polLats.add(point.getLatitude());				
					prev = point;

				}	  

				//Left edge
				for( int i = yCoords.length-1; i>=0; i--  ){

					LatLonPoint point = fromProj.projToLatLon(xCoords[0], yCoords[i]);

					if( point.getLongitude() < minLon ) minLon = point.getLongitude();  
					if( point.getLongitude() > maxLon ) maxLon = point.getLongitude();	

					if( Math.abs(prev.getLongitude() - point.getLongitude() ) > maxDiff   )
						maxDiff = Math.abs(prev.getLongitude() - point.getLongitude() );				

					polLons.add(point.getLongitude());
					polLats.add(point.getLatitude() );				
					prev = point;
				}

			}			

		}else if( coordSystem.getYHorizAxis() instanceof CoordinateAxis2D &&  coordSystem.getXHorizAxis() instanceof CoordinateAxis2D ){

			//Get boundaries from 2d axis...
			CoordinateAxis2D xAxis = (CoordinateAxis2D) coordSystem.getXHorizAxis();
			CoordinateAxis2D yAxis  =(CoordinateAxis2D) coordSystem.getYHorizAxis();

			int[] xShape = xAxis.getShape();
			int[] yShape = yAxis.getShape();


			LatLonPoint prev = fromProj.projToLatLon(xAxis.getCoordValue(0, 0), yAxis.getCoordValue(0, 0));

			for(int i = 0; i < xShape[0]; i++ ){
				double x = xAxis.getCoordValue(i, 0);
				double y = yAxis.getCoordValue(i, 0);

				LatLonPoint point = fromProj.projToLatLon(x, y);

				if( point.getLongitude() < minLon ) minLon = point.getLongitude();  
				if( point.getLongitude() > maxLon ) maxLon = point.getLongitude();

				if( Math.abs(prev.getLongitude() - point.getLongitude() ) > maxDiff )
					maxDiff = Math.abs(prev.getLongitude() - point.getLongitude() );

				polLons.add(point.getLongitude());
				polLats.add(point.getLatitude());					
				prev = point;
			}

			for(int i = 0; i < xShape[1]; i++ ){
				double x = xAxis.getCoordValue(xShape[0]-1, i);
				double y = yAxis.getCoordValue(xShape[0]-1, i);

				LatLonPoint point = fromProj.projToLatLon(x, y);
				if( point.getLongitude() < minLon ) minLon = point.getLongitude();  
				if( point.getLongitude() > maxLon ) maxLon = point.getLongitude();

				if( Math.abs(prev.getLongitude() - point.getLongitude() ) > maxDiff )
					maxDiff = Math.abs(prev.getLongitude() - point.getLongitude() );

				polLons.add(point.getLongitude());
				polLats.add(point.getLatitude());					
				prev = point;					
			}

			for(int i = xShape[0]-1 ; i >= 0; i-- ){
				double x = xAxis.getCoordValue(i, xShape[1]-1);
				double y = yAxis.getCoordValue(i, xShape[1]-1);

				LatLonPoint point = fromProj.projToLatLon(x, y);
				if( point.getLongitude() < minLon ) minLon = point.getLongitude();  
				if( point.getLongitude() > maxLon ) maxLon = point.getLongitude();

				if( Math.abs(prev.getLongitude() - point.getLongitude() ) > maxDiff )
					maxDiff = Math.abs(prev.getLongitude() - point.getLongitude() );

				polLons.add(point.getLongitude());
				polLats.add(point.getLatitude());					
				prev = point;				
			}

			for(int i = xShape[1]-1 ; i >= 0; i-- ){
				double x = xAxis.getCoordValue(0, i);
				double y = yAxis.getCoordValue(0, i);

				LatLonPoint point = fromProj.projToLatLon(x, y);
				if( point.getLongitude() < minLon ) minLon = point.getLongitude();  
				if( point.getLongitude() > maxLon ) maxLon = point.getLongitude();

				if( Math.abs(prev.getLongitude() - point.getLongitude() ) > maxDiff )
					maxDiff = Math.abs(prev.getLongitude() - point.getLongitude() );

				polLons.add(point.getLongitude());
				polLats.add(point.getLatitude());					
				prev = point;				
			}			

		}



	}
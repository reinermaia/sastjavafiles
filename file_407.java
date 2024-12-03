    public Point3d[] get3DCoordinatesForSP3Ligands(IAtom refAtom, IAtomContainer noCoords, IAtomContainer withCoords,
            IAtom atomC, int nwanted, double length, double angle) {
        //logger.debug("SP3 Ligands start ");
        Point3d newPoints[] = new Point3d[0];
        Point3d aPoint = refAtom.getPoint3d();
        int nwithCoords = withCoords.getAtomCount();
        if (angle < 0) {
            angle = TETRAHEDRAL_ANGLE;
        }
        if (nwithCoords == 0) {
            newPoints = calculate3DCoordinates0(refAtom.getPoint3d(), nwanted, length);
        } else if (nwithCoords == 1) {
            newPoints = calculate3DCoordinates1(aPoint, (withCoords.getAtom(0)).getPoint3d(),
                    (atomC != null) ? atomC.getPoint3d() : null, nwanted, length, angle);
        } else if (nwithCoords == 2) {
            Point3d bPoint = withCoords.getAtom(0).getPoint3d();
            Point3d cPoint = withCoords.getAtom(1).getPoint3d();
            newPoints = calculate3DCoordinates2(aPoint, bPoint, cPoint, nwanted, length, angle);
        } else if (nwithCoords == 3) {
            Point3d bPoint = withCoords.getAtom(0).getPoint3d();
            Point3d cPoint = withCoords.getAtom(1).getPoint3d();
            newPoints = new Point3d[1];
            Point3d dPoint = withCoords.getAtom(2).getPoint3d();
            newPoints[0] = calculate3DCoordinates3(aPoint, bPoint, cPoint, dPoint, length);
        }
        //logger.debug("...Ready");
        return newPoints;
    }
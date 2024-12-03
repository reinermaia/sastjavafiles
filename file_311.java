    private static GeometricParity geometric3D(int i, int[] adjacent, IAtomContainer container) {

        IAtom atom = container.getAtom(i);
        Point3d[] coordinates = new Point3d[4];

        // set the forth ligand to centre as default (overwritten if
        // we have 4 neighbors)
        if (atom.getPoint3d() != null)
            coordinates[3] = atom.getPoint3d();
        else
            return null;

        // for each neighboring atom check if we have 3D coordinates
        for (int j = 0; j < adjacent.length; j++) {
            IAtom neighbor = container.getAtom(adjacent[j]);

            if (neighbor.getPoint3d() != null)
                coordinates[j] = neighbor.getPoint3d();
            else
                return null; // skip to next atom
        }

        // add new 3D stereo encoder
        return new Tetrahedral3DParity(coordinates);

    }
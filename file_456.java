    TextOutline positionChargeLabel(int hydrogens, HydrogenPosition position, TextOutline charge, TextOutline element,
                                    TextOutline hydrogen) {

        final Rectangle2D chargeBounds = charge.getBounds();

        // the charge is placed to the top right of the element symbol
        // unless either the hydrogen label or the hydrogen count label
        // are in the way - in which case we place it relative to the
        // hydrogen
        Rectangle2D referenceBounds = element.getBounds();
        if (hydrogens > 0 && position == Right)
            referenceBounds = hydrogen.getBounds();
        else if (hydrogens > 1 && position == Above) referenceBounds = hydrogen.getBounds();

        return charge.translate((referenceBounds.getMaxX() + padding) - chargeBounds.getMinX(),
                                (referenceBounds.getMinY() - (chargeBounds.getHeight() / 2)) - chargeBounds.getMinY());
    }
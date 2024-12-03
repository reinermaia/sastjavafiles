	private void linkToEmitter(String name, LinearInterpolator interpol) {
		// put to value map
		valueMap.put(name, interpol);

		// now update the checkbox to represent the state of the given
		// interpolator
		boolean checked = interpol.isActive();
		JCheckBox enableControl = (JCheckBox) valueNameToControl.get(name);
		enableControl.setSelected(false);
		if (checked)
			enableControl.setSelected(checked);
	}
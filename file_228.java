	public boolean verifyChecked(final By checkboxBy) {
		WebElement element = driver.findElement(checkboxBy);

		if (element.isSelected()) {
			LOG.info("Checkbox: " + element + " is checked!");
			return true;
		}

		LOG.info("Checkbox: " + element + " is NOT checked!");
		return false;
	}
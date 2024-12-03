	public boolean isPassingChecks() {
		for (Check check : this.service.getChecks()) {
			if (check.getStatus() != Check.CheckStatus.PASSING) {
				return false;
			}
		}
		return true;
	}
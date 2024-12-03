	@Override
	public String getRequestValue(final Request request) {
		if (isPresent(request)) {
			// User entered a valid date
			String dateParam = request.getParameter(getId() + "-date");
			if (dateParam == null) {
				return null;
			}

			// Validate Transfer Date Format - YYYY-MM-DD
			if (dateParam.length() != INTERNAL_DATE_TOTAL_CHARS || dateParam.charAt(
					INTERNAL_DASH1_POS) != '-'
					|| dateParam.charAt(INTERNAL_DASH2_POS) != '-') {
				LOG.warn("Date parameter is not in the format yyyy-MM-dd (" + dateParam
						+ ") and will be treated as null.");
				return null;
			}

			// Transform YYYY-MM-DD to YYYYMMDD
			StringBuffer buf = new StringBuffer(DATE_TOTAL_CHARS);
			buf.append(dateParam.substring(INTERNAL_YEAR_START, INTERNAL_YEAR_END));
			buf.append(dateParam.substring(INTERNAL_MONTH_START, INTERNAL_MONTH_END));
			buf.append(dateParam.substring(INTERNAL_DAY_START, INTERNAL_DAY_END));

			String dateFormat = buf.toString();

			// Validate the date
			if (!isValidPartialDateStringFormat(dateFormat, THEME_PADDING_CHAR)) {
				LOG.warn("Date parameter ("
						+ dateParam
						+ ") could not be transformed from YYYY-MM-DD to the format YYYYMMDD and will be treated as null.");
				return null;
			}

			// Convert from Theme padding character to the correct padding character
			return dateFormat.replace(THEME_PADDING_CHAR, getPaddingChar());
		} else {
			return getValue();
		}
	}
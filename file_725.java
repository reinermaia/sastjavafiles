	@Override
	public <Resp> void response(HttpAdapter<?, Resp> adapter, Resp res, Throwable error,
			SpanCustomizer customizer) {
		if (res == null) {
			error(null, error, customizer);
			return;
		}
		Integer httpStatus = adapter.statusCode(res);
		if (httpStatus == null) {
			error(httpStatus, error, customizer);
			return;
		}
		if (httpStatus == HttpServletResponse.SC_OK && error != null) {
			// Filter chain threw exception but the response status may not have been set
			// yet, so we have to guess.
			customizer.tag(STATUS_CODE_KEY,
					String.valueOf(HttpServletResponse.SC_INTERNAL_SERVER_ERROR));
		}
		// only tag valid http statuses
		else if (httpStatus >= 100 && (httpStatus < 200) || (httpStatus > 399)) {
			customizer.tag(STATUS_CODE_KEY, String.valueOf(httpStatus));
		}
		error(httpStatus, error, customizer);
	}
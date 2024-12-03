	private static DateTimeValue convert(DateTimeValue time, TimeZone zone, int sense) {
		if (zone == null || zone.hasSameRules(ZULU) || time.year() == 0) {
			return time;
		}

		TimeZone epochTz, dateTimeValueTz;
		if (sense > 0) {
			//time is in UTC; convert to time in zone provided
			epochTz = ZULU;
			dateTimeValueTz = zone;
		} else {
			//time is in local time; convert to UTC
			epochTz = zone;
			dateTimeValueTz = ZULU;
		}

		long epochSeconds = secsSinceEpoch(time);
		long timetMillis = timetMillisFromEpochSecs(epochSeconds, epochTz);
		return toDateTimeValue(timetMillis, dateTimeValueTz);
	}
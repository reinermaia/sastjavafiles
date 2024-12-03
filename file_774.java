	private static EnumerationDatatype getEnumerationDatatype(
			com.siemens.ct.exi.grammars._2017.schemaforgrammars.Enumeration en,
			QNameContext qnc) throws EXIException {
		Value[] enumValues;
		Datatype dtEnumValues;

		DatatypeBasics enumDT = en.getEnumerationValueDatatype();
		if (enumDT.getBase64Binary() != null) {
			dtEnumValues = new BinaryBase64Datatype(qnc);
			enumValues = new BinaryBase64Value[en.getBase64BinaryValue().size()];
			for (int k = 0; k < en.getBase64BinaryValue().size(); k++) {
				enumValues[k] = new BinaryBase64Value(en.getBase64BinaryValue()
						.get(k));
			}
		} else if (enumDT.getHexBinary() != null) {
			dtEnumValues = new BinaryHexDatatype(qnc);
			enumValues = new BinaryHexValue[en.getHexBinaryValue().size()];
			for (int k = 0; k < en.getHexBinaryValue().size(); k++) {
				enumValues[k] = new BinaryHexValue(en.getHexBinaryValue()
						.get(k));
			}
		} else if (enumDT.getBoolean() != null) {
			dtEnumValues = new BooleanDatatype(qnc);
			enumValues = new BooleanValue[en.getBooleanValue().size()];
			for (int k = 0; k < en.getBooleanValue().size(); k++) {
				enumValues[k] = en.getBooleanValue().get(k) ? BooleanValue.BOOLEAN_VALUE_TRUE
						: BooleanValue.BOOLEAN_VALUE_FALSE;
			}
		} else if (enumDT.getDateAndTime() != null) {
			DateTimeType dateType;
			if (enumDT.getDateAndTime().getDateTime() != null) {
				dateType = DateTimeType.dateTime;
				enumValues = new DateTimeValue[en.getDateTimeValue().size()];
				for (int k = 0; k < en.getDateTimeValue().size(); k++) {
					XMLGregorianCalendar xmlgc = en.getDateTimeValue().get(k);
					DateTimeValue dtv = DateTimeValue.parse(
							xmlgc.toGregorianCalendar(), dateType);
					enumValues[k] = dtv;
				}
			} else if (enumDT.getDateAndTime().getTime() != null) {
				dateType = DateTimeType.time;
				enumValues = new DateTimeValue[en.getTimeValue().size()];
				for (int k = 0; k < en.getTimeValue().size(); k++) {
					XMLGregorianCalendar xmlgc = en.getTimeValue().get(k);
					DateTimeValue dtv = DateTimeValue.parse(
							xmlgc.toGregorianCalendar(), dateType);
					enumValues[k] = dtv;
				}
			} else if (enumDT.getDateAndTime().getDate() != null) {
				dateType = DateTimeType.date;
				enumValues = new DateTimeValue[en.getDateValue().size()];
				for (int k = 0; k < en.getDateValue().size(); k++) {
					XMLGregorianCalendar xmlgc = en.getDateValue().get(k);
					DateTimeValue dtv = DateTimeValue.parse(
							xmlgc.toGregorianCalendar(), dateType);
					enumValues[k] = dtv;
				}
			} else if (enumDT.getDateAndTime().getGYearMonth() != null) {
				dateType = DateTimeType.gYearMonth;
				enumValues = new DateTimeValue[en.getGYearMonthValue().size()];
				for (int k = 0; k < en.getGYearMonthValue().size(); k++) {
					XMLGregorianCalendar xmlgc = en.getGYearMonthValue().get(k);
					DateTimeValue dtv = DateTimeValue.parse(
							xmlgc.toGregorianCalendar(), dateType);
					enumValues[k] = dtv;
				}
			} else if (enumDT.getDateAndTime().getGYear() != null) {
				dateType = DateTimeType.gYear;
				enumValues = new DateTimeValue[en.getGYearValue().size()];
				for (int k = 0; k < en.getGYearValue().size(); k++) {
					XMLGregorianCalendar xmlgc = en.getGYearValue().get(k);
					DateTimeValue dtv = DateTimeValue.parse(
							xmlgc.toGregorianCalendar(), dateType);
					enumValues[k] = dtv;
				}
			} else if (enumDT.getDateAndTime().getGMonthDay() != null) {
				dateType = DateTimeType.gMonthDay;
				enumValues = new DateTimeValue[en.getGMonthDayValue().size()];
				for (int k = 0; k < en.getGMonthDayValue().size(); k++) {
					XMLGregorianCalendar xmlgc = en.getGMonthDayValue().get(k);
					DateTimeValue dtv = DateTimeValue.parse(
							xmlgc.toGregorianCalendar(), dateType);
					enumValues[k] = dtv;
				}
			} else if (enumDT.getDateAndTime().getGDay() != null) {
				dateType = DateTimeType.gDay;
				enumValues = new DateTimeValue[en.getGDayValue().size()];
				for (int k = 0; k < en.getGDayValue().size(); k++) {
					XMLGregorianCalendar xmlgc = en.getGDayValue().get(k);
					DateTimeValue dtv = DateTimeValue.parse(
							xmlgc.toGregorianCalendar(), dateType);
					enumValues[k] = dtv;
				}
			} else if (enumDT.getDateAndTime().getGMonth() != null) {
				dateType = DateTimeType.gMonth;
				enumValues = new DateTimeValue[en.getGMonthValue().size()];
				for (int k = 0; k < en.getGMonthValue().size(); k++) {
					XMLGregorianCalendar xmlgc = en.getGMonthValue().get(k);
					DateTimeValue dtv = DateTimeValue.parse(
							xmlgc.toGregorianCalendar(), dateType);
					enumValues[k] = dtv;
				}
			} else {
				throw new EXIException("Unsupported Enum DateAndTime datatype");
			}
			dtEnumValues = new DatetimeDatatype(dateType, qnc);
		} else if (enumDT.getDecimal() != null) {
			dtEnumValues = new DecimalDatatype(qnc);
			enumValues = new DecimalValue[en.getDecimalValue().size()];
			for (int k = 0; k < en.getDecimalValue().size(); k++) {
				enumValues[k] = DecimalValue.parse(en.getDecimalValue().get(k));
			}
		} else if (enumDT.getDouble() != null) {
			dtEnumValues = new FloatDatatype(qnc);
			enumValues = new FloatValue[en.getFloatValue().size()];
			for (int k = 0; k < en.getFloatValue().size(); k++) {
				enumValues[k] = FloatValue.parse(en.getFloatValue().get(k));
			}
		} else if (enumDT.getInteger() != null) {
			dtEnumValues = new IntegerDatatype(qnc);
			enumValues = new IntegerValue[en.getIntegerValue().size()];
			for (int k = 0; k < en.getIntegerValue().size(); k++) {
				enumValues[k] = IntegerValue.valueOf(en.getIntegerValue()
						.get(k));
			}
		} else if (enumDT.getString() != null) {
			dtEnumValues = new StringDatatype(qnc);
			enumValues = new StringValue[en.getStringValue().size()];
			for (int k = 0; k < en.getStringValue().size(); k++) {
				enumValues[k] = new StringValue(en.getStringValue().get(k));
			}
		} else {
			throw new EXIException("Unsupported Enumeration type for " + enumDT);
		}

		EnumerationDatatype endt = new EnumerationDatatype(enumValues,
				dtEnumValues, qnc);
		return endt;
	}
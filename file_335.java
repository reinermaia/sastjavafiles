	private static Enum<?> getEnum(String enumFullName) {
		String[] x = enumFullName.split("\\.(?=[^\\.]+$)");
		if (x.length == 2) {
			String enumClassName = x[0];
			String enumName = x[1];
			try {
				Class<Enum> cl = (Class<Enum>) Class.forName(enumClassName);
				return Enum.valueOf(cl, enumName);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("Incompatible KafkaProducer version", e);
			}
		}
		return null;
	}
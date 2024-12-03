public static EncryptionMode getEncryptionModeCipher(String encryptionMode) {
	if (encryptionMode==null) {
		return null;
	}
	switch (encryptionMode) {
		case "agile": return EncryptionMode.agile;
		case "binaryRC4": return EncryptionMode.binaryRC4;
		case "cryptoAPI": return EncryptionMode.cryptoAPI;
		case "standard": return EncryptionMode.standard;
		default:
			LOG.error("Uknown enncryption mode \""+encryptionMode+"\"");
			break;
		//case "xor": return EncryptionMode.xor; // does not seem to be supported anymore
	}
	return null;
}
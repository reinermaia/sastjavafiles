    Cipher createEncryptionCipher ( byte[] key ) throws CIFSException {
        if ( !this.smb2 || this.negotiated == null ) {
            throw new SmbUnsupportedOperationException();
        }

        Smb2NegotiateResponse resp = (Smb2NegotiateResponse) this.negotiated;
        int cipherId = -1;

        if ( resp.getSelectedDialect().atLeast(DialectVersion.SMB311) ) {
            cipherId = resp.getSelectedCipher();
        }
        else if ( resp.getSelectedDialect().atLeast(DialectVersion.SMB300) ) {
            cipherId = EncryptionNegotiateContext.CIPHER_AES128_CCM;
        }
        else {
            throw new SmbUnsupportedOperationException();
        }

        switch ( cipherId ) {
        case EncryptionNegotiateContext.CIPHER_AES128_CCM:
        case EncryptionNegotiateContext.CIPHER_AES128_GCM:
        default:
            throw new SmbUnsupportedOperationException();
        }
    }
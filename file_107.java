    @Nullable
    public String getIpAddressIdFromIP(@Nonnull String ipAddress, @Nonnull String regionId)throws InternalException, CloudException{
        try{
            Compute gce = getProvider().getGoogleCompute();
            AddressList addressList = gce.addresses().list(getContext().getAccountNumber(), regionId).execute();
            if(addressList != null && addressList.getItems() != null && !addressList.getItems().isEmpty()){
                for(Address address : addressList.getItems()){
                    if(ipAddress.equals(address.getAddress()))return address.getName();
                }
            }
            throw new InternalException("An address could not be found matching " + ipAddress + " in " + regionId);
	    } catch (IOException ex) {
            logger.error(ex.getMessage());
			if (ex.getClass() == GoogleJsonResponseException.class) {
				GoogleJsonResponseException gjre = (GoogleJsonResponseException)ex;
				throw new GoogleException(CloudErrorType.GENERAL, gjre.getStatusCode(), gjre.getContent(), gjre.getDetails().getMessage());
			} else
				throw new CloudException("An error occurred finding the specified IPAddress: " + ex.getMessage());
		}
    }
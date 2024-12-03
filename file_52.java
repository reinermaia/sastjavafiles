    @Nullable
    @Override
    public IpAddress getIpAddress(@Nonnull String addressId) throws InternalException, CloudException {
        APITrace.begin(getProvider(), "IpAddress.getIpAddress");
        try{
            try{
                Compute gce = getProvider().getGoogleCompute();
                AddressAggregatedList addressList = gce.addresses().aggregatedList(getContext().getAccountNumber()).setFilter("name eq " + addressId).execute();
                if(addressList != null && addressList.getItems() != null && !addressList.getItems().isEmpty())        {
                    Iterator<String> regions = addressList.getItems().keySet().iterator();
                    while(regions.hasNext()){
                        String region = regions.next();
                        if(addressList.getItems() != null && addressList.getItems().get(region) != null && addressList.getItems().get(region).getAddresses() != null && !addressList.getItems().get(region).getAddresses().isEmpty()){
                            for(Address address : addressList.getItems().get(region).getAddresses()){
                                if(address.getName().equals(addressId))return toIpAddress(address);
                            }
                        }
                    }
                }
    	    } catch (IOException ex) {
	            logger.error(ex.getMessage());
    			if (ex.getClass() == GoogleJsonResponseException.class) {
    				GoogleJsonResponseException gjre = (GoogleJsonResponseException)ex;
    				throw new GoogleException(CloudErrorType.GENERAL, gjre.getStatusCode(), gjre.getContent(), gjre.getDetails().getMessage());
    			} else
                    throw new CloudException("An error occurred getting the IPAddress: " + ex.getMessage());
    		}
            throw new InternalException("Could not find IPAddress: " + addressId);
        }
        finally {
            APITrace.end();
        }
    }
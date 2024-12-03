    public CountryGroup getCountryGroup() {
        if (null == _countryGroup && null == countryGroup) { _countryGroup = Helper.EU; }
        return null == countryGroup ? _countryGroup : countryGroup.get();
    }
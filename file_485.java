    public void setExternalArrayData(ExternalArrayData array)
    {
        externalData = array;

        if (array == null) {
            delete("length");
        } else {
            // Define "length" to return whatever length the List gives us.
            defineProperty("length", null,
                           GET_ARRAY_LENGTH, null, READONLY | DONTENUM);
        }
    }
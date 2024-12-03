    public static <T> T[] filter(T array[], Filter<T> filter){
        List<T> filteredList = new ArrayList<T>(array.length);
        for(T element: array){
            if(filter.select(element))
                filteredList.add(element);
        }
        @SuppressWarnings("unchecked")
        T filteredArray[] = (T[])Array.newInstance(array.getClass().getComponentType(), filteredList.size());
        return filteredList.toArray(filteredArray);
    }
    private static Func1<ObservableHttpResponse, Boolean> successful() {
        return new Func1<ObservableHttpResponse, Boolean>() {

            @Override
            public Boolean call(ObservableHttpResponse response) {
                if (response.getResponse().getStatusLine().getStatusCode() >= 400) {
                    throw new RuntimeException("Failed to post samples: " + response.getResponse().getStatusLine());
                }
                return true;
            }
            
        };
    }
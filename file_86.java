    protected RefProperty registerErrorModel(Swagger swagger) {
        String ref = Error.class.getSimpleName();
        if (swagger.getDefinitions() != null && swagger.getDefinitions().containsKey(ref)) {
            // model already registered
            return new RefProperty(ref);
        }

        ModelImpl model = new ModelImpl();
        swagger.addDefinition(ref, model);

        model.setDescription("an error message");

        model.addProperty("statusCode", new IntegerProperty().readOnly().description("http status code"));
        model.addProperty("statusMessage", new StringProperty().readOnly().description("description of the http status code"));
        model.addProperty("requestMethod", new StringProperty().readOnly().description("http request method"));
        model.addProperty("requestUri", new StringProperty().readOnly().description("http request path"));
        model.addProperty("message", new StringProperty().readOnly().description("application message"));

        if (settings.isDev()) {
            // in DEV mode the stacktrace is returned in the error message
            model.addProperty("stacktrace", new StringProperty().readOnly().description("application stacktrace"));
        }

        return new RefProperty(ref);
    }
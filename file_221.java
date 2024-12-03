    public static void main(String[] args) {
        Phaser phaser = new Phaser(2);

        HTTP2ServerBuilder server = $.httpServer();
        server.router().post("/task/create")
              .produces("application/json").consumes("*/json")
              .handler(ctx -> {
                  Map<String, Object> ret = new HashMap<>();
                  ret.put("msg", "create task, " + ctx.getJsonBody(Task.class) + " success ");
                  ret.put("code", 0);
                  ctx.put(HttpHeader.CONTENT_TYPE, MimeTypes.Type.APPLICATION_JSON_UTF_8.asString())
                     .end($.json.toJson(ret));
              }).listen("localhost", 8080);

        Task task = new Task();
        task.name = "TODO today";
        task.date = new Date();
        $.httpClient().post("http://localhost:8080/task/create")
         .put(HttpHeader.ACCEPT, "text/plain; q=0.9, application/json")
         .jsonBody(task).submit()
         .thenAccept(res -> {
             System.out.println(res.getJsonObjectBody());
             phaser.arrive();
         });

        phaser.arriveAndAwaitAdvance();
        server.stop();
        $.httpClient().stop();
    }
  @GET
  @Produces(MediaType.TEXT_HTML)
  public Response errorHTML(@Context HttpServletRequest request) {
    StringBuilder html = new StringBuilder(1000);

    html.append("<!DOCTYPE html>" +
        "<html><head><title>Error</title>" +
        "<style type=\"text/css\">" +
        "body{background-color:#01596e} body,p{font-family:monospace;color:white}" +
        "</style></head>" +
        "<body>");

    html.append("<p><strong>Error");
    Number statusCode = (Number) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
    if (statusCode != null) {
      html.append(' ').append(statusCode);
    }
    html.append("</strong>");
    Object requestURI = request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI);
    if (requestURI != null) {
      html.append(" : ");
      html.append(JspHelper.escapeXml(requestURI));
    }
    html.append("</p>");

    Object message = request.getAttribute(RequestDispatcher.ERROR_MESSAGE);
    if (message != null) {
      html.append("<p><strong>");
      html.append(JspHelper.escapeXml(message));
      html.append("</strong></p>");
    }

    Throwable throwable = (Throwable) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
    if (throwable != null) {
      StringWriter sw = new StringWriter();
      throwable.printStackTrace(new PrintWriter(sw));
      html.append("<p><pre>");
      html.append(JspHelper.escapeXml(sw.toString()));
      html.append("</pre></p>");
    }

    html.append("</body></html>");

    Response.Status finalStatus = statusCode == null ?
        Response.Status.OK : Response.Status.fromStatusCode(statusCode.intValue());
    return Response.status(finalStatus).entity(html.toString()).build();
  }
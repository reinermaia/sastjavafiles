    public Object processSecurityPreInvokeException(SecurityViolationException sve, RequestProcessor requestProcessor, HttpServletRequest request,
            HttpServletResponse response, WebAppDispatcherContext dispatchContext, WebApp context, String name) throws ServletErrorReport {

        Object secObject = null;

        // begin pq56177

        secObject = sve.getWebSecurityContext();
        int sc = sve.getStatusCode(); // access status code directly. Is
                                      // SC_FORBIDDEN the default?
        // if (sc==null){
        // if
        // (com.ibm.ejs.ras.TraceComponent.isAnyTracingEnabled()&&logger.isLoggable
        // (Level.FINE) == true)
        // {
        // logger.logp(Level.FINE,
        // CLASS_NAME,"processSecurityPreInvokeException",
        // "webReply is null, default to 403 status code");
        // }
        // sc = HttpServletResponse.SC_FORBIDDEN;
        // }
        Throwable cause = sve.getCause();

        if (com.ibm.ejs.ras.TraceComponent.isAnyTracingEnabled() && logger.isLoggable(Level.FINE) == true) {
            logger.entering(CLASS_NAME, "processSecurityPreInvokeException");
            logger.logp(Level.FINE, CLASS_NAME, "processSecurityPreInvokeException",
                    "SecurityCollaboratorHelper.processPreInvokeException():  WebSecurityException thrown (" + sve.toString()
                            + ").  HTTP status code: " + sc + "resource : " + name);

        } // end if

        if (sc == HttpServletResponse.SC_FORBIDDEN) {
            // If the user has defined a custom error page for
            // SC_FORBIDDEN (HTTP status code 403) then send
            // it to the client ...
            if (context.isErrorPageDefined(sc) == true) {
                if (com.ibm.ejs.ras.TraceComponent.isAnyTracingEnabled() && logger.isLoggable(Level.FINE) == true) {
                    logger.logp(Level.FINE, CLASS_NAME, "processSecurityPreInvokeException", "Using user defined error page for HTTP status code "
                            + sc);
                }

                WebAppErrorReport wErrorReport = new WebAppErrorReport(cause);
                wErrorReport.setErrorCode(sc);
                context.sendError(request, response, wErrorReport);
            } else {
                // ... otherwise, use the one provided by the
                // SecurityCollaborator
                if (com.ibm.ejs.ras.TraceComponent.isAnyTracingEnabled() && logger.isLoggable(Level.FINE) == true) {
                    logger.logp(Level.FINE, CLASS_NAME, "processSecurityPreInvokeException",
                            "Using default security error page for HTTP status code " + sc);
                }

                try {
                    securityCollaborator.handleException(request, response, cause);
                } catch (Exception ex) {
                    if (requestProcessor != null) {
                        throw WebAppErrorReport.constructErrorReport(ex, requestProcessor);
                    } else {
                        throw WebAppErrorReport.constructErrorReport(ex, name);
                    }
                }
                // reply.sendError(wResp);
            } // end if-else
        } else if (sc == HttpServletResponse.SC_UNAUTHORIZED) {
            // Invoking handleException will add the necessary headers
            // to the response ...
            try {
                securityCollaborator.handleException(request, response, cause);
            } catch (Exception ex) {
                if (requestProcessor != null) {
                    throw WebAppErrorReport.constructErrorReport(ex, requestProcessor);
                } else {
                    throw WebAppErrorReport.constructErrorReport(ex, name);
                }
            }

            // ... if the user has defined a custom error page for
            // SC_UNAUTHORIZED (HTTP status code 401) then
            // send it to the client
            if (context.isErrorPageDefined(sc) == true) {
            	
            	WebContainerRequestState reqState = com.ibm.wsspi.webcontainer.WebContainerRequestState.getInstance(false);
    			boolean errorPageAlreadySent = false;
    			if (reqState!=null) {
    				String spnegoErrorPageAlreadySent = (String)reqState.getAttribute("spnego.error.page");
    				reqState.removeAttribute("spnego.error.page");
    				if (spnegoErrorPageAlreadySent != null && spnegoErrorPageAlreadySent.equalsIgnoreCase("true")) {  					    		
    					errorPageAlreadySent = true; 
    				    if (com.ibm.ejs.ras.TraceComponent.isAnyTracingEnabled()&&logger.isLoggable (Level.FINE) == true) {
    				         logger.logp(Level.FINE, CLASS_NAME,"processSecurityPreInvokeException", "skip error page - already created by spego code");
    				    }	
    				}    
    			} 

    			if (!errorPageAlreadySent) {

    				if (com.ibm.ejs.ras.TraceComponent.isAnyTracingEnabled() && logger.isLoggable(Level.FINE) == true) {
    					logger.logp(Level.FINE, CLASS_NAME, "processSecurityPreInvokeException", "Using user defined error page for HTTP status code "
    							+ sc);
    				}

    				WebAppErrorReport wErrorReport = new WebAppErrorReport(cause);
    				wErrorReport.setErrorCode(sc);
    				context.sendError(request, response, wErrorReport);
    				
    			}	
            } else {
                if (com.ibm.ejs.ras.TraceComponent.isAnyTracingEnabled() && logger.isLoggable(Level.FINE) == true) {
                    logger.logp(Level.FINE, CLASS_NAME, "processSecurityPreInvokeException",
                            "Using default security error page for HTTP status code " + sc);
                }
                // reply.sendError(wResp); comment-out 140967
            }

        } else {
            // Unexpected status code ... not SC_UNAUTHORIZED or SC_FORBIDDEN
            if ((logger.isLoggable(Level.FINE) == true)) {
                logger.logp(Level.FINE, CLASS_NAME, "processSecurityPreInvokeException", "HTTP status code: " + sc);
            }
            try {
                securityCollaborator.handleException(request, response, cause);
            } catch (Exception ex) {
                if (requestProcessor != null) {
                    throw WebAppErrorReport.constructErrorReport(ex, requestProcessor);
                } else {
                    throw WebAppErrorReport.constructErrorReport(ex, name);
                }
            }
        }
        if (com.ibm.ejs.ras.TraceComponent.isAnyTracingEnabled() && logger.isLoggable(Level.FINE) == true) {
            logger.exiting(CLASS_NAME, "processSecurityPreInvokeException");
        }
        return secObject;
    }
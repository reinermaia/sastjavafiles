    protected Socket acceptSocket(int timeout)
    {
        try
        {
            Socket s = null;

            if (_listen != null)
            {
                if (_soTimeOut != timeout)
                {
                    _soTimeOut = timeout;
                    _listen.setSoTimeout(_soTimeOut);
                }

                s = _listen.accept();

                try
                {
                    if (getMaxIdleTimeMs() >= 0) s.setSoTimeout(getMaxIdleTimeMs());
                    if (_lingerTimeSecs >= 0)
                        s.setSoLinger(true, _lingerTimeSecs);
                    else
                        s.setSoLinger(false, 0);
                }
                catch (Exception e)
                {
                    LogSupport.ignore(log, e);
                }
            }
            return s;
        }
        catch (java.net.SocketException e)
        {
            // TODO - this is caught and ignored due strange
            // exception from linux java1.2.v1a
            LogSupport.ignore(log, e);
        }
        catch (InterruptedIOException e)
        {
            LogSupport.ignore(log, e);
        }
        catch (IOException e)
        {
            log.warn(LogSupport.EXCEPTION, e);
        }
        return null;
    }
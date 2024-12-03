    @Override
    public void onTimerStop(Timer timer) {
        String name = timer.name();
        long ns = timer.ns();
        logger(name).trace("Timer[%s] stopped. Time elapsed: %sns", name, ns);
        onTimerStop_(name, ns);
    }
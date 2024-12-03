	public S animate(Timer timer)
	{
		long elapsed = timer.elapsedTime() - Timer.tickToTime(delay);
		started = elapsed > transform.getDelay();
		finished = elapsed > transform.totalDuration() && transform.getLoops() != -1;

		if (!started && !renderBefore)
			return null;
		if (finished && !renderAfter)
			return null;

		transform.transform(transformable, elapsed);
		return transformable;
	}
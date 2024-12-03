   public ArrayList<Duration> segmentWork(ProjectCalendar projectCalendar, List<TimephasedWork> work, TimescaleUnits rangeUnits, List<DateRange> dateList)
   {
      ArrayList<Duration> result = new ArrayList<Duration>(dateList.size());
      int lastStartIndex = 0;

      //
      // Iterate through the list of dates range we are interested in.
      // Each date range in this list corresponds to a column
      // shown on the "timescale" view by MS Project
      //
      for (DateRange range : dateList)
      {
         //
         // If the current date range does not intersect with any of the
         // assignment date ranges in the list, then we show a zero
         // duration for this date range.
         //
         int startIndex = lastStartIndex == -1 ? -1 : getStartIndex(range, work, lastStartIndex);
         if (startIndex == -1)
         {
            result.add(Duration.getInstance(0, TimeUnit.HOURS));
         }
         else
         {
            //
            // We have found an assignment which intersects with the current
            // date range, call the method below to determine how
            // much time from this resource assignment can be allocated
            // to the current date range.
            //
            result.add(getRangeDuration(projectCalendar, rangeUnits, range, work, startIndex));
            lastStartIndex = startIndex;
         }
      }

      return result;
   }
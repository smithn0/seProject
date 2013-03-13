import java.util.*;
import static java.util.Calendar.*;

/**
  *
  *@author F16
  *
  */
public class Bus
{
  int busID;
  int busNumber; // fleet number
  int[] dailyHours;  // hours used on every day
  int weeklyHours; // hours used on this
  TimeTable timetable;
  public Bus(int requiredID)
  {
    busID = requiredID;
    busNumber = BusInfo.busNumber(requiredID);
  } // Bus constructor
  public setTimeTable(BusTimeTable table)
  {
   timetable = table;
  }
  public boolean checkDailyAvailability(Date date)
  {
   return BusInfo.isAvailable(busID, date);
  }
  public boolean checkHourlyAvailability(Date date, int startTime, int endTime)
  {
    return timetable.checkHourlyAvailability(date.getWeek(), startTime, endTime);
  }

} // class Bus

<<<<<<< HEAD
import java.util.*;
import static java.util.Calendar.*;

/**
  *
  *@author F16
=======
import java.util.Date;
import java.util.Calendar;

/**
  *
  *@author Tomas Cepulis, F16
>>>>>>> a0d33e9df43455a7a4ef54fb7471f40e503b5e67
  *
  */
public class Bus
{
<<<<<<< HEAD
  int busID;
  int busNumber; // fleet number
  int[] dailyHours;  // hours used on every day
  int weeklyHours; // hours used on this
  TimeTable timetable;
=======

  static int busID;
  static String busNumber; // fleet number
  static int daysUsed; // total number of days the bus was in use.
 
>>>>>>> a0d33e9df43455a7a4ef54fb7471f40e503b5e67
  public Bus(int requiredID)
  {
    busID = requiredID;
    busNumber = BusInfo.busNumber(requiredID);
<<<<<<< HEAD
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
=======
    daysUsed = 0;

  } // Bus constructor

  // availability for today
  public static boolean isAvailable()
  {
    return BusInfo.isAvailable(busID);
  } // isAvailable

  // availability for some day 
  public static boolean isAvailable(Date date)
  {
    return BusInfo.isAvailable(busID, date);
  } // isAvailable

  // sets availability for some day
  public static void setAvailability(Date date, boolean available)
  {
      BusInfo.setAvailable(busID, date, available);
  } // setAvailability

  public static String getDailyUse(Date day)
  {
    
    if (isAvailable(day))
      return day + " Not in use\n";
    else
      return day + " In use\n";
  } // getDailyUse

  /**
  *
  *@param date of the first day of the week
  *
  */
  public static String getWeeklyUse(Date day)
  {

    String usage = "Bus " + busID + " is used on these days this week: \n"; 
    Date newDay = day; 
    Calendar cal = Calendar.getInstance();
    
    for (int i = 0; i < 7; i++)
    {
      usage += getDailyUse(newDay);
      cal.setTime(newDay);
      cal.add(Calendar.DATE, 1);
      newDay = cal.getTime();
    } // for
 
    return usage;
  } // getWeeklyUse 

  public static int getWorkload(Date day)
  {
    Date newDay = day; 
    Calendar cal = Calendar.getInstance();
    for (int i = 0; i < 7; i++)
    {
      if (!isAvailable(newDay))
        daysUsed++;
      cal.setTime(newDay);
      cal.add(Calendar.DATE, 1);
      newDay = cal.getTime();
    } // for
    
    return daysUsed;
  } // getWorkload
} // class Bus


























>>>>>>> a0d33e9df43455a7a4ef54fb7471f40e503b5e67

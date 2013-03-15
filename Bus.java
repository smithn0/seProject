import java.util.*;
import static java.util.Calendar.*;

/**
  *
  *@author Tomas Cepulis, F16
  *
  */
public class Bus
{

  static int busID;
  static String busNumber; // fleet number
  static int daysUsed; // total number of days the bus was in use.
 
  public Bus(int requiredID)
  {
    busID = requiredID;
    busNumber = BusInfo.busNumber(requiredID);
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

trololo
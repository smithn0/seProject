/*Issues:
-- java.util.Date or ints for each day?
-- drivers change buses?  
-- what is the level of precision for bus availability? Day, hour, minute?

*/
import java.util.*;
import static java.util.Date.*;

/**
  *
  *@author Tomas Cepulis, F16
  *
  */
public class Bus
{

  static int busID;
   String busNumber; // fleet number

  byte[][] availability; // availability for each day at every minute

  int[] dailyHours;  // hours used on every day
  int weeklyHours; // hours used on this
 
  public Bus(int requiredID)
  {
    busID = requiredID;
    busNumber = BusInfo.busNumber(requiredID);

    availability = new byte [7][1440]; // seven days, each has 1440 minutes
    dailyHours = new int [7];
  } // Bus constructor

  public static boolean isAvailable(Date date)
  {
    return BusInfo.isAvailable(busID, date);
  } // isAvailable

  public static String getUsageDay(int day)
  {
    
    String usage = "Bus " + busID + " usage for the day " + day + " of the week\n"; 
   
/*
    int lastBusy = 0;
    for (int i =0; i < 1440; i++)
    {
      if
      boolean currentlyBusy = availability[day][0];

      while(currentlyBusy)
      {
        lastBusy = i;
      } // while

    } // for*/
    return usage;
  } // getUsageDay

  public static String getUsageWeek()
  {

        String usage = "Bus " + busID + " usage for the week:";

    return usage;
  } // getUsageWeek 

  public static void setAvailability(Date date, boolean available)
  {
      BusInfo.setAvailable(busID, date, available);
  } // setAvailability



} // class Bus


































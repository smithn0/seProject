/*Issues:
-- java.util.Date or ints for each day?
-- drivers change buses?  
-- what is the level of precision for bus availability? Day, hour, minute?

*/
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

  

} // class Bus


































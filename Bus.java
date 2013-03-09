import java.util.*;
import static java.util.Calendar.*;

pubic class Bus
{

  int driverID;
  String name;
  //int number;
  int holidays_taken;
  int hours_this_year; // ?
  int  hours_this_week

  public static void Driver(int requiredID)
  {
    driverID = requiredID;
    name = DriverInfo.getName(requiredID);
    holidays_taken = DriverInfo.getHolidaysTaken(requiredID);
    hours_this_year = DriverInfo.getHoursThisYear(requiredID);
    hours_this_week = DriverInfo.getHoursThisWeek(requiredID);
    System.out.println("What's up? nothing");

  } // Driver

}

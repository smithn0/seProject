import java.util.*;
import static java.util.Calendar.*;

pubic class Driver
{

  int driverID;
  String name;
<<<<<<< HEAD
  int holidays_taken;
  int hours_this_year;
  int hours_this_week;
  TimeTable timetable;
=======
  //int number;
  int holidays_taken;
  int hours_this_year; // ?
  int  hours_this_week

>>>>>>> a0d33e9df43455a7a4ef54fb7471f40e503b5e67
  public Driver(int requiredID)
  {
    driverID = requiredID;
    name = DriverInfo.getName(requiredID);
    holidays_taken = DriverInfo.getHolidaysTaken(requiredID);
    hours_this_year = DriverInfo.getHoursThisYear(requiredID);
    hours_this_week = DriverInfo.getHoursThisWeek(requiredID);
<<<<<<< HEAD
  }
  public setTimeTable(DriverTimeTable table)
  {
   timetable = table;
  }
  public boolean checkDailyAvailability(Date date)
  {
   return DriverInfo.isAvailable(driverID, date);
  }
  public boolean checkHourlyAvailability(Date date, int startTime, int endTime)
  {
    return timetable.checkHourlyAvailability(date.getWeek(), startTime, endTime);
  }
=======


  }

>>>>>>> a0d33e9df43455a7a4ef54fb7471f40e503b5e67
}

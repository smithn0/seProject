import java.util.Date;
import java.util.Calendar;
public class Roster
{
 Driver[] drivers;
 Bus[] buses;
 int[][] services;
 public Roster(Date startDate) //startDate must be a monday TODO in controller
 {
  drivers = DriverInfo.getDrivers();
  buses = BusInfo.getBuses();
  createWeeklyRoster(startDate)
 }
 createWeeklyRoster(Date startDate)
 {
  for(int i = 0; i < 6; i++) // for each day in that week
  {
   Date currentDate = startDate;
   currentDate.setDate(currentDate.getDate() + i);
   boolean[] availableDrivers = new boolean[drivers.length];
   boolean[] availableBuses = new boolean[buses.length];
   for(int j = 0; j < drivers.length; j++)
     availableDrivers[j] = drivers[j].checkDailyAvailability(currentDate);
   for(int j = 0; j < buses.length; j++)
     availableBuses[j] = buses[j].checkDailyAvailability(currentDate);
    //get routes
    //for each route 
    //get services per route
    //for each service 
    //fill them using drivers and buses
    //by checking hourly availability and location
   //priority array location of bus and driver
    //update database sql
    //update bus + driver timetable java
   
  }
 }
}

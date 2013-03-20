import java.util.Date;
import java.util.Calendar;
public class Roster
{
 Driver[] drivers;
 Bus[] buses;
 int[][] serviceTimings;
 int[] route, serviceIDs;
 public Roster(Date startDate) //startDate must be a monday TODO in controller
 {
  drivers = DriverInfo.getDrivers();
  buses = BusInfo.getBuses();
  route = BusStopInfo.getRoutes();
  createWeeklyRoster(startDate)
 }
 createWeeklyRoster(Date startDate)
 {
  for(int i = 0; i < 6; i++) // for each day in that week
  {
   Date currentDate = startDate;
   currentDate.setDate(currentDate.getDate() + i);
   timetableKind dayKind = TimetableInfo.timetableKind(currentDate);
   boolean[] availableDrivers = new boolean[drivers.length];
   boolean[] availableBuses = new boolean[buses.length];
   for(int j = 0; j < drivers.length; j++)
     availableDrivers[j] = drivers[j].checkDailyAvailability(currentDate);
   for(int j = 0; j < buses.length; j++)
     availableBuses[j] = buses[j].checkDailyAvailability(currentDate);
   for(int j =0; j < route.length; j++)
   {
     int driverID, busID;
     serviceIDs = TimetableInfo.getServices(route[j], dayKind);
     for(int k = 0; k < serviceIDs.length;k++)
     {
      serviceTimings[j][k] = TimetableInfo.getServiceTimes(route[j], dayKind, serviceIDs[k]);
     }
     for(int k = 0; k < serviceIDs.length;k++)
     {
      for(int z = 0;z < drivers.length; z++)
      {
       if(availableDrivers[z] && drivers[z].timetable.checkHourlyAvailability(currentDate.getDate(),serviceTiming[j][0],serviceTiming[j][serviceIDs.getSize()-1]))
       {
         //if(DriverInfo.getHoursThisWeek(drivers[z]) < 40) //less than 40 so driver can work a full 10 hour shift that day
           driverID = drivers[z];
           //DriverInfo.setHoursThisWeek(drivers[z])
       }
      }
      for(int z = 0;z < drivers.length; z++)
      {
       if(availableBuses[z] && buses[z].timetable.checkHourlyAvailability(currentDate.getDate(),serviceTiming[j][0],serviceTiming[j][serviceIDs.getSize()-1]))
       {
        busID = buses[z];
       }
      }
       drivers[z].timetable.addService(currentDate,serviceTiming[j][0],serviceTiming[j][serviceIDs.getSize()-1]),0,0,busID,serviceIDs[z]);
       buses[z].timetable.addService(currentDate,serviceTiming[j][0],serviceTiming[j][serviceIDs.getSize()-1]),0,0,driverID,serviceIDs[z]);
     }
    }
   }
  }
    //get services per route
    //for each service 
    //fill them using drivers and buses
    //by checking hourly availability and location
   //priority array location of bus and driver
    //update database sql
    //update bus + driver timetable java
   
}


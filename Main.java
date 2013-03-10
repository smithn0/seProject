/*
 * A very simple application illustrating how to use the interface.
 * Prints the names of all the drivers in the database.
 * @author John Sargeant
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        database.openBusDatabase();
        int[] driverIDs = DriverInfo.getDrivers();
        String[] driverNames = new String [driverIDs.length];
        for (int i=0; i<driverIDs.length; i++)
            System.out.println(DriverInfo.getName(driverIDs[i]));

int[] a = BusStopInfo.getRoutes();
for (int j= 0; j<a.length; j++)
System.out.println(a[j]);

System.out.println(BusInfo.busNumber(577));

System.out.println(TimetableInfo.getTimingPoints(68) + "++++");

int[] b = TimetableInfo.getTimingPoints(68);
for (int j= 0; j<b.length; j++)
System.out.println(b[j]);
    }

}

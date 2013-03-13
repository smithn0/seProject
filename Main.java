/*
 * A very simple application illustrating how to use the interface.
 * Prints the names of all the drivers in the database.
 * @author John Sargeant
 */
<<<<<<< HEAD
public class BusDB {
=======
public class Main {
>>>>>>> a0d33e9df43455a7a4ef54fb7471f40e503b5e67

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        database.openBusDatabase();
        int[] driverIDs = DriverInfo.getDrivers();
        String[] driverNames = new String [driverIDs.length];
        for (int i=0; i<driverIDs.length; i++)
            System.out.println(DriverInfo.getName(driverIDs[i]));
<<<<<<< HEAD
=======

int[] a = BusStopInfo.getRoutes();
for (int j= 0; j<a.length; j++)
System.out.println(a[j]);

System.out.println(BusInfo.busNumber(577));

System.out.println(TimetableInfo.getTimingPoints(68) + "++++");

int[] b = TimetableInfo.getTimingPoints(68);
for (int j= 0; j<b.length; j++)
System.out.println(b[j]);
>>>>>>> a0d33e9df43455a7a4ef54fb7471f40e503b5e67
    }

}

import java.util.Calendar;
import java.util.Date;
  public class BusTest
{
  public static void main(String[] args)
  {
		database.openBusDatabase();

		Bus test = new Bus(572);

		System.out.println("bus id: " + test.busID);
		System.out.println("bus number: " + test.busNumber);


		Date testDate = new Date(113, 3, 15);
		System.out.println(testDate);

		test.setAvailability(testDate, false);

		System.out.println(test.isAvailable(testDate));

    System.out.println(test.isAvailable(testDate));

    System.out.println("asdasdasd");
    System.out.println(test.getWeeklyUse(testDate));
    System.out.println(" used on " + test.getWorkload(testDate) + " days");
	}	
}

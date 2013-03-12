import java.util.Date;

public class BusTest
{

	public static void main(String[] args)
	{
		database.openBusDatabase();

		Bus test = new Bus(572);

		System.out.println("bus id: " + test.busID);
		System.out.println("bus number: " + test.busNumber);
		System.out.println("availability " + test.availability[0][51]);

		Date testDate = new Date(113, 5, 15, 5, 21);
		System.out.println(testDate);

		test.setAvailability(testDate, true);
	}	
}
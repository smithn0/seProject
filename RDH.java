import java.util.Date;
import java.util.Calendar;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * @author F16
 */
public class RDH extends JFrame implements FocusListener{

    private JTextField idField = new JTextField("Insert ID");
    private JTextField sDay = new JTextField("Insert day");
    private JTextField sMonth = new JTextField("Insert month");
    private JTextField sYear = new JTextField("Insert year");
    private JTextField eDay = new JTextField("Insert day");
    private JTextField eMonth = new JTextField("Insert month");
    private JTextField eYear = new JTextField("Insert year");
    private JPanel S_date = new JPanel();
    private JPanel E_date = new JPanel();
    private JButton submit = new JButton("Submit");
    private JTextField result = new JTextField("Result:");
    private JTextField reason = new JTextField("");
    public RDH()
    {
      setPreferredSize(new Dimension(400,450));
     setTitle("Request Driver Holiday");
     Container contents = getContentPane();
     contents.setLayout(new GridLayout(0, 1));
     contents.add(new JLabel("Driver ID"));
     contents.add(idField);
     contents.add(new JLabel("Start Date"));
     S_date.add(sDay);
     S_date.add(sMonth);
     S_date.add(sYear);
     contents.add(S_date);
     contents.add(new JLabel("End Date"));
     E_date.add(eDay);
     E_date.add(eMonth);
     E_date.add(eYear);
     contents.add(E_date);
     contents.add(submit);
     result.setEditable(false);
     reason.setEditable(false);
     contents.add(result);
     contents.add(reason);
     idField.addFocusListener(this);
     sDay.addFocusListener(this);
     sMonth.addFocusListener(this);
     sYear.addFocusListener(this);
     eDay.addFocusListener(this);
     eMonth.addFocusListener(this);
     eYear.addFocusListener(this);
     submit.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent e)
      {
       initiateRequest();
      }
     });
     setDefaultCloseOperation(EXIT_ON_CLOSE);
     pack(); 
    
    }
    public void initiateRequest()
    {
      Date StartDate, EndDate;
       int driver;
	try{
       StartDate = new Date(Integer.parseInt(sYear.getText())-1900,
       Integer.parseInt(sMonth.getText())-1, Integer.parseInt(sDay.getText()));
       EndDate = new Date(Integer.parseInt(eYear.getText())-1900,
       Integer.parseInt(eMonth.getText())-1, Integer.parseInt(eDay.getText()));
       //System.out.println(StartDate.toString() + "" + EndDate.toString());
       driver = Integer.parseInt(idField.getText());
       } catch(Exception exep){ 
	 result.setText("Please Insert valid input !!");
	 return;
	 }
       if(!check_date(Integer.parseInt(sYear.getText()),
       Integer.parseInt(sMonth.getText()), Integer.parseInt(sDay.getText())))
       {
        result.setText("Result: Invalid Date"); // not working
	return;
       }
       
       if(!check_date(Integer.parseInt(eYear.getText()),
       Integer.parseInt(eMonth.getText()), Integer.parseInt(eDay.getText())))
       {
        result.setText("Result: Invalid Date"); //not working
	return;
       }
       boolean success = check_holiday(driver, StartDate, EndDate);
       if(success)
        result.setText("Result: Request Accepted");
       else 
        result.setText("Result: Request Rejected");
    }
    
    public void focusGained(FocusEvent fe) {
    
      JTextField source = (JTextField) fe.getSource();
      source.setText("");
    }
    public void focusLost(FocusEvent fe) {
    
    }
    public boolean check_date(int year, int month, int day) // doesnt work
    {  
        Date testDate = new Date(year-1900, month-1, day);
        if(month < 1 || month > 12)
	 return false;
        if(year != database.today().getYear())
	 return false;
        boolean leapYear =((year % 4) == 0 && ((year % 100) != 0) || (year % 400) == 0);
        int daysInMonth = 31;
	if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12);
	daysInMonth = 31;
	if (month == 4 || month ==6 || month == 9 || month == 11);
	daysInMonth = 30;
	if (month == 2);
	daysInMonth = 28;
	if (leapYear && month == 2);
	daysInMonth = 29;
	if(day < 1 || day > daysInMonth)
	  return false;
	if(database.today().after(testDate))
	  return false;
	
	return true;
      }
    public static void main(String[] args) {
       RDH rdh = new RDH();
       rdh.setVisible(true);
	 
    }
    boolean check_holiday(int DriverId, Date Sdate, Date Edate)
    {
	database.openBusDatabase();
	if(database.busDatabase.find_id("driver", "driver_id", Integer.parseInt(idField.getText()))== 0)
	{
         reason.setText("Reason: Invalid ID");
	 return false;
	}
	Calendar c = Calendar.getInstance();
	int monthMaxDays = c.getActualMaximum(Sdate.getDate());
	int holidayLength;
	if(Sdate.after(Edate))
	{
	  reason.setText("Reason: End date must be after start date");
	  return false;
	}
	if(Edate.getMonth() != Sdate.getMonth())
	  holidayLength = Edate.getDate() + (monthMaxDays - Sdate.getDate());
	else
	 holidayLength = Edate.getDate() - Sdate.getDate() + 1;
	int holidaysTaken = DriverInfo.getHolidaysTaken(DriverId);
	if(holidaysTaken + holidayLength <= 25)
	{
	  int[] driverIDs = database.busDatabase.select_ids("driver_id" , "holiday_driver", "driver_id");
	  Date[] Sdates = new Date[driverIDs.length], Edates = new Date[driverIDs.length];
	  for (int i=0; i<driverIDs.length; i++)
	  {
	    Sdates[i] = database.busDatabase.get_date2("holiday_driver","driver_id", driverIDs[i],
	    "start_date");
	    Edates[i] = database.busDatabase.get_date2("holiday_driver","driver_id", driverIDs[i],
	    "end_date");
	    if(Edates[i].before(database.today()))
	      driverIDs[i] = -1;
	  }
	  int count[] = new int[holidayLength];
	  for(int i = 0; i<count.length;i++)
	    count[i] = 0;
	  
	  Date testDate = new Date(Sdate.getYear(), Sdate.getMonth(), Sdate.getDate());
	  for(int j = 0; j<count.length; j++)
	  {
	   testDate.setDate(Sdate.getDate() +j);
	    for (int i=0; i<driverIDs.length; i++)
	    {
	    if(driverIDs[i] != -1)
	     {
	       //System.out.println("Test Date " + testDate + " , Sdate " + Sdate);
	       if(((testDate).after(Sdates[i]) || (testDate).equals(Sdates[i])) && ((testDate).before(Edates[i]) || (testDate).equals(Edates[i])))
		 count[j]++;
	     }
	     if(driverIDs[i] == DriverId)
	     {
	       if(((testDate).after(Sdates[i]) || (testDate).equals(Sdates[i])) && ((testDate).before(Edates[i]) || (testDate).equals(Edates[i])))
	       {
		 reason.setText("Driver " + DriverId + " is already schedueled for a holiday on " + testDate.getDate() + "/" + (testDate.getMonth()+1) + "/" + (testDate.getYear()+1900));
		 return false;
	       }
	     }
	    } 
	  }
	  
	  //Find for each in count if weekday or weekend
	 for(int i = 0; i<count.length;i++)
	 {
	    System.out.println(count[i]);
	    if(count[i] >= 10)
	    {
	     reason.setText("Reason: holiday is not available during these dates");
	     return false;
	    }
	  }
	      
	 //ADD holiday to database and approve
	 //Request Confirmation
	 int reply = JOptionPane.showConfirmDialog(null, "Holiday is available, are you" +
	     " sure?" , "Confirmation", JOptionPane.YES_NO_OPTION);
	 if(reply == JOptionPane.YES_OPTION)
	 { 
	  database.busDatabase.new_record("holiday_driver", new Object[][] {{"driver_id",DriverId },{"start_date", Sdate},{"end_date", Edate}});
	  reason.setText("Enjoy your holiday !");
	  return true;
	 }
	 else 
	 {
	   reason.setText("you cancelled it!!");
	   return false;
	 }
	}
	else
	{
	 reason.setText("Reason: you are not allowed over 25 days of holiday a year");
	 return false;
	}
	   
    }

}
   
	


   
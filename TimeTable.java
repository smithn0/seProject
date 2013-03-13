public class TimeTable
{
 int[][][] table; 
 public TimeTable()
 {
  table = new int[7][10][7];//start,end,bus or driver Id, service,used
 }
 public addService(int day, int start, int end, int startStop, int endStop, int
 busOrDriverID, int serviceID)
 {
  for(int i = 0; i < 10;i++)
  {
   if(table[day][i][6] == 0)
   {
    table[day][i][0] = start;
    table[day][i][1] = end;
    table[day][i][2] = startStop;
    table[day][i][3] = endStop;
    table[day][i][4] = busOrDriverID;
    table[day][i][5] = serviceID;
    i = 11;
   }
  }
 }
 public boolean checkHourlyAvailability(int day, int startTime, int endTime)
 {
  for(int i = 0; i < 10; i++)
  {
   if(table[day][i][6] == 1)
   {
    if((startTime >= table[day][i][0] && startTime <= table[day][i][1]) ||
    	(endTime >= table[day][i][0] && endTime <= table[day][i][1])    ||
	(startTime <= table[day[i][0] && endTime >= table[day[i][1]))
	return false;
    }
   }
   return true;
 }
  
}

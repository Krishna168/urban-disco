package practice;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalenderPractice {
	public SimpleDateFormat sdf1;
	public SimpleDateFormat formatter;

	public String getFutureDate(int daysToBeAdded) {
		
		sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_YEAR, daysToBeAdded);
		Date futureDate = c.getTime();
		return sdf1.format(futureDate);
		
	}

	public String getFutureMonth(int monthsToBeAdded) {
		
		sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c1 = Calendar.getInstance();
		c1.add(Calendar.MONTH, monthsToBeAdded);
		Date futureMonth = c1.getTime();
		return sdf1.format(futureMonth);
		
	}

	public String getFutureMonthInString(int monthsToBeAdded) {
		
		formatter = new SimpleDateFormat("MMMMMMMMM");
		Calendar c2 = Calendar.getInstance();
		c2.add(Calendar.MONTH, monthsToBeAdded);
		Date date = c2.getTime();
		return formatter.format(date);
		
	}

	public static void main(String[] args) {
		
		CalenderPractice cp = new CalenderPractice();
		System.out.println(cp.getFutureDate(25));
		System.out.println(cp.getFutureMonth(7));
		System.out.println(cp.getFutureMonthInString(5));
		
	}

}

import java.util.Calendar;
import java.util.Locale;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.TextStyle;

public class Date {
	private int dd, mm, yyyy, dayOfYear;
	private String monthName;
	public Date(int day, int month, int year){
		Calendar cal = Calendar.getInstance();
		dd = day;
		mm = month;
		yyyy = year;
		monthName = Month.of(mm).getDisplayName(
				TextStyle.FULL_STANDALONE, 
				Locale.CANADA.ENGLISH); // Source: https://stackoverflow.com/questions/1038570/how-can-i-convert-an-integer-to-localized-month-name-in-java
		cal.set(year, month-1, day);
		dayOfYear = cal.get(Calendar.DAY_OF_YEAR);
	}
	public Date(String month, int day, int year) {
		Calendar cal = Calendar.getInstance();
		dd = day;
		mm = Month.valueOf(month.toUpperCase()).getValue();
		yyyy = year;
		monthName = month;
		cal.set(year, mm-1, day);
		dayOfYear = cal.get(Calendar.DAY_OF_YEAR);
	}
	public Date(int day, int year) {
		LocalDate ld = Year.of( year ).atDay( day ) ;
        dd = ld.getDayOfMonth();
        mm = ld.getMonth().getValue();
        yyyy = year;
        monthName = ld.getMonth().getDisplayName(
				TextStyle.FULL_STANDALONE, 
				Locale.CANADA.ENGLISH);
        dayOfYear = day;
	}
	/*
	public String determineMonth(int mm) {
		String month = "";
		Month.of(mm);
		switch(mm) {
		case 1:
			month = "January";
			break;
		case 2:
			month = "February";
			break;
		case 3:
			month = "March";
			break;
		case 4:
			month = "April";
			break;
		case 5:
			month = "January";
			break;
		case 6:
			month = "January";
			break;
		case 7:
			month = "January";
			break;
		case 8:
			month = "January";
			break;
		case 9:
			month = "January";
			break;
		case 10:
			month = "January";
			break;
		case 11:
			month = "January";
			break;
		case 12:
			month = "January";
			break;
		}
		return month;
	}
	*/
	public int getDay() {
		return dd;
	}
	public int getMonth() {
		return mm;
	}
	public int getYear() {
		return yyyy;
	}
	public int getDayOfYear() {
		return dayOfYear;
	}
	public String getMonthName() {
		return monthName;
	}
}

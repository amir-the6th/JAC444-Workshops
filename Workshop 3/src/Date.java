/**********************************************
Workshop #3
Course:JAC444 - Fall 2021
Name: Amirhossein Sabagh
ID:152956199
Section:NDD
This assignment represents my own work in accordance with Seneca Academic Policy.
Date:2021-10-10
**********************************************/
import java.util.Calendar;
import java.util.Locale;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.TextStyle;

public class Date {
	private int dd, mm, yyyy, dayOfYear;
	private String monthName;
	/**
	 * 3-arg constructor
	 * @param day - int
	 * @param month - int
	 * @param year - int
	 */
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
	/**
	 * 3-arg constructor
	 * @param month - String
	 * @param day - int
	 * @param year - int
	 */
	public Date(String month, int day, int year) {
		Calendar cal = Calendar.getInstance();
		dd = day;
		mm = Month.valueOf(month.toUpperCase()).getValue();
		yyyy = year;
		monthName = month;
		cal.set(year, mm-1, day);
		dayOfYear = cal.get(Calendar.DAY_OF_YEAR);
	}
	/**
	 * 2-arg constructor
	 * @param day - int
	 * @param year - int
	 */
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
	/**
	 * @return dd - day number
	 */
	public int getDay() {
		return dd;
	}
	/**
	 * @return mm - month number
	 */
	public int getMonth() {
		return mm;
	}
	/**
	 * @return yyyy - year number
	 */
	public int getYear() {
		return yyyy;
	}
	/**
	 * @return dayOfYear - day number (of year)
	 */
	public int getDayOfYear() {
		return dayOfYear;
	}
	/**
	 * @return monthName - month name
	 */
	public String getMonthName() {
		return monthName;
	}
}

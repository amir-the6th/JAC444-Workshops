import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class CountriesCapitals {

	public static void main(String[] args) {
		boolean exit = false;
		Scanner scan = new Scanner(System.in);
		
		Map<String, String> countriesCapitals = setData();
		
		while(!exit) {
			System.out.print("Enter a country: ");
			String country = scan.nextLine();
			
			if (countriesCapitals.get(country) != null) {
				System.out.println("The capital of " + country + " is " 
					+ countriesCapitals.get(country) + "\n");
			}
		}
		scan.close();
	}

	public static Map<String, String> setData() {
		Map<String, String> map = new HashMap<>();
		String[][] countriesData = {
				{"Iran", "Tehran"},
				{"Canada", "Ottawa"},
				{"Chile", "	Santiago"},
				{"China", "Beijing"},
				{"Philippines", "Manila"},
				{"Qatar", "Doha"},
				{"Spain", "Madrid"},
				{"Russia", "Moscow"},
				{"Norway", "Oslo"},
				{"Netherlands", "Amsterdam"},
				{"Mexico", "Mexico City"},
				{"Madagascar", "Antananarivo"},
				{"Pakistan", "Islamabad"},
				{"Denmark", "Copenhagen"},
				{"Egypt", "Cairo"},
				{"France", "Paris"},
				{"United Kingdom", "London"},
				{"United States of America", "Washington, D.C."},
				{"Jamaica", "Kingston"},
				{"Malaysia", "Kuala Lumpur"},
				{"India", "New Delhi"},
				{"Germany", "Berlin"},
				{"South Korea", "Seoul"},
				{"Italy", "Rome"},
				{"Japan", "Tokyo"},
		};
		
		for (int i=0; i < countriesData.length; i++) map.put(countriesData[i][0], countriesData[i][1]);
		
		return map;
	}
}

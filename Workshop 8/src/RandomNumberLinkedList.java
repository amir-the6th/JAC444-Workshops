import java.util.Collections;
import java.util.Random;
import java.util.LinkedList;
import java.util.List;

public class RandomNumberLinkedList {

	public static void main(String[] args) {
		int sum = 0;
		Random r = new Random();
		Integer[] random = new Integer[25];
		
		for(int i = 0; i < random.length; i++) {
			random[i] = r.nextInt(100) + 1;
		}
		
		final List<Integer> randomList = new LinkedList<Integer>();

		

		int randnum;



		for(int i = 0;i<25;i++) {
			randnum = r.nextInt(101);
			randomList.add(new Integer(randnum));    
			sum+=randnum;
		}

		Collections.sort(randomList);

		System.out.println(randomList);

		System.out.println("Average: "+(float)sum/25);
	}

	/*
	 * LinkedList<Integer> myList = new LinkedList<Integer>();

   Random rand = new Random();

   int randnum;

   int sum = 0;

   for(int i = 0;i<25;i++)     {

       randnum = rand.nextInt(101);

       myList.add(new Integer(randnum));    

       sum+=randnum;

   }

   Collections.sort(myList);

   System.out.println(myList);

   System.out.println("Average: "+(float)sum/25);
	 */
}

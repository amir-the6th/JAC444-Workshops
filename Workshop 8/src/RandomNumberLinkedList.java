import java.util.Collections;
import java.util.Random;
import java.util.LinkedList;
import java.util.List;

public class RandomNumberLinkedList {

	public static void main(String[] args) {
		final int MAX_RANDOM = 25;
		int randNum = 0, sum = 0;
		Random r = new Random();		
		
		
		final List<Integer> randomList = new LinkedList<Integer>();
		for(int i = 0; i < MAX_RANDOM; i++) {
			randNum = r.nextInt(100) + 1;
			randomList.add(randNum);
			sum += randNum;
		}

		System.out.println("\nBefore Sort:");
		System.out.println(randomList);

		System.out.println("\nAfter Sort:");
		Collections.sort(randomList);
		System.out.println(randomList);

		System.out.println("\nAverage: " + (float)sum/MAX_RANDOM);
	}
}

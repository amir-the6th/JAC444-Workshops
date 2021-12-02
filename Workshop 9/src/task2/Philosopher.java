/**********************************************
Workshop #9
Course:JAC444 - Fall 2021
Name: Amirhossein Sabagh
ID:152956199
Section:NDD
This assignment represents my own work in accordance with Seneca Academic Policy.
Date:2021-12-01
**********************************************/
package task2;

public class Philosopher implements Runnable {
	 
    private Object leftChop;
    private Object rightChop;
    private String name;

    public Philosopher(Object leftChop, Object rightChop, String name) {
        this.leftChop = leftChop;
        this.rightChop = rightChop;
        this.name = name;
    }

	private void defineAction(String action) {
        System.out.println(this.name + action);
        try { Thread.sleep(((int)(Math.random() * 100))); } 
        catch (InterruptedException e) { e.printStackTrace();	}
    }

    @Override
    public void run() {
    	int i = 0;
        while(i++ < 3) {
			defineAction(": Thinking");
		    synchronized (leftChop) {
		    	defineAction(": Picked up the left chopstick");
		        synchronized (rightChop) {
		        	defineAction(": Picked up the right chopstick -> Now eating!"); 
		        	defineAction(": Put down the right chopstick");
		        }
		        defineAction(": Put down the left chopstick -> Back to thinking!");
		    }
		}
    }
}

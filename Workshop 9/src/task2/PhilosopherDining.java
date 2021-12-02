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

public class PhilosopherDining {
    public static void main(String[] args) throws Exception {
        final Philosopher[] philosophers = new Philosopher[5];
        Object[] chops = new Object[philosophers.length];
        final String[] phNames = {"Socrates","Aristotle", "Plato", "Nietzsche", "Sartre"};

        for (int i = 0; i < chops.length; i++) chops[i] = new Object();       
        for (int i = 0; i < philosophers.length; i++) {
            Object leftChop = chops[i];
            Object rightChop = chops[(i + 1) % chops.length];
            // To avoid a deadlock, the last philosopher picks up the right chop first instead of the left chop
            if (i == philosophers.length - 1) philosophers[i] = new Philosopher(rightChop, leftChop, phNames[i]);
            else philosophers[i] = new Philosopher(leftChop, rightChop, phNames[i]);
            
            Thread t1 = new Thread(philosophers[i]);
            t1.start();
        }
    }
}

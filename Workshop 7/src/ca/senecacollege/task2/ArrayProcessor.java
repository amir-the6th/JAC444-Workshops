package ca.senecacollege.task2;

/**
 * A functional interface which has one function operations that 
 * returns a double and takes a double type array as its argument
 * 
 * @author Amir
 */
@FunctionalInterface
public interface ArrayProcessor {

	double operations(double[] arr);
}

package calculatordemo.ui;

import calculatordemo.Calculator;
import calculatordemo.ICalculator;
import calculatordemo.ScientificCalculator;
import schoolmgt.Student;

/**
 * 
 * Main class , it's only purpose is to provide main method
 * because JVM needs entry point to start execution
 *  and main method is that entry point 
 * 
 */
public class CalculatorMain {
	/**
	 * 
	 * entry point to start execution for JVM
	 */
	public static void main(String args[]) {	   
		ICalculator calculator=new ScientificCalculator();
		int addResult=calculator.add(1,2);
		int subResult=calculator.sub(10, 3);
		System.out.println("add result="+addResult);
		System.out.println("sub result="+subResult);
		
	}
	
}

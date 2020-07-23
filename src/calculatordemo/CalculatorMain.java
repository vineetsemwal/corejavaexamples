package calculatordemo;

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
		Calculator calculator=new Calculator();
		int intResult=calculator.add(1,2);
        intResult=calculator.add(1, 2,3);
		double doubleResult=calculator.add(2.0, 3.0);
        String stringResult=calculator.add("hydera", "bad");
        System.out.println("int add result="+intResult);
        System.out.println("double add result="+doubleResult);
        System.out.println("string concat result="+stringResult);
        
        Student student=new Student("pradeep",21,true);
        student.getAge();
	}
	
}

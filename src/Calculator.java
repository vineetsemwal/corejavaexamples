/**
 * 
 *  1) Fields ,values represents state of object
 *  2) Functions represents functionality
 * 
 * We have created blueprint/design of Calculator
 * 
 *  A used defined Class is a used defined data type
 */
public class Calculator {	
	
	 int integerResult;
	
	int getIntegerResult() {
		return integerResult;
	}
	
	
	/**
	 * 
	 * compiler will know these three methods are different from number of args or type of args
	 */
	int add(int num1, int num2) {		
	   int 	result=num1+num2; 
	   return result;
	}
	
	
	int add(int num1, int num2, int num3) {
	  int result=add(num1,num2);
	  result=result+num3;
	  return result;
	}
	

	double add(double num1, double num2) {		
	   double result=num1+num2; 
	   return result;
	}
	
	String add(String arg1, String arg2) {
		String result=arg1+arg2;
		return result;
	}
	
}

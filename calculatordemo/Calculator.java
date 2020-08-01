package calculatordemo;
/**
 * 
 *  1) Fields ,values represents state of object
 *  2) Functions represents functionality
 * 
 * We have created blueprint/design of Calculator
 * 
 *  A used defined Class is a used defined data type
 */
public class Calculator implements ICalculator{

	@Override
	public int sub(int num1, int num2) {
		int result=num1-num2;
		return result;
	}

	@Override
	public int add(int num1, int num2) {
		int result=num1+num2;
		return result;
	}	
	
	
	
}

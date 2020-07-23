package calculatordemo;

public class ScientificCalculator implements ICalculator{

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

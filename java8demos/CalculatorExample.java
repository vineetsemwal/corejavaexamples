package java8demos;

public class CalculatorExample {

    public static void main(String args[]){
        // anonymous class and its use
        //
        ICalculator calculator1=new ICalculator() {
            @Override
            public int add(int num1, int num2) {
                return num1+num2;
            }
        };

    }
}

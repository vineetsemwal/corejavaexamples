package wrapperdemos;

public class DxcIntegerDemo {
	
	public static void main(String args[]) {
	  DxcInteger wrapper=new DxcInteger(10);
	  String str=wrapper.toString();
	  byte b=wrapper.byteValue();
	  double d=wrapper.doubleValue();
	}

}

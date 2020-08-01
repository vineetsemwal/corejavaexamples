package castingdemos;

public class CastingExample {
 
	public static void main(String args[]) {
		byte bite=10; // 1 byte, 8 bits 
		int intNum=bite; // int is of 4 bytes, 32 bits
		
		
	//	-128 to 127
		int intNum2=150; 
		//unsafe , there will be data loss as 150 is out of the range of byte -128 to +127 
		byte bite2=(byte)intNum2;// byte is 1byte,8bits while int is 4 byte,32 bits
		
		System.out.println("int num="+intNum);
		
		System.out.println("intNum2="+intNum2+" bite2="+bite2);
	}
}

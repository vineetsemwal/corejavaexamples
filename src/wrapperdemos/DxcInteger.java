package wrapperdemos;


/**
 * 
 * wrapping int field + methods for commonly used operations 
 *
 */
public class DxcInteger {
	int number;// field which will hold data
	
	//commonly used methods which are useful for people
	///so people will not have to write from scratch
	// they can just use these methods
	
	public DxcInteger(int number){
     this.number=number;		
	}
	
	public String toString() {
		String str= ""+number;
		return str;
	}
	
	public double doubleValue(){
    double d=number;		
	return d;	
	}
	
	public byte byteValue() {
	byte b=(byte)number;	
    return b;		
	}	

}

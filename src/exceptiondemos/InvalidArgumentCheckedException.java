package exceptiondemos;

/**
 * 
 * InvalidArgumentCheckedException is custom checked exception class ,
 *  it is checked because it is inheriting Exception which is itself Checked
 *  
 *   Compiler forces us to handle Checked exceptions
 * 
 */
public class InvalidArgumentCheckedException extends Exception{

	public InvalidArgumentCheckedException(String msg) {
		super(msg);
	}
	
}

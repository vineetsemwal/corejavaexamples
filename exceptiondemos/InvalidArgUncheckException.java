package exceptiondemos;

/**
 * 
 * InvalidArguncheckException is unchecked exception because it is extending RuntimeException
 * Compiler will not force us to handle exception
 */
public class InvalidArgUncheckException extends RuntimeException {

	public InvalidArgUncheckException(String msg) {
		super(msg);
	}
}

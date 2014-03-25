//import be.kuleuven.cs.som.annotate.*;

/**
 * A class for signaling illegal Name for monster.
 * 
 * @note     This will provide a public method  to return the 
 * 			 the message to display in catch section.
 * @version  1.0
 * @author   Shahab Ud Din
 */
public class IllegalNameException extends Exception {

	private static final long serialVersionUID = 1L;
	/**
	 * Variable registering the name involved in this illegal name exception.
	 */
	private final String name;
	/**
	 * Variable registering the message involved in this illegal name exception.
	 */
	private final String message;

	/**
	 * Initialize this new illegal name exception with given value.
	 * 
	 * @param  value
	 *         The value for this new illegal name exception.
	 * @post   The value of this new illegal name exception is equal
	 *         to the given name.
	 *       | new.getValue() == name
	 * @post   The value of this new message for illegal name exception is equal
	 *         to the given name concatenated with a message "  is an Illegal Hitpoint Value"
	 *       | new.getMessage() == name + "  is an Illegal Hitpoint Value"
	 */
	public IllegalNameException(String illegalName) {
		this.name = illegalName;
		this.message = this.name +"  is an Illegal Name";
	}
	
	public String getIllegalName () {
		return this.name;
	}
	
	public String getMessage () {
		return this.message;
	}
}

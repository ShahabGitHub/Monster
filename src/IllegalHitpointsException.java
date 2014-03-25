import be.kuleuven.cs.som.annotate.*;

/**
 * A class for signaling illegal Hitpoints for monster.
 * 
 * @note     This will provide a public method  to return the 
 * 			 the message to display in catch section.
 * @version  1.0
 * @author   Shahab Ud Din
 */

public class IllegalHitpointsException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	/**
	 * Initialize this new illegal hitpoints exception with given value.
	 * 
	 * @param  value
	 *         The value for this new illegal hitpoints exception.
	 * @post   The value of this new illegal hitpoints exception is equal
	 *         to the given value.
	 *       | new.getValue() == value
	 * @post   The value of this new message for illegal hitpoints exception is equal
	 *         to the given value concatenated with "  is an Illegal Hitpoint Value".
	 *       | new.getMessage() == Integer.toString (value) + "  is an Illegal Hitpoint Value"
	 */
	public IllegalHitpointsException(int value) {
		this.value = value;
		this.message = Integer.toString(value)+"  is an Illegal Hitpoint Value";
	}

	/**
	 * Return the value registered for this illegal hitpoints exception.
	 */
	@Basic @Immutable
	public int getValue() {
		return this.value;
	}
	/**
	 * Return the message registered for this illegal hitpoints exception.
	 */
	@Basic @Immutable
	public String getMessage() {
		return this.message;
	}

	/**
	 * Variable registering the value involved in this illegal hitpoints exception.
	 */
	private final int value;
	/**
	 * Variable registering the message involved in this illegal hitpoints exception.
	 */
	private final String message;
}

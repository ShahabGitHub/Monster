import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Immutable;


public class IllegalWeightException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public IllegalWeightException(int value) {
		this.value = value;
		this.message = Integer.toString(value)+"  is an Illegalweight Value for weapon";
	}
	/**
	 * Return the value registered for this illegal weight exception.
	 */
	@Basic @Immutable
	public int getValue() {
		return this.value;
	}
	/**
	 * Return the message registered for this illegal weight exception.
	 */
	@Basic @Immutable
	public String getMessage() {
		return this.message;
	}

	/**
	 * Variable registering the value involved in this illegal weight exception.
	 */
	private final int value;
	/**
	 * Variable registering the message involved in this illegal weight exception.
	 */
	private final String message;
}

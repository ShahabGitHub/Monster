import be.kuleuven.cs.som.annotate.*;

/**
 * A class for dealing with Weapon, Displaying the different
 * properties of Weapon. Properties includes identification and weight
 * value, damage, and holder.
 * 
 * @invar   The weight of each weapon must be a legal
 *          weight for a weapon.
 *        | isValidIdentification(getIdentification())
 * @invar   The value of each monster must be a valid 
 *          value for a weapon.
 *        | isValidValue(getValue())
 * @invar  The damage of each monster must be a valid damage for a
 *         weapon.
 *         | isValidDamage(getDamage())
 * @invar   The holder of each weapon must be a legal
 *          holder for a weapon.
 *        | isValidHolder(getHolder())
 * 
 * @version  2.0
 * @author   Shahab Ud Din at Git
 */
public class Weapon {
	
	
	
	
	/**
	 * Variable reflecting the identification of this weapon
	 */	
	private final long identification;
	/**
	 * Variable reflecting the value of this weapon
	 */	
	private int value;
	/**
	 * Variable reflecting the next unique and valid identification value for 
	 * generating identification of a new created weapon
	 */	
	private static long WeaponIdentification = 1;
	
	
	
	
	//************* Constructor
	/**
     * Initialize this new weapon with given parameters.
     * 
     * @param  value
     * 		   The value for this new weapon.
     * @pre	   The given value must be a valid value for an weapon.
     *       | isValidValue(value)
     * @post   The value of this new weapon is equal to the given
     * 		   value.
     *       | new.getValue() == value
     * @note   Any new weapon initialized with this constructor
     * 		   will satisfy all its class invariants.
     */
	
	public Weapon (int value) {
		this.identification = generateUniqueValidIdentification();
		this.setValue(value);
	}
	
	
	
	//*****************Value
	
	/**
     * Check whether the given value is a valid value for any weapon.
     *  
     * @param  value
     * 		   The value of weapon to check.
     * @return True if and only if the given identification is a positive number 
     *       | result == (value >= 0)
     */
	public static boolean isValidValue (int value) {
		return (value >= 0);
	}
	
	/**
     * Set the value of this weapon to the given value.
     * 
     * @param  value
     * 		   The new value for this weapon.
     * @pre    The given value must be a valid value for a  weapon.
     *       | isValidValue(value)
     * @post   The value of this weapon is equal to the given value.
     *       | new.getValue() == value
     */
	
	public void setValue(int value) {
		assert (isValidValue(value));
		this.value = value;
	}
	/**
     * Return the value of this weapon.
     */
    public int getValue() {
    	return this.value;
    }
    
    
    /**
     * Decrease the value this weapon with the given amount.
     * 
     * @param  amount
     *         The amount to be increased in value of the weapon.
     * @pre    The given amount must be positive.
     *       | amount > 0
     * @effect The value of this weapon is set to its current value
     *         decreased with the given amount value.
     *       | setValue(getValue() - amount)
     */
    public void decreaseValue(int amount) {
        assert amount > 0;
        this.setValue(this.getValue() - amount);
    }
    
    /**
     * Increase the value this weapon with the given amount.
     * 
     * @param  amount
     *         The amount to be increased in value of the weapon.
     * @pre    The given amount must be positive.
     *       | amount > 0
     * @effect The value of this weapon is set to its current value
     *         incremented with the given amount value.
     *       | setValue(getValue() + amount)
     */
    public void increaseValue(int amount) {
        assert amount > 0;
        this.setValue(this.getValue() + amount);
    }
	
	//*****************Identification
	/**
     * generate and return a unique valid  identification for a weapon.
     * 
     * 
     * @param  identification
     * 		   The identification of weapon to check.
     * @return a unique and valid identification for a new weapon 
     *       | result == weaponIdentification
     * @post   weaponIdentification is incremented by two 
	 *        |   weaponIdentification = weaponIdentification + 2
	 *  
     */
	// temporarily public for testing, it should be private
	public static long generateUniqueValidIdentification () {
		long identification = WeaponIdentification ;
		WeaponIdentification = WeaponIdentification + 2;
		return identification;
	}
	/**
     * Check whether the given identification is a valid identification for any weapon.
     *  
     * @param  identification
     * 		   The identification of weapon to check.
     * @return True if and only if the given identification is a positive odd number 
     *       | result == (identification % 2 == 1)  && (identification >= 1)
     */
	public boolean isValidIdentification(long identification) {
		return (identification % 2 == 1) && (identification >= 1);
	}
	
	/**
     * Return the identification of this weapon.
     */
    public long getIdentification() {
    	return this.identification;
    }

}

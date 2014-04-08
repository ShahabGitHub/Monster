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
	 * Constant reflecting the Minimum possible value of all weapon
	 */
	private static final int MIN_VALUE = 0;
	/**
	 * Constant reflecting the Minimum damage of all weapon
	 */
	private static final int MIN_DAMAGE = 1;
	/**
	 * Variable reflecting the identification of this weapon
	 */	
	private final long identification;
	/**
	 * Variable reflecting the value of this weapon
	 */	
	private int value;
	/**
	 * Variable reflecting the damage afflicted by this weapon
	 */	
	private int damage;
	/**
	 * Variable reflecting the next unique and valid identification value for 
	 * generating identification of a new created weapon
	 */	
	private static long WeaponIdentification = 1;
	/**
	 * Constant reflecting the maximum damage afflicted by all weapons
	 */	
	private static final int Max_Damage = 20;
	/**
	 * Constant reflecting the minimum weight of all weapons
	 */	
	private static final int MIN_WEIGHT = 0;
	/**
	 * Constant reflecting the weight of  weapons
	 */	
	private  final int WEIGHT;
	/**
	 * Variable reflecting the Holder Monster of  this weapon
	 */
	private Monster holder;
		
	
	
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
     * @param  damage
     * 		   The new damage for this weapon.
     * @pre    The given value must be a valid value for a  weapon.
     *       | isValidDamage(damage)
     * @post   The value of this weapon is equal to the given value.
     *       | new.getDamage() == damage
     * @param  weight
     * 		   The weight for this new weapon.
     * @post   The weight of this new monster is equal to the given weight.
     *       | new.getWeight() == weight
     * @throws IllegalWeightException
	 * 		   The given weight is not a valid weight for
	 * 		   a monster.
	 *       | ! isValidWeight(weight)
     * @note   Any new weapon initialized with this constructor
     * 		   will satisfy all its class invariants.
     */
	
	public Weapon (int value, int damage, int weight)  throws IllegalWeightException{
		this.setValue(value);
		this.setDamage(damage);
		if (!isValidWeight(weight))
			throw new IllegalWeightException(weight);
		this.WEIGHT = weight;
		this.identification = generateUniqueValidIdentification();
		// currently setting it to null which means a weapon is always created
		// with out any holder and will be assigned to holder on later stage
		// can be changed after enquiring to teacher.
		this.holder = null; 
	}
	
	//********************************************************************Holder
	public Monster getHolder() {
		return this.holder;
	}
	
	
	public void setHolder(Monster holder) {
		this.holder = holder;
		// need to set the this weapon in Monster's Anchor for consistency
		// it can be checked either here of while setting this weapon in the 
		//monsters's anchor. If it is not consistent raise exception
		// one other issue is weather weapon can start with null holder
		//or it should always be created with null holder.
	}
	//********************************************************************Weight
	/**
     * Check whether the given weight is a valid weight for weapon.
     *  
     * @param  weight
     * 		   The weighte of weapon to check.
     * @return True if and only if the given weight is greater than or equal 
     * 	       to minimum minimum of all weapons.
     *       | result == (maxDamage >= Weapon.getMinDamage())
     */
	public static boolean isValidWeight(int weight){
		return weight >= MIN_WEIGHT;
	}
	
	/**
     * Return the damage afflicted by this weapon.
     */
    public int getWeight() {
    	return this.WEIGHT;
    }
	
	//********************************************************************Damage
	
	/**
     * Set the damage afflicted by this weapon to the given damage.
     * 
     * @param  damage
     * 		   The new damage for this weapon.
     * @pre    The given value must be a valid value for a  weapon.
     *       | isValidDamage(damage)
     * @post   The value of this weapon is equal to the given value.
     *       | new.getDamage() == damage
     */
	
	public void setDamage(int damage) {
		assert (isValidDamage(damage));
		this.damage = damage;
	}
	
	
	/**
     * Check whether the given damage is a valid damage for any weapon.
     *  
     * @param  damage
     * 		   The damage of weapon to check.
     * @return True if and only if the given damage is between minimum minimum
     * 	       and maximum damage.
     *       | result == (damage >= Weapon.getMinDamage() && damage <= Weapon.getMaxDamage())
     */
	public static boolean isValidDamage(int damage) {
		return (damage >= Weapon.getMinDamage() && damage <= Weapon.getMaxDamage());
	}
	
	/**
     * Set the maximum damage afflicted by all weapon to the given maximum damage.
     * 
     * @param  maxDamage
     * 		   The new maximum damage for all weapons.
     * @pre    The given maximum damage must be a valid maximum damage for all  weapons.
     *       | isValidMaxDamage(maxDamage)
     * @post   The new maximum damage of all weapon is equal to the given maximum damage.
     *       | new (Weapon.getMaxDamage()) == maxDamage
     */
	public static void setMaxDamage(int maxDamage) {
		assert(isValidMaxDamage(maxDamage));
		Weapon.setMaxDamage(maxDamage);
	}
	
	
	/**
     * Check whether the given maximum damage is a valid maximum damage for all weapons.
     *  
     * @param  maxDamage
     * 		   The maximum damage of all weapon to check.
     * @return True if and only if the given maximum damage is greater than or equal 
     * 	       to minimum damage of all weapons.
     *       | result == (maxDamage >= Weapon.getMinDamage())
     */
	public static boolean isValidMaxDamage(int maxDamage) {
		return (maxDamage >= Weapon.getMinDamage());
	}

	/**
     * Return the  maximum damage afflicted by all weapon.
     */
	public static int getMaxDamage() {
		return Weapon.Max_Damage;
	}
	
	/**
     * Return the  minimum damage afflicted by all weapon.
     */
	public static int getMinDamage() {
		return Weapon.MIN_DAMAGE;
	}

	/**
     * Return the damage afflicted by this weapon.
     */
    public int getDamage() {
    	return this.damage;
    }
	
	//***********************************************************Value
	
	/**
     * Check whether the given value is a valid value for any weapon.
     *  
     * @param  value
     * 		   The value of weapon to check.
     * @return True if and only if the given identification is a positive number 
     *       | result == (value >= Monster.MIN_VALUE)
     */
	public static boolean isValidValue (int value) {
		return (value >= Weapon.MIN_VALUE);
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
	
	//**********************************************************************Identification
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
	public static boolean isValidIdentification(long identification) {
		return (identification % 2 == 1) && (identification >= 1);
	}
	
	/**
     * Return the identification of this weapon.
     */
    public long getIdentification() {
    	return this.identification;
    }

}

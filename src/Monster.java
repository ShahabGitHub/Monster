import java.util.Random;

import be.kuleuven.cs.som.annotate.*;

/**
 * A class for dealing with Monsters, Displaying the different
 * properties of Monster. Properties includes Name and integer
 * damage, protection, hitpoints, and strength.
 * 
 * @invar   The name of each monster must be a legal
 *          name for a monster.
 *        | isValidName(getName())
 * @invar   The hitpoints of each monster must be a legal
 *          hitpoints for a monster.
 *        | isValidHitpoints(getHitpoints())
 * @invar  The protection of each monster must be a valid protection for a
 *         monster.
 *         | isValidProtection(getProtection())
 * 
 * @version  2.0
 * @author   Shahab Ud Din at Git
 */
public class Monster {

	/**
	 * Constant reflecting the lowest possible value for the protection of all monsters
	 */
	private final int MIN_PROTECTION = 1;
	/**
	 * Constant reflecting the highest possible value for the protection of all monsters
	 */	
	private final int MAX_PROTECTION = 40;
	/**
	 * Constant reflecting the lowest possible value for the damage of all monsters
	 */
	private static final int MIN_DAMAGE = 1;
	/**
	 * Constant reflecting the average value for the strength of all monsters
	 */
	private static final int AVG_STRENGTH = 10;
	/**
	 * Variable reflecting the highest possible value for the damage of all monsters
	 */	
	private static int MaxDamage = 20;
	/**
     * Variable registering the damage of monster.
     * it reflect the damage a monster can afflict on opponent during fight.
    */
	private int damage;
	/**
     * Variable registering the protection factor of the monster.
    */
	private final int protection;
	/**
     * Variable registering the strength of the monster.
    */
	private int strength;
	/**
     * Variable registering the maximum hitpoints of the monster.
    */
	private final int MAX_HITPOINTS;
	/**
     * Variable registering the hitpoints of this monster.
    */
	private int hitpoints;
	/**
     * Variable registering the name of this monster.
    */
	private final String name;
	
	 /**
     * Initialize this new monster with given protection, strength
     * hitpoints, name and damage.
     * 
     * @param  name
     * 		   The name for this new monster.
     * @param  damage
     * 		   The damage for this new monster.
     * @param  protection
     * 		   The protection for this new monster.
     * @param  hitpoints
     * 		   The hitpoints for this new monster.
     * @param  strength
     *         The strength of this new monster
     * 		
     * @pre	   The given protection must be a valid protection for a monster.
     *       | isValidProtection(protection)
     *       
     * @post   The name of this new monster is equal to
	 *		   the given name.
	 *       | new.getName() == name      
	 * @post   If the given damage is in the range established by the minimum
	 *         and maximum damage for the monster, the damage of this monster is 
	 *          equal to the given damage.
	 *        | if ( (damage >= getMinDamage()) && (damage <= getMaxDamage()) )
	 *        |   then new.getDamage() == damage
	 * @post    If the given damage is greater then the maximum damage for monster,
	 *          the damage of this monster is equal to the maximum damage of monster.
	 *        | if (damage > getMaxDamage())
	 *        |   then new.getDamage() == getMaxDamage()
	 * @post    If the given damage is less the minimum damage for monster,
	 *          the damage of this monster is equal to minimum damage of monster.
	 *        | if (damage < getMinDamage())
	 *        |     then new.getDamage() == getMinDamage()
     * @post   The protection of this new monster is equal to the given protection.
     *       | new.getProtection() == protection
     * @post   The hitpoints of this new monster is equal to the given hitpoints.
     *       | new.getHitpoints() == hitpoints
     * @post   The strength of this new monster is equal to the given strength.
     *       | new.getStrength() == strength
     * @throws IllegalNameException
	 * 		   The given name is not a valid name for
	 * 		   a monster.
	 *       | ! isValidName(name)
	 * @throws IllegalHitpointsException
	 * 		   The given hitpoints is not a valid hitpoints for
	 * 		   a monster.
	 *       | ! isValidHitpoints(hitpoints)
     */
	@Raw
	public Monster (String name, int damage, int protection, int strength, int hitpoints) throws IllegalHitpointsException, IllegalNameException{
		if (!Monster.isValidName(name))
    		throw new IllegalNameException(name);
        this.name = name;
		this.setDamage(damage);
		assert isValidProtection(protection);
        	this.protection = protection;
        if (!isValidHitpoints(hitpoints, hitpoints))
    		throw new IllegalHitpointsException(hitpoints);
        this.MAX_HITPOINTS = hitpoints;
        this.setHitpoints(hitpoints);		
        this.setStrength(strength);
	}
	
	// validate regular expression
	/**
     * Check whether the given name is a valid name for any monster.
     *  
     * @param  name
     * 		   The name of monster to check.
     * @return True if and only if the given name is of at least of length 2 character
     * 	       and first character is capital alphabet (A-Z) and can have
     *         only character, digit, space and ' as character of name.
     *       | Let REG_EX = "[A-Z]+[A-Za-z1-9' ]+"
     *       | result == name.matches(REG_EX)
     * @Note   We can not call this function from constructor as the maximum value of the hitpoints
     *         for this monster is set after the execution of constructor. to check it from constructor
     *         another method with two argument is available.   
     */
	public static boolean isValidName (String name) {
		String REG_EX = "[A-Z]+[A-Za-z1-9' ]+";
		return name.matches(REG_EX);
	}
	
	 
	/**
	 * Set the hitpoints of this monster to the given hitpoints value.
	 *
	 * @param	hitpoints
	 *			The new hitpoints for this monster.
	 * @post    hitpoints of this monster is equal to the given hitpoints.
	 *          |   this.getHitpoints() == hitpoints
	 * @throws IllegalHitpointsExceptionthis.setHitpoints(hitpoints);
	 * 		   The given hitpoints is not a valid hitpoints for this Monster.
	 *       | ! isValidHitpoints(hitpoints)
	 * */
	public void setHitpoints(int hitpoints)throws IllegalHitpointsException{
		if (!isValidHitpoints(hitpoints))
			throw new IllegalHitpointsException(hitpoints);
		this.hitpoints = hitpoints;
		
	}
	 
	/**
     * Return the hitpoints of this monster.
     *   hitpoints denotes the life line monster can have.
     *        */
    @Basic @Raw
    public int getHitpoints () {
    	return this.hitpoints;
    }
    /**
     * Return the maximum hitpoints of this monster.
     *  maximum hitpoints denotes the maximum life line monster can have.
     *        */
    @Basic @Raw @Immutable
    public int getMaxHitpoints () {
    	return this.MAX_HITPOINTS;
    }
    
    /**
     * Check whether the given hitpoints is a valid hitpoint for any monster.
     *  
     * @param  hitpoints
     * 		   The hitpoints of monster to check.
     * @return True if and only if the given hitpoints is between zero
     * 	       and maximum hitpoints for this monster.
     *       | result == (hitpoints >= 0) && (hitpoints <= this.getMaxHitpoints())
     * @Note   We can not call this function from constructor as the maximum value of the hitpoints
     *         for this monster is set after the execution of constructor. to check it from constructor
     *         another method with two argument is available.   
     */
	public boolean isValidHitpoints(int hitpoints) {
		return ((hitpoints >= 0) && (hitpoints <= this.getMaxHitpoints()));
	}
	
	/**
     * Check whether the given hitpoints is a valid hitpoint for any monster.
     *  
     * @param  hitpoints
     * 		   The hitpoints of monster to check.
     * @param  maxHitpoints
     * 		   The maximum hitpoints of  this monster.

     * @return True if and only if the given hitpoints is between zero
     * 	       and maximum hitpoints for this monster.
     *       | result == (hitpoints >= 0) && (hitpoints <= maxHitpoints)
     * @Note   We can call this function from constructor as the maximum value of the hitpoints
     *         for this monster is given as second argument to this this method. 
     *         To check it from other methods another method with one argument is available.   
     */
	public boolean isValidHitpoints(int hitpoints, int maxHitpoints) {
		return ((hitpoints >= 0) && (hitpoints <= maxHitpoints));
	}
	
	/**
	 * decrease the shitpoints of this monster by the given value.
	 *
	 * @param	decreaseValue 
	 *			The decrease in hitpoints for this monster.
	 * @post    the new hitpoints of the monster are decreased by given value.
	 *          |   new.setHitpoints(this.getHitpoints() - decreaseValue)
	 * 
	 * */
	public void decreaseHitpoints(int decreaseValue){
		try {
			this.setHitpoints(this.getHitpoints() - decreaseValue);
		} catch (IllegalHitpointsException e) {
			this.decreaseHitpoints(this.getHitpoints());
		}
	}
	
	/**
	 * gain the hitpoints of this monster by the given value.
	 *
	 * @param	gainValue 
	 *			The gain in hitpoints for this monster.
	 * @post    the new hitpoints of the monster are gain by given value.
	 *          |   new.setHitpoints(this.getHitpoints() + gainValue)
	 * */
	public void gainHitpoints(int gainValue){
		try {
			this.setHitpoints(this.getHitpoints() + gainValue);
		} catch (IllegalHitpointsException e) {
			try {
				this.setHitpoints(this.getMaxHitpoints());
			} catch (IllegalHitpointsException e1) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	/**
	 * calculate the value of damage applied by an attacker monster
	 *
	 * @return	The damage applied by this monster.
	 * 			 The value of damage applied by this monster is calculated by adding 
	 *           the damage value of this monster and 
	 *           integer division by 3 of the difference of the strength of this monster and 5
	 *          |   this.getDamage()+ (this.getStrength()-5)/3.
	 * */
	public int calculateDamage () {
		return this.getDamage()+ (this.getStrength()-5)/3;
	}
	
	/**
	 * apply the effect of hit on the opponent monster by decreasing its hitpoints.
	 * @param opponentMonster
	 * 			opponent monster who will be effected by the hit
	 * @throws NullPointerException
	 * 		   The given opponent monster is not a null monster.
	 *       |  (opponentMonster == null)
	 * @effect	the hitpoints of the opponent monster are decreased by the calculated damage
	 *          applied by attacker monster 
	 *          |  opponentMonster.decreaseHitpoints(this.calculateDamage()).
	 * */
	public void hit(Monster opponentMonster) throws NullPointerException {
		opponentMonster.decreaseHitpoints(this.calculateDamage());
	}
	
	
	/**
	 * apply the effect of attack on the opponent monster .
	 * @param opponentMonster
	 * 			opponent monster who will be effected by the hit
	 * @throws NullPointerException
	 * 		   The given opponent monster is not a null monster.
	 *       |  (opponentMonster == null)
	 * @effect	if the attack intensity  is greater than opponent protection hit will be 
	 *          Successful and will be applied to opponent
	 *          |  if (attackIntensity >= opponentMonster.getProtection())
			    |    than   this.hit(opponentMonster)
	 * @note    attack intensity is generated as random number between 1 and 30.
	 *          if it is greater than the hitpoints of monster it is replaced
	 *          by hitpoints of attacker monster. 
	 *          |  if (attackIntensity > this.getHitpoints())
			    |    than   attackIntensity = this.getHitpoints()
	 * */
	public void attack(Monster opponentMonster) throws NullPointerException {
		int attackIntensity = generateNumberBetween(0,30);
		if (attackIntensity > this.getHitpoints())
			attackIntensity = this.getHitpoints();
		if (attackIntensity >= opponentMonster.getProtection())
			this.hit(opponentMonster);
	}
	/**
	 * Generate a random number between a  range by two given numbers.
	 * @param min
	 * 			lower bound of the range for random number.
	 * @param max
	 * 			Upper bound of the range for random number.
	 * @return
	 * 			A random number between lower and upper bound.
	 */
	public static int generateNumberBetween(int min, int max){
		Random rand = new Random();
		int randomNumber = rand.nextInt(max) + min;
		return randomNumber;
	}
	
	/**
	 * Set the strength of this monster to the given strength value.
	 *
	 * @param	strength
	 *			The new strength for this monster.
	 * @post    If the given strength is in the range established by the minimum
	 *          and maximum value for integer type, the strength of this monster is 
	 *          equal to the given strength.
	 *        | if ( (strength >= Integer.MIN_VALUE) && (damage <= Integer.MAX_VALUE) )
	 *        |   then new.getStrength() = strength
	 * @post    If the given strength greater then the maximum value for integer type,
	 *          the strength of this monster is equal to the maximum value for integer type.
	 *        | if (strength > Integer.MAX_VALUE)
	 *        |   then new.getStrength() = Integer.MAX_VALUE
	 * @post   If the given strength is less the minimum value for integer type,
	 *         the strength of this monster is equal to minimum value for integer type.
	 *        | if (strength < Integer.MIN_VALUE)
	 *        |     then new.getStrength() = Integer.MIN_VALUE
	 * */
	public void setStrength(int strength) {
		if ( (strength >= Integer.MIN_VALUE) && (damage <= Integer.MAX_VALUE) )
			this.strength = strength;
		else if (strength >= Integer.MAX_VALUE)
			this.strength = Integer.MAX_VALUE;
		else if (strength <= Integer.MIN_VALUE)
			this.strength = Integer.MIN_VALUE;
	}
	
	/**
     * Return the strength of this monster.
     *   strength denotes the damage monster can afflict.
     *        */
    @Basic @Raw @Immutable
    public int getStrength () {
    	return this.strength;
    }
    /**
     * Check whether this monster is stronger than the average strength of monster.
     *  
     * 
     * @return True if and only if the strength of this monster is greater than
     *         average strength of monster.
     *       | result == ((pthis.strength > AVG_STRENGTH)
     */
    public boolean isStrongerThanAverage() {
    	return (this.strength > AVG_STRENGTH);
    }
	/**
     * Check whether the given protection is a valid protection for any monster.
     *  
     * @param  protection
     * 		   The protection of monster to check.
     * @return True if and only if the given protection is prime number between minimum protection
     * 	       and maximum protection.
     *       | result == ((protection >= MIN_PROTECTION) && (protection <= MAX_PROTECTION) && (isPrime(protection)))
     */
	public boolean isValidProtection(int protection) {
		if (protection == 1) 
			return true;
		return ((protection >= this.MIN_PROTECTION) && (protection <= this.MAX_PROTECTION) && (Monster.isPrime(protection)));
	}
	
	/**
     * Check whether the given number is a prime.
     *  
     * @param  number
     * 		   The number to check.
     * @return True if and only if the given number is prime number.
     *       | result ==
	 *       |   if (number == 2)
	 *       |     then true
	 *       |   else if(number % 2)
	 *       |       then false
	 *       |   else if(number % ????)
	 *       |       then false
	 *       |   else true
     */
	public static boolean isPrime(int number){
		if (number == 1)
			return false;
		if (number == 2)
			return true;
		if (number % 2 == 0)
			return false;
		for(int i = 3; i * i <= number; i += 2) {
	        if(number % i == 0)
	            return false;
	    }
		return true;
	}
	/**
     * Return the protection of this monster.
     *   protection factor denotes how monster can defend itself.
     *        
     *        */
    @Basic @Raw @Immutable
    public int getProtection(){
    	return this.protection;
    }

	/**
	 * Set the damage of this monster to the given damage value.
	 *
	 * @param	damage
	 *			The new damage for this monster.
	 * @post    If the given damage is in the range established by the minimum
	 *          and maximum damage for the monster, the damage of this monster is 
	 *          equal to the given damage.
	 *        | if ( (damage >= getMinDamage()) && (damage <= getMaxDamage()) )
	 *        |   then new.getDamage() == damage
	 * @post    If the given damage greater then the maximum damage for monster,
	 *          the damage of this monster is equal to the maximum damage of monster.
	 *        | if (damage > getMaxDamage())
	 *        |   then new.getDamage() == getMaxDamage()
	 * @post   If the given damage is less the minimum damage for monster,
	 *         the damage of this monster is equal to minimum damage of monster.
	 *        | if (damage < getMinDamage())
	 *        |     then new.getDamage() == getMinDamage()
	 */
	public void setDamage(int damage) {
		if ( (damage >= getMinDamage()) && (damage <= getMaxDamage()) )
			this.damage = damage;
		else if (damage > getMaxDamage())
			this.damage = getMaxDamage();
		else if(damage < getMinDamage())
			this.damage = getMinDamage();	
	}
	
	/**
	 * Return the highest possible value for the damage of all monsters
	 * @return The highest possible value for the damage of all monster is not 
	 			below the lowest possible value of damage of all monsters.
	 *		 | result >= getMinDamage()
	 */
	@Basic
	public static int getMaxDamage() {
		return Monster.MaxDamage;
	}
	
	/**
	 * Set the maximum damage for all monster to the given maximum damage value.
	 *
	 * @param	maxdamage
	 *			The new maximum damage for all monsters.
	 * @post    If the given maximum damage value  is greater than or equal to the minimum damage value
	 *          of all the monster than new maximum damage equal to the given maximum damage.
	 *        | if  (maxdamage >= Monster.getMinDamage())
	 *        |   then Monster.getMaxDamage() = maxdamage
	 * @post   If the given maximum damage is less the minimum damage for all monster,
	 *         the maximum damage of all monsters is equal to minimum damage of all monsters.
	 *        | if (damage < Monster.getMinDamage())
	 *        |     then Monster.getMaxDamage() = Monster.getMinDamage()
	 * 
	 */
	public static void setMaxDamage(int maxdamage) {
		if(maxdamage >= Monster.getMinDamage())
			Monster.MaxDamage = maxdamage;
		else
			Monster.MaxDamage = Monster.getMinDamage();
	}
	
	/**
	 * Return the lowest possible value for the damage of all monsters
	 * @return The lowest possible value for the damage of all monster is 1.
	 *		 | result == 1
	 * @note   xxx
	 */
	@Basic
	public static int getMinDamage() {
		return MIN_DAMAGE ;
	}
	
	
	/**
	 * Return the damage of this monster.
	 */
	@Basic
	public int getDamage() {
		return this.damage;
	}
	
	/**
	 * Return the maximum protection of this monster.
	 */
	@Basic
	public int getMaxProtection() {
		return this.MAX_PROTECTION;
	}
	
	
	/**
	 * Return the minimum protection of this monster.
	 */
	@Basic
	public int getMinProtection() {
		return this.MIN_PROTECTION;
	}
	/**
     * Check whether the monster is alive.
     *  
     * @return True if and only if the hitpoints of monster are greater than zero.
     *       | result ==
	 *       |   if (this.getHitpoints() > 0)
	 *       |     then true
	 *       |   else 
	 *       |       then false
	 */
	public boolean isAlive() {
		return (this.getHitpoints() > 0);
	}

	/**
	 * Return the name of this monster.
	 */
	@Basic
	public String getName() {
		return this.name;
	}
 

}

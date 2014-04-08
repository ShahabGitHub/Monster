import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class WeaponTest {

	private Weapon weightWeapon_5;
	private Weapon weaponValue;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		weightWeapon_5 = new Weapon(2, 5,5);
		weaponValue = new Weapon(10, 10,5);
	}

	@After
	public void tearDown() throws Exception {
	}

	//******************* constructor
	@Test(expected = IllegalWeightException.class)
	public final void extendedConstructor_illeagalWeightCase() throws Exception {
		new Weapon(5,20,-1);
	}
	
	//******************* validIdentification
	@Test
	public final void isValidIdentification_trueCase() {
		assertTrue(Weapon.isValidIdentification(1));
	}
	
	@Test
	public final void isValidIdentification_falsecaseEven() {
		assertFalse(Weapon.isValidIdentification(4));
	}
	
	@Test
	public final void isValidIdentification_falseCaseNegative() {
		assertFalse(Weapon.isValidIdentification(-3));
	}
	
	@Test
	public final void generateValidIdentification_onlyCase() {
		//assertEquals(3,Weapon.generateUniqueValidIdentification());
		//assertEquals(5,Weapon.generateUniqueValidIdentification());
		assertEquals(1,Weapon.generateUniqueValidIdentification()%2);
		assertEquals(1,Weapon.generateUniqueValidIdentification()%2);
	}
	
	//*******************Value
	
	@Test
	public final void isValidValue_TrueCase() {
		assertTrue(Weapon.isValidValue(2));
	}
	
	@Test
	public final void isValidValue_FalseCase() {
		assertFalse(Weapon.isValidValue(-1));
	}
	
	@Test
	public final void increaseValue_TrueCase() {
		weaponValue.increaseValue(5);
		assertEquals(15,weaponValue.getValue());
	}
	
	@Test
	public final void decreasedValue_TrueCase() {
		weaponValue.decreaseValue(5);
		assertEquals(5,weaponValue.getValue());
	}
	 //**************************** damage
	@Test
	public final void isValidDamage_TrueCase() {
		assertTrue (Weapon.isValidDamage(Weapon.getMaxDamage()-1));
	}
	
	@Test
	public final void isValidDamage_FalseCase_LessThanMin() {
		assertFalse (Weapon.isValidDamage(-5));
	}
	
	@Test
	public final void isValidDamage_FalseCase_GreaterThanMax() {
		assertFalse (Weapon.isValidDamage(Weapon.getMaxDamage()+1));
	}

	 //**************************** weight
	@Test
	public final void isvalidWeight_trueCase() {
		assertTrue(Weapon.isValidWeight(5));
	}
	
	@Test
	public final void isvalidWeight_falseCase() {
		assertFalse(Weapon.isValidWeight(0));
	}
	
	
}

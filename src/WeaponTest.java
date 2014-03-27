import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class WeaponTest {

	private Weapon weaponIdentification;
	private Weapon weaponValue;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		weaponIdentification = new Weapon(2);
		weaponValue = new Weapon(10);
	}

	@After
	public void tearDown() throws Exception {
	}

	
	//******************* validIdentification
	@Test
	public final void isValidIdentification_trueCase() {
		assertTrue(weaponIdentification.isValidIdentification(1));
	}
	
	@Test
	public final void isValidIdentification_falsecaseEven() {
		assertFalse(weaponIdentification.isValidIdentification(4));
	}
	
	@Test
	public final void isValidIdentification_falseCaseNegative() {
		assertFalse(weaponIdentification.isValidIdentification(-3));
	}
	
	@Test
	public final void generateValidIdentification_onlyCase() {
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
	
	


}

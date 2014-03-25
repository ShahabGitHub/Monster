import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class MonsterTest {

	private Monster protectionMonster;
	private Monster damageMonster;
	private Monster strengthMonster;
	private Monster hitpointsMonster_10;
	private Monster hitpointsMonsterMax_10;
	private Monster attackMonster;
	private Monster hitMonster;
	private Monster aliveMonster;
	private Monster calculateDamage;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		protectionMonster = new Monster("Protection Monster",10,100,100,100);
		damageMonster = new Monster ("Damage Monster",10,30, 20,100);
		strengthMonster = new Monster("Strength Monster",10,30,20,100);
		hitpointsMonster_10 = new Monster("HitpointDecrease",10,100,100,10);
		hitpointsMonsterMax_10 = new  Monster("HitpointGain",10,100,100,10);
		attackMonster =new Monster ("AttackMonster",10,100,100,7);
		hitMonster =new Monster ("AttackMonster",10,100,100,7);
		aliveMonster =new Monster ("AliveMonster",10,100,100,7);
		calculateDamage = new Monster ("CalculateDamage",10,100,100,7);
	}

	@After
	public void tearDown() throws Exception {
	}

	//calculate damage
	@Test
	public final void calculateDamage_damage10_strength10() {
		calculateDamage.setDamage(10);
		calculateDamage.setStrength(10);
		assertEquals(11, calculateDamage.calculateDamage());
	}
	
	@Test
	public final void calculateDamage_damage1_strength10() {
		calculateDamage.setDamage(1);
		calculateDamage.setStrength(10);
		assertEquals(2, calculateDamage.calculateDamage());
	}
	
	@Test
	public final void calculateDamage_damage20_strength10() {
		calculateDamage.setDamage(20);
		calculateDamage.setStrength(10);
		assertEquals(21, calculateDamage.calculateDamage());
	}
	
	@Test
	public final void calculateDamage_damage10_strengthmax() {
		calculateDamage.setDamage(10);
		calculateDamage.setStrength(2147483647);
		assertEquals(715827890, calculateDamage.calculateDamage());
	}
	
	@Test
	public final void calculateDamage_damage1_strengthmax() {
		calculateDamage.setDamage(1);
		calculateDamage.setStrength(2147483647);
		assertEquals(715827881, calculateDamage.calculateDamage());
	}
	
	@Test
	public final void calculateDamage_damage20_strengthmax() {
		calculateDamage.setDamage(20);
		calculateDamage.setStrength(2147483647);
		assertEquals(715827900, calculateDamage.calculateDamage());
	}
	

	// Constructor
	@Test
	public final void extendedConstructor_allLeagalCase() throws Exception {
		 new Monster("Protection Monster",10,100,100,100);
	}
	
	@Test(expected = IllegalNameException.class)
	public final void extendedConstructor_illeagalNameCase() throws Exception {
		new Monster("strength Monster",10,30,20,100);
	}
	
	@Test(expected = IllegalHitpointsException.class)
	public final void extendedConstructor_illeagalHitpointCase() throws Exception {
		new Monster("Strength Monster",10,30,20, -1);
	}
	
	//isValidName
	@Test
	public final void isValidName_TrueCase_length() {
		assertTrue(protectionMonster.isValidName("Ab"));
	}
	
	@Test
	public final void isValidName_TrueCase_StartCapital() {
		assertTrue(protectionMonster.isValidName("Aname"));
	}
	
	@Test
	public final void isValidName_TrueCase_HaveDigit() {
		assertTrue(protectionMonster.isValidName("Aname1"));
	}
	
	@Test
	public final void isValidName_TrueCase_HaveSpace() {
		assertTrue(protectionMonster.isValidName("Aname 1"));
	}
	
	@Test
	public final void isValidName_TrueCase_HaveApostrophes() {
		assertTrue(protectionMonster.isValidName("Aname '1"));
	}
	
	@Test
	public final void isValidName_FalseCase_length() {
		assertFalse(protectionMonster.isValidName("A"));
	}
	
	@Test
	public final void isValidName_FalseCase_StartCapital() {
		assertFalse(protectionMonster.isValidName("aname"));
	}
	
	@Test
	public final void isValidName_FalseCase_UnallowedCharacter() {
		assertFalse(protectionMonster.isValidName("Aname+"));
	}
	
	
	//isValidHitpoints
	@Test
	public final void isvalidHitpointBtweenZeroAndMax_trueCase() {
		assertTrue(hitpointsMonsterMax_10.isValidHitpoints(7));
	}
	
	@Test
	public final void isvalidHitpointBtweenZeroAndMax_FalseCase_GreaterThanMax() {
		assertFalse(hitpointsMonsterMax_10.isValidHitpoints(11));
	}
	
	@Test
	public final void isvalidHitpointBtweenZeroAndMax_FalseCase_LessThanZero() {
		assertFalse(hitpointsMonsterMax_10.isValidHitpoints(-1));
	}
	
	//decreaseHitpoints
	@Test
	public final void decreaseHitpoints_resultGreaterThanZero() {
		hitpointsMonster_10.decreaseHitpoints(5);
		assertEquals(5,hitpointsMonster_10.getHitpoints());
	}
	
	@Test
	public final void decreaseHitpoints_resultEquqltoZero() {
		hitpointsMonster_10.decreaseHitpoints(10);
		assertEquals(0,hitpointsMonster_10.getHitpoints());
	}
	
	@Test
	public final void decreaseHitpoints_resultLessThanZero() {
		hitpointsMonster_10.decreaseHitpoints(11);
		assertEquals(0,hitpointsMonster_10.getHitpoints());
	}
	
	//gainHitpoints
	@Test
	public final void gainHitpoints_resultLessThanMaxHitpoint() throws Exception {
		hitpointsMonsterMax_10.setHitpoints(5);
		hitpointsMonsterMax_10.gainHitpoints(3);;
		assertEquals(8,hitpointsMonsterMax_10.getHitpoints());
	}
	
	@Test
	public final void gainHitpoints_resultEqualToMaxHitpoint() throws Exception {
		hitpointsMonsterMax_10.setHitpoints(5);
		hitpointsMonsterMax_10.gainHitpoints(5);;
		assertEquals(10,hitpointsMonsterMax_10.getHitpoints());
	}
	
	@Test
	public final void gainHitpoints_resultGreaterThanMaxHitpoint() {
		try {
			hitpointsMonsterMax_10.setHitpoints(5);
		} catch (IllegalHitpointsException e) {
			
		}
		hitpointsMonsterMax_10.gainHitpoints(6);;
		assertEquals(10,hitpointsMonsterMax_10.getHitpoints());
	}
	
	//
	// is validProtection
		@Test
		public final void isValidProtection_TrueCase() {
			assertTrue(protectionMonster.isValidProtection(31));
		}
		@Test
		public final void isValidProtection_FalseCase_lessThanMinProtection() {
			assertFalse(protectionMonster.isValidProtection(0));
		}
		@Test
		public final void isValidProtection_FalseCase_greaterThanMaxProtection() {
			assertFalse(protectionMonster.isValidProtection(41));
		}
		@Test
		public final void isValidProtection_FalseCase_prime() {
			assertFalse(protectionMonster.isValidProtection(32));
		}
		
		// special case of 1
		@Test
		public final void isValidProtection_TrueCase_one() {
			assertTrue(protectionMonster.isValidProtection(1));
		}
		
		// isPrime
		@Test
		public final void isPrime_TrueCase() {
			assertTrue(protectionMonster.isPrime(31));
		}
		@Test
		public final void isPrime_FalseCase() {
			assertFalse(protectionMonster.isPrime(32));
		}
		@Test
		public final void isPrime_OneCase() {
			assertFalse(protectionMonster.isPrime(1));
		}
		
		// setDamge
		@Test
		public final void setDamage_inRange_true() {
			damageMonster.setDamage(19);
			assertEquals(19, damageMonster.getDamage());
		}
		@Test
		public final void setDamage_GreaterThan_MaxDamage() {
			damageMonster.setDamage(21);
			assertEquals(20, damageMonster.getDamage());
		}
		@Test
		public final void setDamage_LessThan_MinDamage() {
			damageMonster.setDamage(0);
			assertEquals(1, damageMonster.getDamage());
		}
		//setStrength
		@Test
		public final void setStrength_inRange_true() {
			strengthMonster.setStrength(19);
			assertEquals(19, strengthMonster.getStrength());
		}
		//@Test
		public final void setStrength_GreaterThan_MaxStrength() {
			strengthMonster.setStrength(2147483647 +1);
			assertEquals(2147483647, strengthMonster.getStrength());
		}
		//@Test
		public final void setStrength_LessThan_MinStrength() {
			strengthMonster.setStrength(-2147483648-1);
			assertEquals(-2147483648, strengthMonster.getStrength());
		}
		
		
		//attack
		@Test(expected = NullPointerException.class)
		public final void attack_Null_Opponent() throws Exception {
			attackMonster.attack(null);
		}
		
		//hit
		@Test(expected = NullPointerException.class)
		public final void hit_Null_Opponent() throws Exception {
			hitMonster.hit(null);
		}
		
		// alive
		@Test
		public final void isalive_TrueCase() throws Exception {
			aliveMonster.setHitpoints(5);
			assertTrue(aliveMonster.isAlive());
		}
		
		@Test
		public final void isalive_FalseCase() throws Exception {
			aliveMonster.setHitpoints(0);
			assertFalse(aliveMonster.isAlive());
		}
}

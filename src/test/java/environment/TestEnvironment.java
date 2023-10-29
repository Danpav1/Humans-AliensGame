package environment;

import static org.junit.Assert.*;

import exceptions.EnvironmentException;
import org.junit.Test;

import lifeform.LifeForm;
import lifeform.MockLifeForm;

import weapon.Weapon;
import weapon.MockWeapon;

/**
 * The test cases for the Environment class
 */
public class TestEnvironment {
  final double DELTA = 0.01;

  /*
   * Lab 5 tests begin -----------------------------------------------------------------------------
   */

  /**
   * Tests that the Environment is a singleton
   */
  @Test
  public void testInitializationSingleton() {
    Environment environment1 = Environment.getEnvironment(2, 3);
    Environment environment2 = Environment.getEnvironment(1, 1);

    assertEquals(environment2, environment1);

    Environment.removeEnvironment();
  }

  /**
   * Tests that you can get the number of rows and columns
   */
  @Test
  public void testInitializationSize() {
    Environment environment = Environment.getEnvironment(4, 5);

    assertEquals(4, environment.getNumRows());
    assertEquals(5, environment.getNumCols());

    Environment.removeEnvironment();
  }

  /**
   * Tests that weapons can be added to the Environment properly
   */
  @Test
  public void testCanAddWeaponToCell() {
    Environment environment = Environment.getEnvironment(3, 5);
    Weapon weapon = new MockWeapon();
    Weapon weapon2 = new MockWeapon();
    Weapon weapon3 = new MockWeapon();

    assertFalse(environment.addWeapon(weapon, -1, 5));

    environment.addWeapon(weapon, 2, 4);

    boolean hasWeapon = false;
    for (Weapon target : environment.getWeapons(2, 4)) {
      if (target == weapon) {
        hasWeapon = true;
      }
    }
    assertTrue(hasWeapon);

    assertFalse(environment.addWeapon(weapon, 2, 4));
    assertTrue(environment.addWeapon(weapon2, 2, 4));
    assertFalse(environment.addWeapon(weapon3, 2, 4));

    Environment.removeEnvironment();
  }

  /**
   * Tests that Weapons can be removed from the Environment
   */
  @Test
  public void testCanRemoveWeaponFromCell() {
    Environment environment = Environment.getEnvironment(5, 6);
    Weapon weapon1 = new MockWeapon();
    Weapon weapon2 = new MockWeapon();

    // tests that removeWeapon() fails gracefully when out of bounds
    environment.removeWeapon(weapon1, -1, 6);

    // tests that removeWeapon() fails gracefully when Weapon not in Cell
    environment.removeWeapon(weapon1, 3, 3);

    environment.addWeapon(weapon1, 3, 3);
    environment.addWeapon(weapon2, 3, 3);

    assertEquals(2, countWeapons(environment.getWeapons(3, 3)));

    environment.removeWeapon(weapon1, 3, 3);

    assertEquals(1, countWeapons(environment.getWeapons(3, 3)));

    environment.removeWeapon(weapon2, 3, 3);

    assertEquals(0, countWeapons(environment.getWeapons(3, 3)));

    Environment.removeEnvironment();
  }

  /**
   * Tests that getDistance works within the same row
   */
  @Test
  public void testGetDistanceInRow() throws EnvironmentException {
    Environment environment = Environment.getEnvironment(1, 6);
    LifeForm thing1 = new MockLifeForm("Thing 1", 1);
    LifeForm thing2 = new MockLifeForm("Thing 2", 1);

    environment.addLifeForm(thing1, 0, 0);
    environment.addLifeForm(thing2, 0, 5);

    assertEquals(25.0, environment.getDistance(thing1, thing2), DELTA);

    Environment.removeEnvironment();
  }

  /**
   * Tests that getDistance() works within the same column
   */
  @Test
  public void testGetDistanceInColumn() throws EnvironmentException {
    Environment environment = Environment.getEnvironment(8, 1);
    LifeForm thing1 = new MockLifeForm("Thing 1", 1);
    LifeForm thing2 = new MockLifeForm("Thing 2", 1);

    environment.addLifeForm(thing1, 0, 0);
    environment.addLifeForm(thing2, 7, 0);

    assertEquals(35.0, environment.getDistance(thing1, thing2), DELTA);

    Environment.removeEnvironment();
  }

  /**
   * Tests that getDistance() works regardless of location in the Environment
   */
  @Test
  public void testGetDistance() throws EnvironmentException {
    Environment environment = Environment.getEnvironment(6, 13);
    LifeForm thing1 = new MockLifeForm("Thing 1", 1);
    LifeForm thing2 = new MockLifeForm("Thing 2", 1);

    environment.addLifeForm(thing1, 2, 3);
    environment.addLifeForm(thing2, 5, 7);

    assertEquals(25.0, environment.getDistance(thing1, thing2), DELTA);

    environment.removeLifeForm(2, 3);
    environment.removeLifeForm(5, 7);

    environment.addLifeForm(thing1, 0, 0);
    environment.addLifeForm(thing2, 5, 12);

    assertEquals(65.0, environment.getDistance(thing1, thing2), DELTA);

    Environment.removeEnvironment();
  }

  /**
   * Tests that, if passed an invalid coordinate pair, getDistance will throw an exception
   */
  @Test
  public void testGetDistanceThrowsException() throws EnvironmentException {
    Environment environment = Environment.getEnvironment(1, 6);
    LifeForm thing1 = new MockLifeForm("Thing 1", 1);
    LifeForm thing2 = new MockLifeForm("Thing 2", 1);

    environment.addLifeForm(thing1, 0, 0);

    boolean exceptionCaught = false;

    try {
      environment.getDistance(thing1, thing2);
    } catch (EnvironmentException e) {
      exceptionCaught = true;
    }

    assertTrue(exceptionCaught);

    Environment.removeEnvironment();
  }

  /**
   * Helper function that counts the number of Weapons in an Environment's getWeapons() return
   *
   * @param weapons the array of Weapons returned by getWeapons()
   *
   * @return the number of weapons in the array
   */
  int countWeapons(Weapon[] weapons) {
    int numWeapons = 0;
    for (Weapon weapon : weapons) {
      if (weapon != null) {
        numWeapons++;
      }
    }
    return numWeapons;
  }

  /*
   * Lab 5 tests end; Lab 4 tests begin ------------------------------------------------------------
   */

  /**
   * Tests that the environment can be initialized and that its
   * contents exist
   */
  @Test
  public void testInitialization() {
    Environment environment = Environment.getEnvironment(1, 1);
    assertNull(environment.getLifeForm(0, 0));

    Environment.removeEnvironment();
  }

  /**
   * Tests that LifeForms can be added and removed from the
   * Environment
   */
  @Test
  public void testAddAndGetLifeForm() {
    Environment environment = Environment.getEnvironment(2, 3);
    LifeForm charlie = new MockLifeForm("Charlie", 30);

    environment.addLifeForm(charlie, 0, 1);
    assertEquals(charlie, environment.getLifeForm(0, 1));

    Environment.removeEnvironment();
  }

  /**
   * Tests that the Environment will prevent the user from crashing the program
   * by trying to access a cell outside the Environment
   */
  @Test
  public void testInvalidCell() {
    Environment environment = Environment.getEnvironment(4, 3);
    LifeForm steve = new MockLifeForm("Steve", 700);

    boolean success = environment.addLifeForm(steve, 4, 3);
    assertFalse(success);

    assertNotEquals(steve, environment.getLifeForm(4, 3));
    assertNull(environment.getLifeForm(4, 3));

    // to ensure that removeLifeForm does not crash the program if out of bounds
    environment.removeLifeForm(4, 3);

    Environment.removeEnvironment();
  }

  /**
   * Tests that LifeForms can be removed from the Environment
   */
  @Test
  public void testRemoveLifeForm() {
    Environment environment = Environment.getEnvironment(1, 1);
    LifeForm craig =  new MockLifeForm("Craig", 50);

    environment.addLifeForm(craig, 0, 0);
    assertEquals(craig, environment.getLifeForm(0, 0));

    environment.removeLifeForm(0, 0);
    assertNull(environment.getLifeForm(0, 0));

    Environment.removeEnvironment();
  }
}

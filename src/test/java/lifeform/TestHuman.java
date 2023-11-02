package lifeform;

import static org.junit.Assert.*;

import exceptions.RecoveryRateException;
import exceptions.WeaponException;
import org.junit.Test;

/**
 * Tests the functionality provided by the Human class
 */
public class TestHuman {
  /*
   * Lab 6 tests begin
   */

  /**
   * Tests that the human default maxSpeed is 3
   */
  @Test
  public void testMaxSpeed() {
    Human fred = new Human("Fred", 30, 10);
    assertEquals(3, fred.getMaxSpeed());
  }

  /*
   * Lab 6 tests end; Lab 1-5 tests begin -----------------------------------------------------------------------------
   */

  /**
   * Tests that you can initialize a Human
   */
  @Test
  public void testInitialization() {
    Human fred = new Human("Fred", 30, 10);

    assertEquals("Fred", fred.getName());
    assertEquals(30, fred.getCurrentLifePoints());
    assertEquals(10, fred.getArmorPoints());
    assertEquals(5, fred.attackStrength);
  }

  /**
   * Tests that you can get armorPoints
   */
  @Test
  public void testGetArmorPoints() {
    Human greg = new Human("Greg", 30, 50);

    assertEquals(50, greg.getArmorPoints());
  }

  /**
   * Tests that you can set armorPoints
   */
  @Test
  public void testSetArmorPoints() {
    Human miles = new Human("Miles", 20, 5);

    miles.setArmorPoints(20);
    assertEquals(20, miles.getArmorPoints());
  }

  /**
   * Tests that the armorPoints cannot be set lower than 0.
   */
  @Test
  public void testValidArmorPoints() {
    Human jenna = new Human("Jenna", 70, 20);
    Human chris = new Human("Chris", 40, -20);

    assertEquals(0, chris.getArmorPoints());

    jenna.setArmorPoints(-2);
    assertEquals(20, jenna.getArmorPoints());
  }

  /**
   * Tests that Humans can be attacked
   */
  @Test
  public void testCanBeAttacked() throws RecoveryRateException, WeaponException {
    Human heMan = new Human("He-Man", 100, 0);
    Alien thing = new Alien("Thing", 50);

    thing.attack(heMan, 0);

    assertEquals(90, heMan.getCurrentLifePoints());
  }

  /**
   * Tests that a Human absorbs all damage when armorPoints > damage
   */
  @Test
  public void testAbsorbsLesserDamage() {
    Human armorDummy = new Human("Armor Dummy", 20, 10);

    armorDummy.takeHit(7);

    assertEquals(20, armorDummy.getCurrentLifePoints());
  }

  /**
   * Tests that a Human absorbs all damage when armorPoints == damage
   */
  @Test
  public void testAbsorbsEqualDamage() {
    Human armorDummy = new Human("Armor Dummy", 20, 10);

    armorDummy.takeHit(10);

    assertEquals(20, armorDummy.getCurrentLifePoints());
  }

  /**
   * Tests that a Human absorbs an amount of damage equal to armorPoints
   * and takes the rest, when armorPoints < damage
   */
  @Test
  public void testReducesGreaterDamage() {
    Human armorDummy = new Human("Armor Dummy", 20, 10);

    armorDummy.takeHit(15);

    assertEquals(15, armorDummy.getCurrentLifePoints());
  }
}

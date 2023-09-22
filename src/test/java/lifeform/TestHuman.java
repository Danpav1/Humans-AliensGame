package lifeform;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the functionality provided by the Human class
 */
public class TestHuman {
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
    assertEquals(0, jenna.getArmorPoints());
  }
}

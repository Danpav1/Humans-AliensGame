package lifeform;

import static org.junit.Assert.*;

import org.junit.Test;

import recovery.*;

/**
 * Tests the functionality provided by the Alien class
 */
public class TestAlien {

  /**
   * Tests the initialization of an Alien using the constructor that uses only name and maxHP
   */
  @Test
  public void testInitialization() {
    Alien allen = new Alien("Allen", 10);

    assertEquals("Allen", allen.getName());
    assertEquals(10, allen.getCurrentLifePoints());
  }

  @Test
  public void testLinearRecoveryBehavior() {
    Alien et = new Alien("E.T.", 30, new RecoveryLinear(5));

    assertEquals(30, et.getCurrentLifePoints());

    et.takeHit(15);
    assertEquals(15, et.getCurrentLifePoints());

    et.recover();
    assertEquals(20, et.getCurrentLifePoints());
  }
}

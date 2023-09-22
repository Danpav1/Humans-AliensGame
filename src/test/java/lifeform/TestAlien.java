package lifeform;

import static org.junit.Assert.*;

import exceptions.RecoveryRateException;
import org.junit.Test;

import recovery.*;

/**
 * Tests the functionality provided by the Alien class
 */
public class TestAlien {
  /**
   * Tests the initialization of an Alien using the constructor that uses only name
   * and maxHitPoints
   */
  @Test
  public void testInitialization1() throws RecoveryRateException {
    Alien allen = new Alien("Allen", 10);

    assertEquals("Allen", allen.getName());
    assertEquals(10, allen.getCurrentLifePoints());
    assertEquals(10, allen.attackStrength);
  }

  /**
   * Tests that an Alien with linear recovery behaves as expected
   */
  @Test
  public void testLinearRecoveryBehavior() throws RecoveryRateException {
    Alien et = new Alien("E.T.", 30, new RecoveryLinear(5));

    assertEquals(30, et.getCurrentLifePoints());

    et.takeHit(15);
    assertEquals(15, et.getCurrentLifePoints());

    et.recover();
    assertEquals(20, et.getCurrentLifePoints());
  }
}

package lifeform;

import static org.junit.Assert.*;

import exceptions.RecoveryRateException;
import gameplay.SimpleTimer;
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
  public void testInitialization() throws RecoveryRateException {
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

  /**
   * Tests that Aliens can watch SimpleTimers and heal according to their recoveryRate
   */
  @Test
  public void testAlienIsTimerObserver() throws RecoveryRateException {
    Alien greg = new Alien("Greg", 30, new RecoveryLinear(5), 3);
    SimpleTimer timer = new SimpleTimer();
    timer.addTimeObserver(greg);

    greg.takeHit(20);

    timer.timeChanged();
    assertEquals(10, greg.getCurrentLifePoints());

    timer.timeChanged();
    assertEquals(10, greg.getCurrentLifePoints());

    timer.timeChanged();
    assertEquals(15, greg.getCurrentLifePoints());
  }
}

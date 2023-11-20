package lifeform;

import static org.junit.Assert.*;

import exceptions.RecoveryRateException;
import exceptions.WeaponException;
import gameplay.SimpleTimer;
import org.junit.Test;

import recovery.*;
import weapon.Pistol;

/**
 * Tests the functionality provided by the Alien class
 */
public class TestAlien {
  /*
   * Lab 6 tests begin
   */

  /**
   * Tests that the alien default maxSpeed is 2
   */
  @Test
  public void testMaxSpeed() throws RecoveryRateException {
    Alien alien = new Alien("Alien", 30, new RecoveryNone());
    assertEquals(2, alien.getMaxSpeed());
  }

  @Test
  public void testAlienAttack() throws RecoveryRateException, WeaponException {
    Alien alien = new Alien("Sugma", 30, new RecoveryNone());
    Human human = new Human("Ligma", 50, 0);
    alien.attack(human, 0);
    assertEquals(40, human.getCurrentLifePoints());

    Pistol pistol = new Pistol();
    alien.pickUpWeapon(pistol);
    alien.attack(human, 10);
    assertEquals(30, human.getCurrentLifePoints());
  }

  @Test
  public void testAlienAttackWithArmor() throws RecoveryRateException, WeaponException {
    Alien alien = new Alien("Sugma", 30, new RecoveryNone());
    Human human = new Human("Ligma", 50, 10);
    Pistol pistol = new Pistol();

    alien.pickUpWeapon(pistol);
    alien.attack(human, 0);
    assertEquals(48, human.getCurrentLifePoints());
  }

  /*
   * Lab 6 tests end; Lab 1-5 tests begin -----------------------------------------------------------------------------
   */

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

    Alien omniMan = new Alien("Omni-Man", 100, new RecoveryLinear(100), 1);

    assertEquals(1, omniMan.getRecoveryRate());
  }

  /**
   * Test that Aliens with recoveryRate 0 do not recover
   */
  @Test
  public void testNoRecoveryWhenRateZero() throws RecoveryRateException {
    Alien meeseeks = new Alien("Mr. Meeseeks", 20, new RecoveryLinear(3), 0);

    meeseeks.takeHit(10);
    assertEquals(10, meeseeks.getCurrentLifePoints());

    meeseeks.updateTime(1);
    assertEquals(10, meeseeks.getCurrentLifePoints());
  }

  /**
   * Test that Aliens with recoveryRate > 0 recover as expected
   */
  @Test
  public void testRecoveryWhenRateNotZero1() throws RecoveryRateException {
    Alien goomba = new Alien("Goomba", 10, new RecoveryLinear(2), 1);

    goomba.takeHit(5);
    assertEquals(5, goomba.getCurrentLifePoints());

    goomba.updateTime(1);
    assertEquals(7, goomba.getCurrentLifePoints());
  }

  @Test
  public void testRecoveryWhenRateNotZero2() throws RecoveryRateException {
    Alien goomba = new Alien("Goomba", 10, new RecoveryLinear(2), 2);

    goomba.takeHit(5);
    assertEquals(5, goomba.getCurrentLifePoints());

    goomba.updateTime(1);
    assertEquals(5, goomba.getCurrentLifePoints());

    goomba.updateTime(2);
    assertEquals(7, goomba.getCurrentLifePoints());
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

  /**
   * Tests that Aliens can be removed as observers from SimpleTimer
   */
  @Test
  public void testAlienCanBeRemoved() throws RecoveryRateException {
    Alien yaphit = new Alien("Yaphit", 20);
    SimpleTimer timer = new SimpleTimer();

    timer.addTimeObserver(yaphit);
    assertEquals(1, timer.getNumObservers());

    timer.removeTimeObserver(yaphit);
    assertEquals(0, timer.getNumObservers());
  }

  /**
   * Tests that an Alien will throw a RecoveryRate exception if a
   * negative recoveryRate value is passed to its constructor
   */
  @Test
  public void testWillThrowRecoveryRateException() {
    boolean exceptionCaught = false;

    try {
      new Alien("Martian", 20, new RecoveryNone(), -1);
    } catch (RecoveryRateException e) {
      exceptionCaught = true;
    }

    assertTrue(exceptionCaught);
  }
}

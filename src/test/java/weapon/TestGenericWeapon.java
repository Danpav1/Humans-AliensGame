package weapon;

import static org.junit.Assert.*;

import org.junit.Test;

import gameplay.SimpleTimer;

import exceptions.WeaponException;

/**
 * Tests the functionality of the GenericWeapon class
 */
public class TestGenericWeapon {
  /**
   * Tests that one can get all fields of the weapon
   */
  @Test
  public void testCanGetFields() throws WeaponException {
    MockWeapon weapon = new MockWeapon();

    assertEquals(1, weapon.getBaseDamage());
    assertEquals(10, weapon.getMaxAmmo());
    assertEquals(10, weapon.getCurrentAmmo());
    assertEquals(20, weapon.getMaxRange());
    assertEquals(3, weapon.getRateOfFire());
    assertEquals(3, weapon.getShotsLeft());
  }

  /**
   * Tests that the toString method works
   */
  @Test
  public void testToString() {
    MockWeapon weapon = new MockWeapon();

    assertEquals("Mock Weapon: ", weapon.toString());
  }

  /**
   * Tests that the weapon can fire
   */
  @Test
  public void testCanFire() throws WeaponException {
    MockWeapon weapon = new MockWeapon();

    assertEquals(1, weapon.fire(0));
  }

  /**
   * Tests that the weapon uses ammo when fired
   */
  @Test
  public void testFireConsumesAmmo() throws WeaponException {
    MockWeapon weapon = new MockWeapon();

    for (int i = 10; i > 6; i--) {
      assertEquals(i, weapon.getCurrentAmmo());
      weapon.fire(0);
    }
  }

  /**
   * Tests that the weapon cannot do damage when out of ammo
   */
  @Test
  public void testCannotFireWhenEmpty() throws WeaponException {
    MockWeapon weapon = new MockWeapon(5, 1, 20, 3);

    assertEquals(5, weapon.fire(0));
    assertEquals(0, weapon.fire(0));
    assertEquals(0, weapon.fire(0));
  }

  /**
   * Tests that the weapon does no damage out of range, but consumes ammo
   */
  @Test
  public void testOutOfRange() throws WeaponException {
    MockWeapon weapon = new MockWeapon();

    assertEquals(10, weapon.getCurrentAmmo());
    assertEquals(1, weapon.fire(0));
    assertEquals(9, weapon.getCurrentAmmo());
    assertEquals(0, weapon.fire(30));
    assertEquals(8, weapon.getCurrentAmmo());
  }

  /**
   * Tests that the weapon can be reloaded
   */
  @Test
  public void testCanBeReloaded() throws WeaponException {
    MockWeapon weapon = new MockWeapon();

    for (int i = 0; i < 3; i++) {
      weapon.fire(0);
    }
    assertEquals(7, weapon.getCurrentAmmo());

    weapon.reload();
    assertEquals(10, weapon.getCurrentAmmo());
  }

  /**
   * Tests that exception will be thrown in fire() when distance is negative
   */
  @Test
  public void testDistanceCannotBeNegative() throws WeaponException {
    boolean exceptionCaught = false;
    MockWeapon weapon = new MockWeapon();

    try {
      weapon.fire(-1);
    } catch (WeaponException e) {
      exceptionCaught = true;
    }

    assertTrue(exceptionCaught);
  }

  /**
   * Tests that weapons are TimerObservers and that rateOfFire works as intended
   */
  @Test
  public void testWeaponsAreTimerObservers() throws WeaponException {
    SimpleTimer timer = new SimpleTimer();
    MockWeapon weapon = new MockWeapon(1, 10, 20, 5);
    timer.addTimeObserver(weapon);

    for (int i = 0; i < 5; i++) {
      assertEquals(10 - i, weapon.getCurrentAmmo());
      weapon.fire(0);
    }

    for (int i = 0; i < 3; i++) {
      assertEquals(5, weapon.getCurrentAmmo());
      weapon.fire(0);
    }

    timer.timeChanged();

    for (int i = 0; i < 5; i++) {
      assertEquals(5 - i, weapon.getCurrentAmmo());
      weapon.fire(0);
    }
  }
}

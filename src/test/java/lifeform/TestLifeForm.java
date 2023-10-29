package lifeform;

import static org.junit.Assert.*;

import exceptions.WeaponException;
import org.junit.Test;
import weapon.MockWeapon;
import weapon.Weapon;

/**
 * Tests the functionality provided by the LifeForm class
 */
public class TestLifeForm {
  /*
   * Lab 5 tests begin -----------------------------------------------------------------------------
   */

  /**
   * Tests that LifeForms can keep track of their coordinates in the Environment
   */
  @Test
  public void testHasCoordinates() {
    LifeForm critter = new MockLifeForm("Critter", 1);

    assertEquals(-1, critter.getRow());
    assertEquals(-1, critter.getCol());
  }

  /**
   * Tests that LifeForms can have their locations set
   */
  @Test
  public void testCanSetLocation() {
    LifeForm creature = new MockLifeForm("Creature", 1);

    creature.setLocation(4, 5);

    assertEquals(4, creature.getRow());
    assertEquals(5, creature.getCol());
  }

  /**
   * Tests that LifeForms will not change their location if either
   * coordinate is negative
   */
  @Test
  public void testWontMoveIfNegativeCoordinate() {
    LifeForm jerry = new MockLifeForm("Jerry", 1);

    jerry.setLocation(5, -5);

    assertEquals(-1, jerry.getRow());
    assertEquals(-1, jerry.getCol());

    jerry.setLocation(-4, 4);

    assertEquals(-1, jerry.getRow());
    assertEquals(-1, jerry.getCol());
  }

  /*
   * Lab 5 tests end; Lab 4 tests begin ------------------------------------------------------------
   */

  /**
   * When a LifeForm is created, it should know its name and how
   * many life points it has
   */
  @Test
  public void testInitialization() {
    LifeForm entity;
    entity = new MockLifeForm("Bob", 40, 12);

    assertEquals("Bob", entity.getName());
    assertEquals(40, entity.getCurrentLifePoints());
    assertEquals(12, entity.getAttackStrength());
  }

  /**
   * Tests that LifeForm can damage another LifeForm
   */
  @Test
  public void testCanAttack() throws WeaponException {
    LifeForm harry = new MockLifeForm("Harry", 15, 100);
    LifeForm voldemort = new MockLifeForm("Voldemort", 200, 100);

    harry.attack(voldemort, 0);

    assertEquals(100, voldemort.getCurrentLifePoints());
  }

  /**
   * Tests that a dead LifeForm cannot cause damage
   */
  @Test
  public void testCannotDamageWhenDead() throws WeaponException {
    LifeForm harry = new MockLifeForm("Harry", 15, 100);
    LifeForm voldemort = new MockLifeForm("Voldemort", 200, 100);

    harry.attack(voldemort, 0);
    harry.attack(voldemort, 0);

    voldemort.attack(harry, 0);

    assertEquals(15, harry.getCurrentLifePoints());
  }

  /**
   * Tests to see that a LifeForm can take a hit from initial life points
   */
  @Test
  public void testTakeHitInitial() {
    LifeForm marlin = new MockLifeForm("Marlin", 20);

    marlin.takeHit(5);
    assertEquals(15, marlin.getCurrentLifePoints());
  }

  /**
   * Tests to see that a LifeForm can take a hit appropriate to its current life points
   */
  @Test
  public void testTakeHitDynamic() {
    LifeForm steven = new MockLifeForm("Steven", 20);

    steven.takeHit(11);
    assertEquals(9, steven.getCurrentLifePoints());

    steven.takeHit(2);
    assertEquals(7, steven.getCurrentLifePoints());

    steven.takeHit(9);
    assertEquals(0, steven.getCurrentLifePoints());
  }

  /**
   * Tests that LifeForms can pick up Weapons.
   *
   * Written by Gavin Albright
   */
  @Test
  public void testPickup() {
    LifeForm stan = new MockLifeForm("stan", 20);
    MockWeapon test = new MockWeapon();
    boolean result = stan.pickUpWeapon(test);
    assertEquals(result, true);
  }

  /**
   * Tests that LifeForms cannot pick up Weapons when they are already holding one.
   *
   * Written by Gavin Albright.
   */
  @Test
  public void testPickupWhileHolding() {
    LifeForm stan = new MockLifeForm("stan", 20);
    MockWeapon test = new MockWeapon();
    MockWeapon testTwo = new MockWeapon();
    stan.pickUpWeapon(test);
    boolean result = stan.pickUpWeapon(testTwo);
    assertEquals(result, false);
  }

  /**
   * Tests that LifeForms can drop Weapons.
   *
   * Written by Gavin Albright
   */
  @Test
  public void testDrop() throws WeaponException {
    LifeForm stan = new MockLifeForm("stan", 20);
    MockWeapon test = new MockWeapon();
    stan.pickUpWeapon(test);
    Weapon returner = stan.dropWeapon();
    assertFalse(stan.hasWeapon());
  }

  /**
   * Tests that LifeForms can use Weapons in their attack() method.
   *
   * Written by Gavin Albright
   */
  @Test
  public void testWeaponUse() throws WeaponException {
    LifeForm stan = new MockLifeForm("stan", 20);
    LifeForm dan = new MockLifeForm("Dan", 30);
    MockWeapon test = new MockWeapon();
    stan.pickUpWeapon(test);
    stan.attack(dan, 10);
    assertEquals(dan.getCurrentLifePoints(), 29);
  }

  /**
   * Tests that when a LifeForm is out of ammo and within melee range, will melee a target
   * instead of shooting them.
   *
   * Written by Gavin Albright
   */
  @Test
  public void testAmmoZero() throws WeaponException {
    LifeForm stan = new MockLifeForm("stan", 20, 1);
    LifeForm dan = new MockLifeForm("Dan", 30);
    MockWeapon test = new MockWeapon(4,1,20,3);
    stan.pickUpWeapon(test);
    stan.attack(dan, 10);
    stan.attack(dan, 5);
    assertEquals(dan.getCurrentLifePoints(), 25);
  }

  /**
   * Tests that if a LifeForm is out of ammo and out of melee range, no damage is done
   * to the target.
   *
   * Written by Gavin Albright
   */
  @Test
  public void testMeleeFail() throws WeaponException {
    LifeForm stan = new MockLifeForm("stan", 20, 1);
    LifeForm dan = new MockLifeForm("Dan", 30);
    stan.attack(dan, 15);
    assertEquals(dan.getCurrentLifePoints(), 30);
  }

  /**
   * Tests that a LifeForm's Weapon can be reloaded.
   *
   * Written by Gavin Albright
   */
  @Test
  public void testReload() throws WeaponException {
    LifeForm stan = new MockLifeForm("stan", 20, 1);
    LifeForm dan = new MockLifeForm("Dan", 30);
    MockWeapon test = new MockWeapon(4,1,20,3);
    stan.pickUpWeapon(test);
    stan.attack(dan, 10);
    assertEquals(stan.weapon.getCurrentAmmo(), 0);
    stan.weapon.reload();
    assertEquals(stan.weapon.getCurrentAmmo(), 1);
  }
}

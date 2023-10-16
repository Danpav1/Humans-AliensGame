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

    harry.attack(voldemort);

    assertEquals(100, voldemort.getCurrentLifePoints());
  }

  /**
   * Tests that a dead LifeForm cannot cause damage
   */
  @Test
  public void testCannotDamageWhenDead() throws WeaponException {
    LifeForm harry = new MockLifeForm("Harry", 15, 100);
    LifeForm voldemort = new MockLifeForm("Voldemort", 200, 100);

    harry.attack(voldemort);
    harry.attack(voldemort);

    voldemort.attack(harry);

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



  @Test
  public void testPickup() {
    LifeForm stan = new MockLifeForm("stan", 20);
    MockWeapon test = new MockWeapon();
    boolean result = stan.pickUpWeapon(test);
    assertEquals(result, true);


  }

  @Test
  public void testPickupWhileHolding() {
    LifeForm stan = new MockLifeForm("stan", 20);
    MockWeapon test = new MockWeapon();
    MockWeapon testTwo = new MockWeapon();
    stan.pickUpWeapon(test);
    boolean result = stan.pickUpWeapon(testTwo);
    assertEquals(result, false);


  }

  @Test
  public void testDrop() throws WeaponException {
    LifeForm stan = new MockLifeForm("stan", 20);
    MockWeapon test = new MockWeapon();
    stan.pickUpWeapon(test);
    Weapon returner = stan.dropWeapon();
    assertFalse(stan.hasWeapon());

  }

  @Test
  public void testWeaponUse() throws WeaponException {
    LifeForm stan = new MockLifeForm("stan", 20);
    LifeForm dan = new MockLifeForm("Dan", 30);
    MockWeapon test = new MockWeapon();
    stan.pickUpWeapon(test);
    stan.attack(dan, 10);
    assertEquals(dan.getCurrentLifePoints(), 29);

  }

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

  @Test
  public void testMeleeFail() throws WeaponException {
    LifeForm stan = new MockLifeForm("stan", 20, 1);
    LifeForm dan = new MockLifeForm("Dan", 30);
    stan.attack(dan, 15);
    assertEquals(dan.getCurrentLifePoints(), 30);

  }

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

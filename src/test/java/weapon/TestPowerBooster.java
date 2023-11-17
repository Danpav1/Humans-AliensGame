package weapon;

import static org.junit.Assert.*;

import gameplay.SimpleTimer;
import lifeform.MockLifeForm;
import org.junit.Test;

import exceptions.AttachmentException;
import exceptions.WeaponException;

public class TestPowerBooster {

  @Test
  public void testDamageCalculation() throws AttachmentException, WeaponException {
    //damage * ( 1 + (currentAmmo / maxAmmo))
    //10 * ( 1 + (5 / 10) = 10 * 1.5 = 15
    PowerBooster b = new PowerBooster(new MockWeapon(10, 10, 10, 10));
    b.fire(5);
    b.fire(5);
    b.fire(5);
    b.fire(5);
    b.fire(5);
    assertEquals(5, b.getCurrentAmmo());
    assertEquals(15, b.fire(5));
  }

  @Test
  public void testDamageCalculation2() throws AttachmentException, WeaponException {
    PowerBooster b = new PowerBooster(new MockWeapon(7, 10, 10, 10));
    //7 * (1 + (3 / 10)) = 9.1 = 9
    b.fire(5);
    b.fire(5);
    b.fire(5);
    b.fire(5);
    b.fire(5);
    b.fire(5);
    b.fire(5);
    assertEquals(3, b.getCurrentAmmo());
    assertEquals(9, b.fire(5));
  }

  @Test
  public void testAttachmentException() throws AttachmentException {

    boolean exception1Caught = false;

    try {
      new PowerBooster(new PowerBooster(new PowerBooster(new MockWeapon(10, 10, 10, 10))));
    } catch (AttachmentException e) {
      exception1Caught = true;
    }

    assertTrue(exception1Caught);
  }


  @Test
  public void testChainGunWithPowerBooster() throws WeaponException, AttachmentException {
    Weapon weapon = new PowerBooster(new ChainGun());
    MockLifeForm tester = new MockLifeForm("Tester", 10);
    MockLifeForm dummy = new MockLifeForm("Dummy", 100);

    tester.pickUpWeapon(weapon);
    tester.attack(dummy, 50);
    assertEquals(76, dummy.getCurrentLifePoints());

    tester.attack(dummy, 30);
    assertEquals(63, dummy.getCurrentLifePoints());
  }

  @Test
  public void testPistolWithScopeAndPowerBooster() throws WeaponException, AttachmentException {
    Weapon weapon = new PowerBooster(new Scope(new Pistol()));
    MockLifeForm tester = new MockLifeForm("Tester", 10);
    MockLifeForm dummy = new MockLifeForm("Dummy", 100);

    tester.pickUpWeapon(weapon);
    tester.attack(dummy, 60);
    assertEquals(86, dummy.getCurrentLifePoints());

    tester.attack(dummy, 25);
    assertEquals(66, dummy.getCurrentLifePoints());
  }

  @Test
  public void testChainGunWithTwoPowerBoosters() throws WeaponException, AttachmentException {
    Weapon weapon = new PowerBooster(new PowerBooster(new ChainGun()));
    MockLifeForm tester = new MockLifeForm("Tester", 10);
    MockLifeForm dummy = new MockLifeForm("Dummy", 150);

    tester.pickUpWeapon(weapon);
    tester.attack(dummy, 60);
    assertEquals(90, dummy.getCurrentLifePoints());

    tester.attack(dummy, 45);
    assertEquals(49, dummy.getCurrentLifePoints());
  }

  @Test
  public void testPlasmaCannonWithStabilizerAndPowerBooster() throws WeaponException,
          AttachmentException {
    SimpleTimer timer = new SimpleTimer();
    Weapon weapon = new PowerBooster(new Stabilizer(new PlasmaCannon()));
    timer.addTimeObserver(weapon);
    MockLifeForm tester = new MockLifeForm("Tester", 10);
    MockLifeForm dummy = new MockLifeForm("Dummy", 300);

    tester.pickUpWeapon(weapon);
    tester.attack(dummy, 40);
    assertEquals(176, dummy.getCurrentLifePoints());

    timer.timeChanged();

    tester.attack(dummy, 20);
    assertEquals(96, dummy.getCurrentLifePoints());
  }
}

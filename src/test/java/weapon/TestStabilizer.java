package weapon;

import static org.junit.Assert.*;

import gameplay.SimpleTimer;
import lifeform.MockLifeForm;
import org.junit.Test;

import exceptions.AttachmentException;
import exceptions.WeaponException;

public class TestStabilizer {

  @Test
  public void damageIncreasedBy25PercentTest1() throws AttachmentException, WeaponException {
    Stabilizer b = new Stabilizer(new MockWeapon(10, 10, 10, 10));
    assertEquals(12, b.fire(5), 0);
  }

  @Test
  public void damageIncreasedBy25PercentTest2() throws AttachmentException, WeaponException {
    Stabilizer b = new Stabilizer(new MockWeapon(1, 10, 10, 10));
    assertEquals(1, b.fire(5));
  }

  

  @Test
  public void testReload() throws AttachmentException, WeaponException {
    Stabilizer b = new Stabilizer(new MockWeapon(10, 2, 10, 10));
    assertEquals(2, b.getCurrentAmmo());
    b.fire(5);
    assertEquals(1, b.getCurrentAmmo());
    b.fire(5);
    assertEquals(2, b.getCurrentAmmo());
    b.fire(5);
    assertEquals(1, b.getCurrentAmmo());
  }

  @Test
  public void testPlasmaCannonWithStabilizer() throws AttachmentException, WeaponException {
    SimpleTimer timer = new SimpleTimer();
    Weapon weapon = new Stabilizer(new PlasmaCannon());
    timer.addTimeObserver(weapon);
    MockLifeForm tester = new MockLifeForm("Tester", 10);
    MockLifeForm dummy = new MockLifeForm("Dummy", 200);

    tester.pickUpWeapon(weapon);
    tester.attack(dummy, 40);
    assertEquals(138, dummy.getCurrentLifePoints());

    timer.timeChanged();

    tester.attack(dummy, 30);
    assertEquals(92, dummy.getCurrentLifePoints());
  }

  @Test
  public void testPlasmaCannonWith2Stabilizers() throws AttachmentException, WeaponException {
    SimpleTimer timer = new SimpleTimer();
    Weapon weapon = new Stabilizer(new Stabilizer(new PlasmaCannon()));
    timer.addTimeObserver(weapon);
    MockLifeForm tester = new MockLifeForm("Tester", 10);
    MockLifeForm dummy = new MockLifeForm("Dummy", 200);

    tester.pickUpWeapon(weapon);
    tester.attack(dummy, 40);
    assertEquals(123, dummy.getCurrentLifePoints());

    timer.timeChanged();

    tester.attack(dummy, 30);
    assertEquals(66, dummy.getCurrentLifePoints());
  }

  @Test
  public void testPistolWithScopeAndStabilizer() throws AttachmentException, WeaponException {
    Weapon weapon = new Stabilizer(new Scope(new Pistol()));
    MockLifeForm tester = new MockLifeForm("Tester", 10);
    MockLifeForm dummy = new MockLifeForm("Dummy", 100);

    tester.pickUpWeapon(weapon);
    tester.attack(dummy, 60);
    assertEquals(92, dummy.getCurrentLifePoints());

    tester.attack(dummy, 40);
    assertEquals(86, dummy.getCurrentLifePoints());
  }

  @Test
  public void testChainGunWithPowerBoosterAndStabilizer() throws AttachmentException,
                                                                 WeaponException {
    Weapon weapon = new Stabilizer(new PowerBooster(new ChainGun()));
    MockLifeForm tester = new MockLifeForm("Tester", 10);
    MockLifeForm dummy = new MockLifeForm("Dummy", 100);

    tester.pickUpWeapon(weapon);
    tester.attack(dummy, 50);
    assertEquals(70, dummy.getCurrentLifePoints());

    tester.attack(dummy, 40);
    assertEquals(47, dummy.getCurrentLifePoints());
  }
}

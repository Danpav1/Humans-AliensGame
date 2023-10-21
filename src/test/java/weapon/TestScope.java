package weapon;

import static org.junit.Assert.*;

import gameplay.SimpleTimer;
import lifeform.MockLifeForm;
import org.junit.Test;

import exceptions.AttachmentException;
import exceptions.WeaponException;

public class TestScope {

  /**
   * Test that a scope can be created and modifies the weapon range;
   * and will throw an exception if added to a full weapon
   */
  @Test
  public void testInitialization() throws AttachmentException {
    Weapon weapon = new Scope(new MockWeapon());

    boolean exceptionCaught = false;
    assertEquals(30, weapon.getMaxRange());

    try {
      weapon = new Scope(new Scope(weapon));
    } catch (AttachmentException e) {
      exceptionCaught = true;
    }
    assertTrue(exceptionCaught);
  }

  /**
   * Tests that toString() works as intended
   */
  @Test
  public void testToString() throws AttachmentException {
    Weapon weapon = new Scope(new Scope(new MockWeapon()));

    assertEquals(weapon.toString(), "Mock Weapon +Scope +Scope");
  }

  /**
   * Tests that the scope properly modifies the damage of the weapon
   */
  @Test
  public void testDamageModification() throws AttachmentException, WeaponException {
    Weapon weapon = new Scope(new MockWeapon(10, 10, 20, 10));

    assertEquals(16, weapon.fire(10));

    assertEquals(15, weapon.fire(25));

    assertEquals(0, weapon.fire(32));
  }

  @Test
  public void testPistolWithScope() throws AttachmentException, WeaponException {
    Weapon weapon = new Scope(new Pistol());
    MockLifeForm tester = new MockLifeForm("Tester", 10);
    MockLifeForm dummy = new MockLifeForm("Dummy", 100);

    tester.pickUpWeapon(weapon);
    tester.attack(dummy, 55);
    assertEquals(93, dummy.getCurrentLifePoints());

    tester.attack(dummy, 15);
    assertEquals(78, dummy.getCurrentLifePoints());
  }

  @Test
  public void testPistolWith2Scopes() throws AttachmentException, WeaponException {
    SimpleTimer timer = new SimpleTimer();
    Weapon weapon = new Scope(new Scope(new Pistol()));
    timer.addTimeObserver(weapon);
    MockLifeForm tester = new MockLifeForm("Tester", 10);
    MockLifeForm dummy = new MockLifeForm("Dummy", 100);

    tester.pickUpWeapon(weapon);
    tester.attack(dummy, 65);
    assertEquals(88, dummy.getCurrentLifePoints());

    tester.attack(dummy, 55);
    assertEquals(80, dummy.getCurrentLifePoints());

    timer.timeChanged();

    tester.attack(dummy, 30);
    assertEquals(66, dummy.getCurrentLifePoints());
  }

  @Test
  public void testChainGunWithPowerBoosterAndScope() throws WeaponException, AttachmentException {
    Weapon weapon = new Scope(new PowerBooster(new ChainGun()));
    MockLifeForm tester = new MockLifeForm("Tester", 10);
    MockLifeForm dummy = new MockLifeForm("Dummy", 100);

    tester.pickUpWeapon(weapon);
    tester.attack(dummy, 70);
    assertEquals(65, dummy.getCurrentLifePoints());

    tester.attack(dummy, 50);
    assertEquals(36, dummy.getCurrentLifePoints());
  }

  @Test
  public void testPlasmaCannonWithStabilizerAndScope() throws WeaponException, AttachmentException {
    SimpleTimer timer = new SimpleTimer();
    Weapon weapon = new Scope(new Stabilizer(new PlasmaCannon()));
    timer.addTimeObserver(weapon);
    MockLifeForm tester = new MockLifeForm("Tester", 10);
    MockLifeForm dummy = new MockLifeForm("Dummy", 200);

    tester.pickUpWeapon(weapon);
    tester.attack(dummy, 50);
    assertEquals(133, dummy.getCurrentLifePoints());

    timer.timeChanged();

    tester.attack(dummy, 40);
    assertEquals(78, dummy.getCurrentLifePoints());
  }
}
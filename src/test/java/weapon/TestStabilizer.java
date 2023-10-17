package weapon;

import static org.junit.Assert.*;

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
  public void testNoDamageWhenOutOfRange() throws AttachmentException, WeaponException {
    Stabilizer b = new Stabilizer(new MockWeapon(10, 10, 10, 10));
    assertEquals(0, b.fire(20));
  }

  @Test
  public void testNegativeDistant() throws AttachmentException, WeaponException {
    Stabilizer b = new Stabilizer(new MockWeapon(0, 0, 0, 0));
    b.fire(-10);
  }

  @Test
  public void testReload() throws AttachmentException, WeaponException {
    Stabilizer b = new Stabilizer(new MockWeapon(10, 4, 10, 10));
    assertEquals(4, b.getCurrentAmmo());
    b.fire(5);
    assertEquals(2, b.getCurrentAmmo());
    b.fire(5);
    assertEquals(0, b.getCurrentAmmo());
    b.fire(5);
    assertEquals(4, b.getCurrentAmmo());
  }

  /**
   * @Test public void testToString() throws AttachmentException, WeaponException
   *       { Stabilizer b = new Stabilizer(new MockWeapon(10, 10, 10, 10));
   *       assertEquals("Mock Weapon Stabilizer Attachment ", b.toString()); }
   * @Test public void plasmaCannonAndStabilizer() {fail();}
   * @Test public void plasmaCannonAndStabilizerAndStabilizer() {fail();}
   * @Test public void pistolAndScopeAndStabilizer() {fail();}
   * @Test public void chainGunAndPowerBoosterAndStabilizer() {fail();}
   **/

}

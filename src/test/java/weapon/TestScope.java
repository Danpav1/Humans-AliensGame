package weapon;

import static org.junit.Assert.*;

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

    assertEquals(weapon.toString(), "Mock Weapon: Scope; Scope; ");
  }

  /**
   * Tests that the scope properly modifies the damage of the weapon
   */
  @Test
  public void testDamageModification() throws AttachmentException, WeaponException {
    Weapon weapon = new Scope(new MockWeapon(10, 10, 20, 10));

    assertEquals(16, weapon.fire(10));

    assertEquals(17, weapon.fire(25));

    assertEquals(0, weapon.fire(32));
  }
}
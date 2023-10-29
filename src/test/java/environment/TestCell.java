package environment;

import static org.junit.Assert.*;

import org.junit.Test;

import lifeform.LifeForm;
import lifeform.MockLifeForm;

import weapon.Weapon;
import weapon.MockWeapon;

/**
 * The test cases for the Cell class
 */
public class TestCell {
  /*
   * Lab 5 tests begin -----------------------------------------------------------------------------
   */

  /**
   * Tests that an initialized Cell contains no LifeForms or Weapons
   */
  @Test
  public void testInitializationWithWeapons() {
    Cell cell = new Cell();
    LifeForm placeholder = new MockLifeForm("Foo", 1);

    // tests that cell doesn't already have a LifeForm in it
    assertTrue(cell.addLifeForm(placeholder));

    assertNull(cell.getWeapon1());
    assertNull(cell.getWeapon2());
    assertEquals(0, cell.getWeaponsCount());
  }

  /**
   * Tests that weapons can be added to a Cell
   */
  @Test
  public void testCanAddWeapons() {
    Cell cell = new Cell();
    Weapon weapon1 = new MockWeapon();
    Weapon weapon2 = new MockWeapon();

    cell.addWeapon(weapon1);

    assertEquals(weapon1, cell.getWeapon1());
    assertEquals(1, cell.getWeaponsCount());

    cell.addWeapon(weapon2);

    assertEquals(weapon2, cell.getWeapon2());

    assertEquals(2, cell.getWeaponsCount());
  }

  /**
   * Tests that weapons can be removed from a Cell
   */
  @Test
  public void testCanRemoveWeapons() {
    Cell cell = new Cell();
    Weapon weapon1 = new MockWeapon();
    Weapon weapon2 = new MockWeapon();

    cell.addWeapon(weapon1);
    cell.addWeapon(weapon2);

    assertEquals(2, cell.getWeaponsCount());

    assertEquals(weapon1, cell.removeWeapon(cell.getWeapon1()));
    assertEquals(1, cell.getWeaponsCount());

    assertEquals(weapon2, cell.removeWeapon(cell.getWeapon2()));
    assertEquals(0, cell.getWeaponsCount());
  }

  /**
   * Tests that the Cell cannot be filled beyond capacity,
   * and returns false if such an attempt is made
   */
  @Test
  public void testCannotFillFullCell() {
    Cell cell = new Cell();
    Weapon weapon1 = new MockWeapon();
    Weapon weapon2 = new MockWeapon();

    cell.addWeapon(weapon1);
    cell.addWeapon(weapon2);

    Weapon weapon3 = new MockWeapon();

    assertFalse(cell.addWeapon(weapon3));
  }

  /*
   * Lab 5 tests end; Lab 4 tests begin ------------------------------------------------------------
   */

  /**
   * At initialization, the Cell should be empty and not contain a
   * LifeForm.
   */
  @Test
  public void testInitialization() {
    Cell cell = new Cell();
    assertNull(cell.getLifeForm());
  }

  /**
   * Checks to see if we change the LifeForm held by Cell that
   * getLifeForm properly responds to this change.
   */
  @Test
  public void testAddLifeForm() {
    LifeForm bob = new MockLifeForm("Bob", 40);
    LifeForm fred = new MockLifeForm("Fred", 40);
    Cell cell = new Cell();
    // The cell is empty so this should work.
    boolean success = cell.addLifeForm(bob);
    assertTrue(success);
    assertEquals(bob, cell.getLifeForm());
    // The cell is not empty so this should fail.
    success = cell.addLifeForm(fred);
    assertFalse(success);
    assertEquals(bob, cell.getLifeForm());
  }

  /**
   * Tests whether or not a LifeForm can be removed
   */
  @Test
  public void testRemoveLifeForm() {
    LifeForm manny = new MockLifeForm("Manny", 70);
    Cell cell = new Cell();

    cell.addLifeForm(manny);

    assertEquals(manny, cell.getLifeForm());

    cell.removeLifeForm();

    assertNull(cell.getLifeForm());
  }
}

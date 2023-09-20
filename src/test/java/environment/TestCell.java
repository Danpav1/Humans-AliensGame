package environment;

import static org.junit.Assert.*;

import org.junit.Test;

import lifeform.LifeForm;

/**
 * The test cases for the Cell class
 */
public class TestCell {
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
    LifeForm bob = new LifeForm("Bob", 40);
    LifeForm fred = new LifeForm("Fred", 40);
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
    LifeForm manny = new LifeForm("Manny", 70);
    Cell cell = new Cell();

    cell.addLifeForm(manny);

    assertEquals(cell.getLifeForm(), manny);

    cell.removeLifeForm();

    assertNull(cell.getLifeForm());
  }
}

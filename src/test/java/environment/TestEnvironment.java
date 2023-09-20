package environment;

import static org.junit.Assert.*;

import org.junit.Test;

import lifeform.LifeForm;

/**
 * The test cases for the Environment class
 */
public class TestEnvironment {
  /**
   * Tests that the environment can be initialized and that its
   * contents exist
   */
  @Test
  public void testInitialization() {
    Environment environment = new Environment(1, 1);
    assertNull(environment.getLifeForm(0, 0));
  }

  /**
   * Tests that LifeForms can be added and removed from the
   * Environment
   */
  @Test
  public void testAddAndGetLifeForm() {
    Environment environment = new Environment(2, 3);
    LifeForm charlie = new LifeForm("Charlie", 30);

    environment.addLifeForm(charlie, 0, 1);
    assertEquals(environment.getLifeForm(0, 1), charlie);
  }

  /**
   * Tests that the Environment will prevent the user from crashing the program
   * by trying to access a cell outside of the Environment
   */
  @Test
  public void testInvalidCell() {
    Environment environment = new Environment(4, 3);
    LifeForm steve = new LifeForm("Steve", 700);

    boolean success = environment.addLifeForm(steve, 4, 3);
    assertFalse(success);

    assertNotEquals(steve, environment.getLifeForm(4, 3));
    assertNull(environment.getLifeForm(4, 3));

    // to ensure that removeLifeForm does not crash the program if out of bounds
    environment.removeLifeForm(4, 3);
  }

  /**
   * Tests that LifeForms can be removed from the Environment
   */
  @Test
  public void testRemoveLifeForm() {
    Environment environment = new Environment(1, 1);
    LifeForm craig =  new LifeForm("Craig", 50);

    environment.addLifeForm(craig, 0, 0);
    assertEquals(craig, environment.getLifeForm(0, 0));

    environment.removeLifeForm(0, 0);
    assertNull(environment.getLifeForm(0, 0));
  }
}

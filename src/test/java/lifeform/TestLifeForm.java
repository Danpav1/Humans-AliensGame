package lifeform;

import static org.junit.Assert.*;

import org.junit.Test;

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
  public void testCanAttack() {
    LifeForm harry = new MockLifeForm("Harry", 15, 100);
    LifeForm voldemort = new MockLifeForm("Voldemort", 200, 100);

    harry.attack(voldemort);

    assertEquals(100, voldemort.getCurrentLifePoints());
  }

  /**
   * Tests that a dead LifeForm cannot cause damage
   */
  @Test
  public void testCannotDamageWhenDead() {
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
}

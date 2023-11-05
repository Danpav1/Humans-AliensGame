package commands;

import static org.junit.Assert.*;

import lifeform.MockLifeForm;
import org.junit.Test;

import environment.Environment;
import lifeform.LifeForm;
import weapon.MockWeapon;
import weapon.Weapon;

public class TestAttackCommand {

  /**
   * Test that an AttackCommand works in the East direction
   */
  @Test
  public void testAttackCommandEast() {
    LifeForm lifeForm1 = new MockLifeForm();
    LifeForm lifeForm2 = new MockLifeForm();
    Environment environment = Environment.getEnvironment(4, 5);
    Weapon weapon = new MockWeapon();

    lifeForm1.pickUpWeapon(weapon);

    assertTrue(environment.addLifeForm(lifeForm1, 1, 1));
    assertTrue(environment.addLifeForm(lifeForm2, 1, 3));

    lifeForm1.changeDirectionEast();

    Command attackCommand = new AttackCommand(lifeForm1);

    assertEquals(10, lifeForm2.getCurrentLifePoints());

    attackCommand.execute();

    assertEquals(9, lifeForm2.getCurrentLifePoints());

    lifeForm1.changeDirectionSouth();

    attackCommand.execute();

    assertEquals(9, lifeForm2.getCurrentLifePoints());

    Environment.removeEnvironment();
  }

  /**
   * Test that an AttackCommand works in the North direction
   */
  @Test
  public void testAttackCommandNorth() {
    LifeForm lifeForm1 = new MockLifeForm();
    LifeForm lifeForm2 = new MockLifeForm();
    Environment environment = Environment.getEnvironment(4, 5);
    Weapon weapon = new MockWeapon();

    lifeForm1.pickUpWeapon(weapon);

    assertTrue(environment.addLifeForm(lifeForm1, 3, 1));
    assertTrue(environment.addLifeForm(lifeForm2, 1, 1));

    lifeForm1.changeDirectionNorth();

    Command attackCommand = new AttackCommand(lifeForm1);

    assertEquals(10, lifeForm2.getCurrentLifePoints());

    attackCommand.execute();

    assertEquals(9, lifeForm2.getCurrentLifePoints());

    lifeForm1.changeDirectionSouth();

    attackCommand.execute();

    assertEquals(9, lifeForm2.getCurrentLifePoints());

    Environment.removeEnvironment();
  }

  /**
   * Test that an AttackCommand works in the West direction
   */
  @Test
  public void testAttackCommandWest() {
    LifeForm lifeForm1 = new MockLifeForm();
    LifeForm lifeForm2 = new MockLifeForm();
    Environment environment = Environment.getEnvironment(4, 5);
    Weapon weapon = new MockWeapon();

    lifeForm1.pickUpWeapon(weapon);

    assertTrue(environment.addLifeForm(lifeForm1, 1, 3));
    assertTrue(environment.addLifeForm(lifeForm2, 1, 1));

    lifeForm1.changeDirectionWest();

    Command attackCommand = new AttackCommand(lifeForm1);

    assertEquals(10, lifeForm2.getCurrentLifePoints());

    attackCommand.execute();

    assertEquals(9, lifeForm2.getCurrentLifePoints());

    lifeForm1.changeDirectionSouth();

    attackCommand.execute();

    assertEquals(9, lifeForm2.getCurrentLifePoints());

    Environment.removeEnvironment();
  }

  /**
   * Test that an AttackCommand works in the South direction
   */
  @Test
  public void testAttackCommandSouth() {
    LifeForm lifeForm1 = new MockLifeForm();
    LifeForm lifeForm2 = new MockLifeForm();
    Environment environment = Environment.getEnvironment(4, 5);
    Weapon weapon = new MockWeapon();

    lifeForm1.pickUpWeapon(weapon);

    assertTrue(environment.addLifeForm(lifeForm1, 1, 1));
    assertTrue(environment.addLifeForm(lifeForm2, 3, 1));

    lifeForm1.changeDirectionSouth();

    Command attackCommand = new AttackCommand(lifeForm1);

    assertEquals(10, lifeForm2.getCurrentLifePoints());

    attackCommand.execute();

    assertEquals(9, lifeForm2.getCurrentLifePoints());

    lifeForm1.changeDirectionNorth();

    attackCommand.execute();

    assertEquals(9, lifeForm2.getCurrentLifePoints());

    Environment.removeEnvironment();
  }
}

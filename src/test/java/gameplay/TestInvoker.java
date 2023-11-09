package gameplay;

import environment.Environment;
import lifeform.LifeForm;
import lifeform.MockLifeForm;
import org.junit.Test;
import weapon.MockWeapon;
import weapon.Weapon;

import static org.junit.Assert.*;

/**
 * @author Elijah Hill
 */
public class TestInvoker {

  @Test
  public void testOneCommand() {
    LifeForm jerry = new MockLifeForm();
    Environment environment = Environment.getEnvironment(4, 5);
    environment.addLifeForm(jerry, 1, 1);

    Invoker invoker = new Invoker(jerry);


    invoker.executeCommand(3);
    assertEquals(jerry.getCurrentDirection(), "south");

    Environment.removeEnvironment();
  }

  @Test
  public void testMultipleCommands() {
    LifeForm jerry = new MockLifeForm();
    Environment environment = Environment.getEnvironment(4, 5);
    environment.addLifeForm(jerry, 1, 1);
    Weapon gun = new MockWeapon();
    environment.addWeapon(gun, 2, 1);

    Invoker invoker = new Invoker(jerry);

    invoker.executeCommand(3);
    assertEquals(jerry.getCurrentDirection(), "south");
    invoker.executeCommand(0);
    assertEquals(jerry.getCol(), 1);
    assertEquals(jerry.getRow(), 2);
    invoker.executeCommand(7);
    assertEquals(jerry.getWeapon(), gun);
    invoker.executeCommand(1);
    assertEquals(jerry.getCurrentDirection(), "north");

    Environment.removeEnvironment();
  }
}

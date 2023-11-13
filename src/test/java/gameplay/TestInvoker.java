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


    invoker.executeCommand(CommandName.FACE_SOUTH);
    assertEquals(jerry.getCurrentDirection(), "south");

    Environment.removeEnvironment();
  }

  @Test
  public void testMultipleCommands() {
    Environment.removeEnvironment();
    LifeForm jerry = new MockLifeForm();
    Environment environment = Environment.getEnvironment(4, 5);
    environment.addLifeForm(jerry, 1, 1);
    Weapon gun = new MockWeapon();
    environment.addWeapon(gun, 2, 1);

    Invoker invoker = new Invoker(jerry);

    invoker.executeCommand(CommandName.FACE_SOUTH);
    assertEquals(jerry.getCurrentDirection(), "south");
    invoker.executeCommand(CommandName.MOVE);
    assertEquals(jerry.getCol(), 1);
    assertEquals(jerry.getRow(), 2);
    invoker.executeCommand(CommandName.GET_WEAPON_ONE);
    assertEquals(jerry.getWeapon(), gun);
    invoker.executeCommand(CommandName.FACE_NORTH);
    assertEquals(jerry.getCurrentDirection(), "north");

    Environment.removeEnvironment();
  }
}
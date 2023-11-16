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

  /**
   * Tests that a single command works in isolation
   */
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

  /**
   * Tests that multiple commands can be used from the same invoker
   */
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

  /**
   * Tests that an invoker can switch targets
   */
  @Test
  public void testSwitchTargets() {
    Environment environment = Environment.getEnvironment(5, 5);
    LifeForm first = new MockLifeForm();
    LifeForm second = new MockLifeForm();

    environment.addLifeForm(first, 1, 0);
    environment.addLifeForm(second, 2, 0);

    Invoker invoker = new Invoker(first);

    invoker.executeCommand(CommandName.FACE_EAST);
    assertEquals("east", first.getCurrentDirection());

    invoker.executeCommand(CommandName.MOVE);
    assertEquals(1, first.getCol());

    invoker.setLifeForm(second);

    invoker.executeCommand(CommandName.FACE_EAST);
    assertEquals("east", second.getCurrentDirection());

    invoker.executeCommand(CommandName.MOVE);
    assertEquals(1, second.getCol());
  }
}
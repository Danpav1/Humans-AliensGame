package commands;

import environment.Environment;
import lifeform.Human;
import lifeform.LifeForm;

import static org.junit.Assert.*;

import org.junit.Test;


public class TestMoveCommand {

  /**
   * Tests moving a LifeForm via the move command, specifially east in this test
   */
  @Test
  public void testMove() {
    Environment game = Environment.getEnvironment(5, 5);
    LifeForm x = new Human("bob", 1, 1);
    game.addLifeForm(x, 0, 0);
    Command east = new FaceEastCommand(x);
    Command move = new MoveCommand(x);
    east.execute();
    move.execute();
    assertEquals(3, x.getCol());
    assertEquals(0, x.getRow());
  }
}

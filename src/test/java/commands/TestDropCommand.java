package commands;

import com.sun.net.httpserver.Filter;
import environment.Environment;
import lifeform.MockLifeForm;
import org.junit.Test;
import weapon.*;
import lifeform.*;
import static org.junit.Assert.*;

public class TestDropCommand {

  /**
   * Tests dropping a weapon when there is space available in the cell
   */
  @Test
  public void testDropWSpace() {
    Environment game = Environment.getEnvironment(5, 5);
    LifeForm x = new Human("bob", 1, 1);
    Weapon w = new PlasmaCannon();
    x.pickUpWeapon(w);
    Command drop = new DropWeaponCommand(x);
    Command east = new FaceEastCommand(x);
    Command move = new MoveCommand(x);
    game.addWeapon(new Pistol(), 0, 3);
    game.addLifeForm(x, 0, 0);
    assertNotNull(game.getWeapons(0, 3)[0]);
    assertNull(game.getWeapons(0, 3)[1]);
    east.execute();
    move.execute();
    drop.execute();
    assertNull(x.getWeapon());
    assertNotNull(game.getWeapons(0, 3)[0]);
    assertEquals(w, game.getWeapons(0, 3)[1]);
    Environment.removeEnvironment();
  }

  /**
   * Tests dropping a weapon where there is no space available to do so
   */
  @Test
  public void testDropWNoSpace() {
    Environment game = Environment.getEnvironment(5, 5);
    LifeForm x = new MockLifeForm();
    Weapon w = new PlasmaCannon();
    Command drop = new DropWeaponCommand(x);
    game.addWeapon(new Pistol(), 0, 3);
    game.addWeapon(new ChainGun(), 0, 3);
    assertEquals(2, game.getWeapons(0, 3).length);
    x.pickUpWeapon(w);
    game.addLifeForm(x, 0, 3);
    assertEquals(x, game.getLifeForm(0, 3));
    drop.execute();
    assertEquals(w, x.getWeapon());
    assertEquals(2, game.getWeapons(0, 3).length);
    Environment.removeEnvironment();
  }
}

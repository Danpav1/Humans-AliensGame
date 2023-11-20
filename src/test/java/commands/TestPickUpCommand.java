package commands;

import environment.Environment;
import lifeform.*;
import weapon.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestPickUpCommand {

  /**
   * Tests picking up a weapon where the lifeform does not already have one
   */
  @Test
  public void pickUpNoneHad() {
    Environment game = Environment.getEnvironment(5, 5);
    LifeForm x = new MockLifeForm();
    Weapon w = new Pistol();
    Command pick = new GetWeaponOneCommand(x);
    game.addWeapon(w, 0, 0);
    game.addLifeForm(x, 0, 0);
    assertNull(x.getWeapon());
    assertEquals(w, game.getWeapons(0, 0)[0]);
    pick.execute();
    assertEquals(w, x.getWeapon());
    assertNull(game.getWeapons(0, 0)[0]);
    Environment.removeEnvironment();
  }

  /**
   * Tests picking up a weapon when the lifeform does not already have one
   */
  @Test
  public void pickUpAlreadyHave() {
    Environment game = Environment.getEnvironment(5, 5);
    LifeForm x = new MockLifeForm();
    Weapon w = new Pistol();
    x.pickUpWeapon(w);
    assertEquals(w, x.getWeapon());
    Command pick = new GetWeaponOneCommand(x);
    Weapon v = new Pistol();
    game.addWeapon(v, 0, 0);
    game.addLifeForm(x, 0, 0);
    pick.execute();
    assertEquals(v, x.getWeapon());
    assertNotNull(game.getWeapons(0, 0)[0]);
    Environment.removeEnvironment();
  }
}

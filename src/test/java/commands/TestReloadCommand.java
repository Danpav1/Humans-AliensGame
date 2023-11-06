package commands;

import exceptions.WeaponException;
import lifeform.*;
import org.junit.Test;
import weapon.*;
import static org.junit.Assert.*;

public class TestReloadCommand {

  /**
   * Tests using the reload command to reload a weapon
   * @throws WeaponException for the fire method
   */
  @Test
  public void testReload() throws WeaponException {
    LifeForm x = new Human("dave", 1, 1);
    Weapon w = new Pistol();
    Command reload = new ReloadCommand(x);
    w.fire(1);
    assertEquals(w.getMaxAmmo() - 1, w.getCurrentAmmo());
    x.pickUpWeapon(w);
    reload.execute();
    assertEquals(w.getMaxAmmo(), w.getCurrentAmmo());
  }
}

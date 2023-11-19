package GUI;

import environment.Environment;
import exceptions.AttachmentException;
import exceptions.RecoveryRateException;
import lifeform.Alien;
import lifeform.Human;
import lifeform.LifeForm;
import weapon.ChainGun;
import weapon.Pistol;
import weapon.PlasmaCannon;
import weapon.PowerBooster;
import weapon.Scope;
import weapon.Stabilizer;
import weapon.Weapon;

/**
 * main class that only houses the main method.
 */

public class Main {
  
  /**
   * main method that "starts" the GUI
   * @param args
   * @throws RecoveryRateException
   * @throws AttachmentException
   */
  public static void main(String[] args) throws RecoveryRateException, AttachmentException {
    Environment world = Environment.getEnvironment(6, 6); //creates our "world" // board that the GUI references
    LifeForm alien = new Alien("Ligma", 2);
    LifeForm human = new Human("Sugma", 1, 10);

    Weapon pistol = new Pistol();
    Weapon plasma = new PlasmaCannon();
    Weapon chain = new ChainGun();

    Weapon pistol1 = new Scope(new Pistol());
    Weapon plasma1 = new Stabilizer(new PlasmaCannon());
    Weapon chain1 = new PowerBooster(new ChainGun());

    Weapon pistol2 = new PowerBooster(new Scope(new Pistol()));
    Weapon plasma2 = new Scope(new Scope(new PlasmaCannon()));
    Weapon chain2 = new Stabilizer(new Scope(new ChainGun()));

    human.pickUpWeapon(chain2);
    world.addWeapon(pistol, 0, 0);
    world.addWeapon(plasma, 2, 0);
    world.addWeapon(chain, 4, 0);

    world.addWeapon(pistol1, 1, 1);
    world.addWeapon(plasma1, 2, 3);
    world.addWeapon(chain1, 5, 5);

    world.addWeapon(pistol2, 1, 4);
    world.addWeapon(plasma2, 2, 3);
    world.addWeapon(chain2, 2, 3);
    
    world.addLifeForm(alien, 0, 0); //adds our alien "Ligma" to pos 0, 0
    world.addLifeForm(human, 3, 3); //adds our human "Sugma" to pos 3, 3

    GameUI ui = GameUI.getGameUI(world);
    RemoteUI.getRemote();
  }
}

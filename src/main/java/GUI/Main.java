package GUI;

import environment.Environment;
import exceptions.AttachmentException;
import exceptions.RecoveryRateException;
import gameplay.SimpleRefreshTimer;
import gameplay.SimpleTimer;
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
    Environment world = Environment.getEnvironment(7, 7); //creates our "world" // board that the GUI references
    LifeForm alien = new Alien("Ligma", 2);
    LifeForm human = new Human("Sugma", 1, 10);
    Weapon plasmaCannon = new Scope(new PlasmaCannon());
    Weapon pistol = new Pistol();
    Weapon pistol2 = new Pistol();
    Weapon pistol3 = new Pistol();
    Weapon chainGun = new Scope(new ChainGun());
    Weapon chainGun2 = new PowerBooster(new Stabilizer(new ChainGun()));

    alien.changeDirectionSouth();
    human.pickUpWeapon(chainGun);
    human.changeDirectionWest();
  
    world.addLifeForm(alien, 0, 0); //adds our alien "Ligma" to pos 0, 0
    world.addLifeForm(human, 3, 3); //adds our human "Sugma" to pos 3, 3
    world.addWeapon(plasmaCannon, 6,6);
    world.addWeapon(pistol2, 0, 0);
    world.addWeapon(pistol, 2, 5);
    world.addWeapon(chainGun, 3, 4);
    world.addWeapon(pistol3, 3, 4);
    world.addWeapon(chainGun2, 6, 1);

    SimpleTimer timer = new SimpleTimer(); //creates a simple timer with a 5 second sleep rate
    timer.addTimeObserver(plasmaCannon);
    timer.addTimeObserver(pistol);
    timer.addTimeObserver(pistol2);
    timer.addTimeObserver(pistol3);
    timer.addTimeObserver(chainGun);
    timer.start();                        //uses start() instead of run() to correctly run thread

    GameUI ui = GameUI.getGameUI(world);
    RemoteUI.getRemote();

    SimpleRefreshTimer sft = new SimpleRefreshTimer(66); //creates a simple refresh timer with a sleep of 15hz (66ms)
    sft.addTimeObserver(ui);
    sft.start();                        ////uses start() instead of run() to correctly run thread
  }
}

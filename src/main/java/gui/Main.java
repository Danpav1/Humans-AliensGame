package gui;

import environment.Environment;
import exceptions.AttachmentException;
import exceptions.RecoveryRateException;
import gameplay.SimpleTimer;
import gameplay.TimerObserver;
import lifeform.Alien;
import lifeform.Human;
import lifeform.LifeForm;
import recovery.RecoveryLinear;
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
    //creates our "world" // board that the GUI references
    // some variables made final for checkstyle
    final Environment world = Environment.getEnvironment(6, 6);
    final RecoveryLinear rrl = new RecoveryLinear(10);
    final Alien alien = new Alien("Ligma", 200, rrl,1);
    final LifeForm human = new Human("Sugma", 1, 10);
  

    Weapon pistol = new Pistol();
    Weapon plasma = new PlasmaCannon();
    final Weapon chain = new ChainGun();

    final Weapon pistol1 = new Scope(new Pistol());
    final Weapon plasma1 = new Stabilizer(new PlasmaCannon());
    final Weapon chain1 = new PowerBooster(new ChainGun());

    final Weapon pistol2 = new PowerBooster(new Scope(new Pistol()));
    final Weapon plasma2 = new Scope(new Scope(new PlasmaCannon()));
    Weapon chain2 = new Stabilizer(new Scope(new ChainGun()));

    SimpleTimer timer = new SimpleTimer(); //adds timer so each round is 5 seconds
    timer.addTimeObserver(pistol);
    timer.addTimeObserver(pistol1);
    timer.addTimeObserver(pistol2);
    timer.addTimeObserver(chain);
    timer.addTimeObserver(chain1);
    timer.addTimeObserver(chain2);
    timer.addTimeObserver(plasma);
    timer.addTimeObserver(plasma1);
    timer.addTimeObserver(plasma2);
    timer.addTimeObserver(alien);
    timer.start();

    human.pickUpWeapon(chain2);
    world.addWeapon(pistol, 0, 0);
    world.addWeapon(plasma, 5, 5);
    world.addWeapon(chain, 4, 0);

    world.addWeapon(pistol1, 0, 5);
    world.addWeapon(plasma1, 2, 3);
    world.addWeapon(chain1, 5, 5);

    world.addWeapon(pistol2, 1, 4);
    world.addWeapon(plasma2, 2, 3);
    world.addWeapon(chain2, 2, 3);
    
    world.addLifeForm(alien, 0, 0); //adds our alien "Ligma" to pos 0, 0
    world.addLifeForm(human, 3, 3); //adds our human "Sugma" to pos 3, 3

    GameUi ui = GameUi.getGameUi(world);
    RemoteUi.getRemote();
  }
}

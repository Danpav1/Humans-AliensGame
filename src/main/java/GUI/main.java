package GUI;

import environment.Environment;
import exceptions.RecoveryRateException;
import lifeform.Alien;
import lifeform.Human;
import lifeform.LifeForm;
import weapon.ChainGun;
import weapon.Pistol;
import weapon.PlasmaCannon;
import weapon.Weapon;

/**
 * main class that only houses the main method.
 */

public class main {
  
  /**
   * main method that "starts" the GUI
   * @param args
   * @throws RecoveryRateException
   */
  public static void main(String[] args) throws RecoveryRateException {
    Environment world = Environment.getEnvironment(6, 6); //creates our "world" // board that the GUI references
    LifeForm alien = new Alien("Ligma", 100); 
    LifeForm human = new Human("Sugma", 100, 10);
    Weapon plasmaCannon = new PlasmaCannon();
    Weapon pistol = new Pistol();
    Weapon chainGun = new ChainGun();

    alien.changeDirectionSouth();
    human.pickUpWeapon(chainGun);
    human.changeDirectionWest();
  
    world.addLifeForm(alien, 0, 0); //adds our alien "Ligma" to pos 0, 0
    world.addLifeForm(human, 3, 3); //adds our human "Sugma" to pos 3, 3
    world.addWeapon(plasmaCannon, 5, 1);
    world.addWeapon(pistol, 2, 5);
    world.addWeapon(chainGun, 3, 4);
    
    new gameUIBoard(world);
  }
}

package commands;

import environment.Environment;
import lifeform.LifeForm;
import weapon.Weapon;

/**
 * Command for a LifeForm to drop a weapon
 */
public class DropWeaponCommand implements Command {

  private LifeForm entity;

  /**
   * Constructor for the command
   * @param entity
   */
  public DropWeaponCommand(LifeForm entity) {
    this.entity = entity;
  }

  /**
   * Causes a lifeForm to either drop the weapon or not
   */
  @Override
  public void execute() {
    Weapon entityWeapon = entity.dropWeapon();
    if (!(Environment.getEnvironment(0, 0).addWeapon(entityWeapon,
                                                     entity.getRow(),
                                                     entity.getCol()))) {
      entity.pickUpWeapon(entityWeapon);
    } else {
      //Nothing needs to be done here because the execution happens in the conditional
    }
  }
}

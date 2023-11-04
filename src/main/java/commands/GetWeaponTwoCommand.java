package commands;

import lifeform.LifeForm;
import weapon.Weapon;

/**
 * Command for lifeform to pick up the second weapon in a cell
 */
public class GetWeaponTwoCommand implements Command {

  private LifeForm entity;

  /**
   * Constructor for the command
   * @param entity
   */
  public GetWeaponTwoCommand(LifeForm entity) {
    this.entity = entity;
  }

  /**
   * Executes the weaopn picking upping
   */
  public void execute() {
    Weapon[] weapons = entity.getContainer().getWeapons(entity.getRow(), entity.getCol());
    if(weapons[1] != null) {
      entity.pickUpWeapon(weapons[1]);
    }
  }
}

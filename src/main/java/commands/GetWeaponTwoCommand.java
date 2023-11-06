package commands;

import environment.Environment;
import lifeform.LifeForm;
import weapon.Weapon;

/**
 * Command for lifeform to pick up the second weapon in a cell
 */
public class GetWeaponTwoCommand implements Command {

  private LifeForm entity;

  /**
   * Constructor for GetWeaponTwoCommand
   *
   * @param entity the entity the command pertains to
   */
  public GetWeaponTwoCommand(LifeForm entity) {
    this.entity = entity;
  }

  /**
   * Executes the weapon picking upping
   */
  public void execute() {
    Weapon[] weapons = Environment.getEnvironment(0, 0).getWeapons(this.entity.getRow(),
                                                                   this.entity.getCol());
    if(weapons[1] != null && this.entity.getWeapon() == null) {
      this.entity.pickUpWeapon(weapons[1]);
      Environment.getEnvironment(0, 0).removeWeapon(weapons[1], this.entity.getRow(), this.entity.getCol());
    }
  }
}

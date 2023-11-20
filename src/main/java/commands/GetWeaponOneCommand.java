package commands;

import environment.Environment;
import lifeform.LifeForm;
import weapon.Weapon;

/**
 * Command for lifeform to pick up weapon one
 */
public class GetWeaponOneCommand implements Command {

  private LifeForm entity;

  /**
   * Constructor for GetWeaponOneCommand
   *
   * @param entity the entity the command pertains to
   */
  public GetWeaponOneCommand(LifeForm entity) {
    this.entity = entity;
  }

  /**
   * Executes the pick uppage of said weapon
   */
  public void execute() {
    Weapon[] weapons = Environment.getEnvironment(0, 0).getWeapons(this.entity.getRow(),
            this.entity.getCol());
    if (weapons[0] != null) {
      Weapon heldWeapon = this.entity.dropWeapon();
      this.entity.pickUpWeapon(weapons[0]);
      Environment.getEnvironment(0, 0).removeWeapon(weapons[0], this.entity.getRow(),
              this.entity.getCol());
      if (heldWeapon != null) {
        Environment.getEnvironment(0, 0).addWeapon(heldWeapon, this.entity.getRow(),
                this.entity.getCol());
      }
    }
  }
}

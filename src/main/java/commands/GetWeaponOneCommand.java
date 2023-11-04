package commands;

import lifeform.LifeForm;
import weapon.Weapon;

/**
 * Command for lifeform to pick up weapon one
 */
public class GetWeaponOneCommand implements Command {

  private LifeForm entity;

  /**
   * Constructor for the command
   * @param entity
   */
  public GetWeaponOneCommand(LifeForm entity) {
    this.entity = entity;
  }

  /**
   * Executes the pick uppage of said weapon
   */
  public void execute() {
    Weapon[] weapons = entity.getContainer().getWeapons(entity.getRow(), entity.getCol());
    if(weapons[0] != null) {
      entity.pickUpWeapon(weapons[0]);
    }
  }
}

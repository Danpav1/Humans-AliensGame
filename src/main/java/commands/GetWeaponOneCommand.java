package commands;

import GUI.GameUI;
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
    GameUI.getGameUI().updateDisplayTextArea("Picking up weapon 1\n");
    Weapon[] weapons = Environment.getEnvironment(0,0).getWeapons(this.entity.getRow(),
                                                                  this.entity.getCol());
    if (weapons[0] != null && this.entity.getWeapon() == null) {
      this.entity.pickUpWeapon(weapons[0]);
      Environment.getEnvironment(0, 0).removeWeapon(weapons[0], this.entity.getRow(),
              this.entity.getCol());
    }
  }
}

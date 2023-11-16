package commands;

import GUI.GameUI;
import lifeform.LifeForm;

/**
 * Command to reload a weapon
 */
public class ReloadCommand implements Command {

  private LifeForm entity;

  /**
   * Constructor
   * @param entity
   */
  public ReloadCommand(LifeForm entity) {
    this.entity = entity;
  }

  /**
   * Reloads the entity's weapon
   */
  public void execute() {
    this.entity.getWeapon().reload();
    GameUI game = GameUI.getGameUI();
    game.updateDisplayTextArea("Reloading!\n");
  }
}

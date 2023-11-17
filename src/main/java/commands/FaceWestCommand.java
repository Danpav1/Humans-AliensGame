package commands;

import GUI.GameUI;
import lifeform.LifeForm;

/**
 * Command for making LifeForm face west
 */
public class FaceWestCommand implements Command {
  private LifeForm entity;

  /**
   * Constructor for FaceWestCommand
   *
   * @param entity the entity the command pertains to
   */
  public FaceWestCommand(LifeForm entity) {
    this.entity = entity;
  }

  /**
   * Executes the direction change
   */
  public void execute() {
    GameUI.getGameUI().updateDisplayTextArea("Changing selected entity direction: West\n");
    this.entity.changeDirectionWest();
    GameUI.getGameUI().updateBoard();
  }
}

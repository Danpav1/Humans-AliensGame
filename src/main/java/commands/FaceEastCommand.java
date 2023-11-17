package commands;

import GUI.GameUI;
import lifeform.LifeForm;

/**
 * Command for making LifeForm face east
 */
public class FaceEastCommand implements Command {

  private LifeForm entity;

  /**
   * Constructor for FaceEastCommand
   *
   * @param entity the entity the command pertains to
   */
  public FaceEastCommand(LifeForm entity) {
    this.entity = entity;
  }

  /**
   * Executes the direction change
   */
  public void execute() {
    //GameUI.getGameUI().updateDisplayTextArea("Changed selected entity direction: East\n");
    this.entity.changeDirectionEast();
  }
}

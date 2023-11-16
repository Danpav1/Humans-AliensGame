package commands;

import GUI.GameUI;
import environment.Environment;
import lifeform.LifeForm;

/**
 * Command called when moving a LifeForm
 */
public class MoveCommand implements Command {

  private LifeForm entity;

  /**
   * Constructor for MoveCommand
   *
   * @param entity the entity the command pertains to
   */
  public MoveCommand(LifeForm entity) {
    this.entity = entity;
  }

  /**
   * Executes the movement of a LifeForm
   */
  @Override
  public void execute() {
    GameUI.getGameUI().updateDisplayTextArea("Moving selected entity\n");
    //Environment.getEnvironment(0, 0).move(this.entity);
    Environment.getEnvironment().move(this.entity);
    GameUI.getGameUI().updateBoard();
  }
}

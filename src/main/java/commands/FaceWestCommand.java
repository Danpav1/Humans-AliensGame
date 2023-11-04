package commands;

import lifeform.LifeForm;

/**
 * Command for making LifeForm face west
 */
public class FaceWestCommand implements Command {
  private LifeForm entity;

  /**
   * Constructor for the command
   * @param entity
   */
  public FaceWestCommand(LifeForm entity) {
    this.entity = entity;
  }

  /**
   * Executes the direction change
   */
  public void execute() {
    entity.changeDirectionWest();
  }
}

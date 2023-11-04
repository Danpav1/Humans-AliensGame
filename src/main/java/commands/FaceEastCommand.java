package commands;

import lifeform.LifeForm;

/**
 * Command for making LifeForm face east
 */
public class FaceEastCommand implements Command {

  private LifeForm entity;

  /**
   * Constructor for the command
   * @param entity
   */
  public FaceEastCommand(LifeForm entity) {
    this.entity = entity;
  }

  /**
   * Executes the direction change
   */
  public void execute() {
    entity.changeDirectionEast();
  }
}

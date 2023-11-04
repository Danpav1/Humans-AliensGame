package commands;

import lifeform.LifeForm;

/**
 * Command called when moving a LifeForm
 */
public class MoveCommand implements Command {

  private LifeForm entity;

  /**
   * Constructor for the MoveCommand
   * @param entity
   */
  public MoveCommand(LifeForm entity) {
    this.entity = entity;
  }

  /**
   * Executes the movement of a LifeForm
   */
  @Override
  public void execute() {
    entity.move();
  }
}

package commands;

import lifeform.LifeForm;

/**
 * Command for making a LifeForm face south
 */
public class FaceSouthCommand implements Command {

  private LifeForm entity;

  /**
   * Constructor for the command
   * @param entity
   */
  public FaceSouthCommand(LifeForm entity) {
    this.entity = entity;
  }

  /**
   * Executes the direction change
   */
  public void execute() {
    entity.changeDirectionSouth();
  }
}

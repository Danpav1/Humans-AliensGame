package commands;

import lifeform.LifeForm;

/**
 * Command for making a LifeForm face south
 */
public class FaceSouthCommand implements Command {

  private LifeForm entity;

  /**
   * Constructor for FaceSouthCommand
   *
   * @param entity the entity the command pertains to
   */
  public FaceSouthCommand(LifeForm entity) {
    this.entity = entity;
  }

  /**
   * Executes the direction change
   */
  public void execute() {
    this.entity.changeDirectionSouth();
  }
}

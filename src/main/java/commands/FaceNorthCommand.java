package commands;

import lifeform.LifeForm;

/**
 * Command called when making a LifeForm face North
 */
public class FaceNorthCommand implements Command {

  private LifeForm entity;

  /**
   * Constructor for FaceNorthCommand
   *
   * @param entity the entity the command pertains to
   */
  public FaceNorthCommand(LifeForm entity) {
    this.entity = entity;
  }

  /**
   * Causes a LifeForm to face north
   */
  public void execute() {
    this.entity.changeDirectionNorth();
  }
}

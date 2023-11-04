package commands;

import lifeform.LifeForm;

/**
 * Command called when making a LifeForm face North
 */
public class FaceNorthCommand implements Command {

  private LifeForm entity;

  /**
   * Constructor for FaceNorth
   * @param entity
   */
  public FaceNorthCommand(LifeForm entity) {
    this.entity = entity;
  }

  /**
   * Causes a LifeForm to face north
   */
  public void execute() {
    entity.changeDirectionNorth();
  }
}

package commands;

import lifeform.LifeForm;

public class AttackCommand implements Command {

  private LifeForm entity;

  public AttackCommand(LifeForm entity) {
    this.entity = entity;
  }

  @Override
  public void execute() {

  }
}

package commands;

import exceptions.EnvironmentException;
import exceptions.WeaponException;
import environment.Environment;
import lifeform.LifeForm;

/**
 * Command for making one LifeForm attack another
 */

public class AttackCommand implements Command {

  private final LifeForm entity;

  /**
   * Constructor for AttackCommand
   *
   * @param entity the entity the command pertains to
   */
  public AttackCommand(LifeForm entity) {
    this.entity = entity;
  }

  /**
   * Causes the LifeForm to attack an appropriate target
   */
  @Override
  public void execute() {
    LifeForm targetEntity = this.acquireTarget();
    Environment world = Environment.getEnvironment();

    if (targetEntity != null) {
      try {
        int distance = (int) world.getDistance(this.entity, targetEntity);

        // check target's health before the attack
        if (targetEntity.getCurrentLifePoints() > 0) {
          this.entity.attack(targetEntity, distance);
          //After attack, if target's health is less than is 0, remove from environment
          if (targetEntity.getCurrentLifePoints() <= 0) {
            world.removeLifeForm(targetEntity.getRow(), targetEntity.getCol());
          }
        } else {
          // remove the target from the environment
          world.removeLifeForm(targetEntity.getRow(), targetEntity.getCol());
        }
      } catch (EnvironmentException | WeaponException ignored) {
        // Exceptions will not occur under current circumstances.
      }
    } else {
      try {
        this.entity.getWeapon().fire(0);
      } catch (WeaponException e) { /* Exception cannot occur in hard-coded example */ }
    }
  }

  /**
   * The algorithm for acquiring a target,
   * currently by straight line attacking in the facing direction
   *
   * @return the nearest LifeForm in the facing direction to attack
   */
  private LifeForm acquireTarget() {
    String facing = this.entity.getCurrentDirection();

    Environment environment = Environment.getEnvironment(0, 0);

    int entityCol = this.entity.getCol();
    int entityRow = this.entity.getRow();

    LifeForm target = null;

    switch (facing) {
      case "south":

        for (int row = entityRow + 1; row < environment.getNumRows(); row++) {

          target = environment.getLifeForm(row, entityCol);

          if (target != null) {
            return target;
          }
        }
        break;

      case "east":

        for (int col = entityCol + 1; col < environment.getNumCols(); col++) {

          target = environment.getLifeForm(entityRow, col);

          if (target != null) {
            return target;
          }
        }
        break;

      case "north":

        for (int row = entityRow - 1; row >= 0; row--) {

          target = environment.getLifeForm(row, entityCol);

          if (target != null) {
            return target;
          }
        }
        break;

      case "west":

        for (int col = entityCol - 1; col >= 0; col--) {

          target = environment.getLifeForm(entityRow, col);

          if (target != null) {
            return target;
          }
        }
        break;

      default:
        return null;
    }
    return null;
  }
}

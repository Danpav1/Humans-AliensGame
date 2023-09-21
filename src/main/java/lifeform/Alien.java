package lifeform;

import recovery.RecoveryBehavior;
import recovery.RecoveryLinear;
import recovery.RecoveryNone;

/**
 * Represents an Alien, as an extension of LifeForm. Has added regenerative functionality over
 * LifeForm, which allows it to recover health over time.
 */
public class Alien extends LifeForm {

  private final int maxHitPoints;
  private int recoveryRate;
  private RecoveryBehavior recoveryType;

  /**
   * Creates an Alien with no recovery type specified
   * @param name the name of the Alien
   * @param maxHitPoints the max maxHitPoints points of the Alien
   */
  public Alien(String name, int maxHitPoints) {
    super(name, maxHitPoints);
    this.maxHitPoints = maxHitPoints;
    this.recoveryType = new RecoveryNone();
    this.recoveryRate = 0;
  }

  /**
   * Creates an Alien with a specified recovery type
   * @param name
   * @param maxHitPoints
   * @param behavior The RecoveryBehavior to assign to the Alien
   */
  public Alien(String name, int maxHitPoints, RecoveryBehavior behavior) {
    this(name, maxHitPoints);
    this.recoveryType = behavior;
  }

  /**
   * Performs the recovery of health upon call
   */
  protected void recover() {
    int recovery = this.recoveryType.calculateRecovery(this.currentLifePoints, this.maxHitPoints);
    this.currentLifePoints = recovery;
  }
}

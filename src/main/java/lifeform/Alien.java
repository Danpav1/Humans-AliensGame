package lifeform;

import recovery.RecoveryBehavior;
import recovery.RecoveryFractional;
import recovery.RecoveryLinear;
import recovery.RecoveryNone;
import gameplay.TimerObserver;
import exceptions.RecoveryRateException;

/**
 * Represents an Alien, as an extension of LifeForm. Has added regenerative functionality over
 * LifeForm, which allows it to recover health over time.
 */
public class Alien extends LifeForm implements TimerObserver {

  private final int maxHitPoints;
  private int recoveryRate;
  private RecoveryBehavior recoveryType;

  /**
   * Creates an Alien with no recovery type specified
   *
   * @param name         the name of the Alien
   * @param maxHitPoints the max maxHitPoints of the Alien
   */
  public Alien(String name, int maxHitPoints) throws RecoveryRateException {
    this(name, maxHitPoints, new RecoveryNone(), 0);
  }

  /**
   * Creates an Alien with recovery type specified
   *
   * @param name         the name of the Alien
   * @param maxHitPoints the max maxHitPoints of the Alien
   * @param behavior     The RecoveryBehavior to assign to the Alien
   */
  public Alien(String name,
               int maxHitPoints,
               RecoveryBehavior behavior) throws RecoveryRateException {
    this(name, maxHitPoints, behavior, 0);
  }

  /**
   * Creates an alien with recovery type and rate specified
   *
   * @param name         the name of the Alien
   * @param maxHitPoints the max maxHitPoints of the Alien
   * @param behavior     the RecoveryBehavior to assign to the Alien
   * @param recoveryRate the number of rounds between recoveries
   */
  public Alien(String name,
               int maxHitPoints,
               RecoveryBehavior behavior,
               int recoveryRate) throws RecoveryRateException {
    super(name, maxHitPoints, 10);

    if (recoveryRate < 0) {
      throw new RecoveryRateException("Recovery rate cannot be negative.");
    }

    this.maxHitPoints = maxHitPoints;
    this.recoveryType = behavior;
    this.recoveryRate = recoveryRate;
    this.maxSpeed = 2;
  }

  /**
   * Accessor for the maxLifePoints field
   *
   * @return the maxHitPoints field value
   */
  public int getMaxLifePoints() {
    return this.maxHitPoints;
  }

  /**
   * Accessor for the recoveryRate field
   *
   * @return the recoveryRate field value
   */
  public int getRecoveryRate() {
    return this.recoveryRate;
  }

  /**
   * returns the type of recovery behavior in string format
   * @return
   */
  public String getRecoveryTypeToString() {
    if (this.recoveryType instanceof RecoveryFractional) {
      return "RecoveryFractional: " + recoveryType.getRecoveryAmount();
    } else if (this.recoveryType instanceof RecoveryLinear) {
      return "RecoveryLinear: " + recoveryType.getRecoveryAmount();
    } else {
      return "RecoveryNone: " + recoveryType.getRecoveryAmount();
    }
  }

  /**
   * Performs the recovery of health upon call
   */
  protected void recover() {
    int recovery = this.recoveryType.calculateRecovery(this.currentLifePoints, this.maxHitPoints);
    this.currentLifePoints = recovery;
  }

  /**
   * Handles the Alien healing when observing the game timer
   */
  public void updateTime(int time) {
    if (recoveryRate != 0 && time % recoveryRate == 0) {
      this.recover();
    }
  }
}

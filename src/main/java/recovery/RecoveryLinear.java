package recovery;

/**
 * A RecoveryBehavior class that recovers health linearly over time
 */
public class RecoveryLinear implements RecoveryBehavior {
  private final int recoveryStep;

  /**
   * Creates a RecoveryLinear object
   * @param recoveryAmount The flat amount the LifeForm should be healed by per recovery
   */
  public RecoveryLinear(int recoveryAmount) {
    this.recoveryStep = recoveryAmount;
  }

  /**
   * Calculates an appropriate health value after recovery based on the currentLifePoints,
   * the maxLifePoints, and the recoveryStep
   * @param currentLife the currentLifePoints of the LifeForm
   * @param maxLife the madLifePoints of the LifeForm
   * @return the appropriate calculation for how much health the LifeForm should
   * have after the recovery
   */
  public int calculateRecovery(int currentLife, int maxLife) {
    int totalLife = currentLife + this.recoveryStep;

    if (currentLife <= 0) {
      return 0;
    } else {
      return Math.max(0, Math.min(maxLife, totalLife));
    }
  }
}

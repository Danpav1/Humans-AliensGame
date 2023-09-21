package recovery;

/**
 * A RecoveryBehavior class that recovers health linearly over time
 */
public class RecoveryLinear implements RecoveryBehavior {
  private int recoveryStep;

  /**
   * The constructor for RecoveryLinear that sets the recoveryStep field
   */
  public RecoveryLinear (int step) {
    this.recoveryStep = step;
  }

  /**
   * Calculates an appropriate health value after recovery based on the currentLifePoints,
   * the maxLifePoints, and the recoveryStep
   * @param currentLife
   * @param maxLife
   * @return
   */
  public int calculateRecovery(int currentLife, int maxLife) {
    int totalLife = currentLife + this.recoveryStep;

    if (currentLife <= 0) {
      return 0;
    } else if (totalLife > maxLife) {
      return maxLife;
    } else {
      return totalLife;
    }
  }
}

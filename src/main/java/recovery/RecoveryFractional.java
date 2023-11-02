package recovery;

/**
 * A RecoveryBehavior class that recovers a fraction of the current health per recovery
 */
public class RecoveryFractional implements RecoveryBehavior {
  private final double recoveryFraction;

  /**
   * Creates a RecoveryFractional object
   *
   * @param recoveryFraction the fractional amount of currentHealth that
   *                         should be recovered per recovery
   */
  public RecoveryFractional(double recoveryFraction) {
    this.recoveryFraction = recoveryFraction;
  }

  /**
   * Calculates an appropriate health value after recovery based on the currentLifePoints,
   * the maxLifePoints, and the recoveryStep
   *
   * @param currentLife the currentLifePoints of the LifeForm
   * @param maxLife     the madLifePoints of the LifeForm
   * @return the appropriate calculation for how much health the LifeForm should
   * have after the recovery
   */
  public int calculateRecovery(int currentLife, int maxLife) {
    int totalLife = (int) (Math.ceil(currentLife + currentLife * this.recoveryFraction));

    return Math.max(0, Math.min(maxLife, totalLife));
  }
}

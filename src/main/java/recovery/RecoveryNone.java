package recovery;

/**
 * A RecoveryBehavior class that does not recovery any health per turn
 */
public class RecoveryNone implements RecoveryBehavior {
  /**
   * Takes a health set and does nothing to it
   * @param currentLife
   * @param maxLife
   * @return The current life, since RecoveryNone does nothing to health
   */
  public int calculateRecovery(int currentLife, int maxLife) {
    return currentLife;
  }
}

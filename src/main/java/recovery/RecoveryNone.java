package recovery;

/**
 * A RecoveryBehavior class that does not recovery any health per turn
 */
public class RecoveryNone implements RecoveryBehavior {
  /**
   * Takes a health set and does nothing to it
   * @param currentLife the current life of the Alien containing RecoveryNone
   * @param maxLife the maximum possible life of the Alien containing RecoveryNone
   * @return the current life, since RecoveryNone does nothing to health
   */
  public int calculateRecovery(int currentLife, int maxLife) {
    return currentLife;
  }
}

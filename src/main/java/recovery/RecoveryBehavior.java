package recovery;

import gameplay.TimerObserver;

/**
 * An interface that is responsible for Alien recovery behavior
 */
public interface RecoveryBehavior {
  /**
   * Calculates the appropriate amount of recovery for each RecoveryBehavior,
   * given the currentLife and the maxLife of the LifeForm it pertains to
   *
   * @param currentLife the current life of the LifeForm containing the RecoveryBehavior
   * @param maxLife     the maximum possible life of the LifeForm containing the RecoveryBehavior
   * @return the new health value after the respective calculation
   */
  int calculateRecovery(int currentLife, int maxLife);
}

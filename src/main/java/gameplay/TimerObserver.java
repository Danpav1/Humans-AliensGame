package gameplay;

/**
 * An interface that is responsible for LifeForms being able
 * to observe the passage of time
 */
public interface TimerObserver {
  /**
   * Outlines a response to being updated by a Timer subject
   * @param time the current time being held by the Timer subject
   */
  void updateTime(int time);
}

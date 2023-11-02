package gameplay;

/**
 * An interface that is responsible for managing the passage of game time,
 * and represents the Subject for observer objects implementing TimerObserver
 */
public interface Timer {
  /**
   * Adds an observer to the list of current observers for an object implementing Timer
   *
   * @param observer the object implementing TimerObserver to be added
   */
  void addTimeObserver(TimerObserver observer);

  /**
   * Removes an observer from the list of current observers
   *
   * @param observer the object implementing TimerObserver to be removed
   */
  void removeTimeObserver(TimerObserver observer);

  /**
   * Changes the time and updates the observers accordingly
   */
  void timeChanged();
}

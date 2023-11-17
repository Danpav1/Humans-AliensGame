package gameplay;

/**
 * An interface that is responsible for managing the refreshing of the GameUI,
 * and represents the Subject for observer objects implementing RefreshTimerObserver
 * @author Daniel Pavenko
 */
public interface RefreshTimer {
  /**
   * Adds an observer to the list of current observers for an object implementing RefreshTimer
   *
   * @param observer the object implementing RefreshTimerObserver to be added
   */
  void addTimeObserver(RefreshTimerObserver observer);

  /**
   * Removes an observer from the list of current observers
   *
   * @param observer the object implementing RefreshTimerObserver to be removed
   */
  void removeTimeObserver(RefreshTimerObserver observer);

  /**
   * Calls all observers to refresh
   */
  void refresh();
}

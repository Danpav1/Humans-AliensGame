package gameplay;

import java.util.List;
import java.util.ArrayList;

/**
* The SimpleRefreshTimer class handles a basic refresh system, and acts as a subject in an
* observer pattern. It is observed by GameUI.
@author Daniel Pavenko
*/
public class SimpleRefreshTimer extends Thread implements RefreshTimer {
  private List<RefreshTimerObserver> theObservers = new ArrayList<>();
  private int sleepTime;
  private boolean endRefreshTimer = false;
  
  /**
  * run method for the thread
  */
  public void run() {
    while(!endRefreshTimer) {
      if (theObservers.get(0) != null) {
        try {
          Thread.sleep(this.sleepTime);
          this.refresh();
        } catch (InterruptedException e) {
          System.out.println("A thread sleeping exception has occurred. (Refresh)");
        }
      }
    }
  }
  
  /**
  * No-Args Constructor (default sleep time is 67 ms or 15 hz)
  */
  public SimpleRefreshTimer() {
    this(67);
  }
  
  /**
  * Constructs a SimpleRefreshTimer with a specified thread sleep
  *
  * @param sleep the time, in milliseconds, to sleep between thread executions
  */
  public SimpleRefreshTimer(int sleep) {
    this.sleepTime = sleep;
  }
  
  /**
  * Adds a RefreshTimerObserver to theObservers
  *
  * @param observer the RefreshTimerObserver to watch this SimpleTimer
  */
  public void addTimeObserver(RefreshTimerObserver observer) {
    this.theObservers.add(observer);
  }
  
  /**
  * Removes a Specified RefreshTimerObserver from theObservers
  *
  * @param observer the RefreshTimerObserver to remove from theObservers
  */
  public void removeTimeObserver(RefreshTimerObserver observer) {
    this.theObservers.remove(observer);
  }
  
  /**
  * Updates the SimpleRefreshTimer round number by 1
  */
  public void refresh() {
    theObservers.forEach(observer -> observer.updateRefresh());
  }
  
  /**
  * @return the number of RefreshTimerObservers that the SimpleRefreshTimer is being watched by
  */
  public int getNumObservers() {
    return this.theObservers.size();
  }
  
  /**
  * method that sets instance var endRefreshTimer to true.
  */
  public void endRefreshTimer() {
    this.endRefreshTimer = true;
  }
}

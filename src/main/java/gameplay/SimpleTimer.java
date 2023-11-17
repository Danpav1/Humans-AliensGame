package gameplay;

import java.util.List;
import java.util.ArrayList;

/**
 * The SimpleTimer class handles a basic round system, and acts as a subject in an
 * observer pattern. It is observed by Aliens.
 */
public class SimpleTimer extends Thread implements Timer {
  private List<TimerObserver> theObservers = new ArrayList<>();
  private int round;
  private int sleepTime;

  /**
   * run method for the thread
   */
  public void run() {
    for (int i = 0; i < 50; i++) {
      try {
        Thread.sleep(this.sleepTime);
        this.timeChanged();
      } catch (InterruptedException e) {
        System.out.println("A thread sleeping exception has occurred. (Lifeforms)");
      }
    }
  }

  /**
   * No-Args Constructor
   */
  public SimpleTimer() {
    this(1000);
  }

  /**
   * Constructs a SimpleTimer with a specified thread sleep
   *
   * @param sleep the time, in milliseconds, to sleep between thread executions
   */
  public SimpleTimer(int sleep) {
    this.round = 0;
    this.sleepTime = sleep;
  }

  /**
   * Adds a TimerObserver to theObservers
   *
   * @param observer the TimerObserver to watch this SimpleTimer
   */
  public void addTimeObserver(TimerObserver observer) {
    this.theObservers.add(observer);
  }

  /**
   * Removes a Specified TimerObserver from theObservers
   *
   * @param observer the TimerObserver to remove from theObservers
   */
  public void removeTimeObserver(TimerObserver observer) {
    this.theObservers.remove(observer);
  }

  /**
   * Updates the SimpleTimer round number by 1
   */
  public void timeChanged() {
    this.round++;
    theObservers.forEach(observer -> observer.updateTime(this.round));
  }

  /**
   * @return the number of TimerObservers that the SimpleTimer is being watched by
   */
  public int getNumObservers() {
    return this.theObservers.size();
  }

  /**
   * @return the round number of the SimpleTimer
   */
  public int getRound() {
    return this.round;
  }
}

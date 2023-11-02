package gameplay;

public class MockSimpleTimerObserver implements TimerObserver {
  public int myTime = 0;

  public void updateTime(int time) {
    this.myTime = time;
  }
}

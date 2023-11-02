package gameplay;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the functionality provided by the SimpleTimer class
 */
public class TestSimpleTimer {
  /**
   * Tests that a SimpleTimer can be instantiated with the proper fields
   */
  @Test
  public void testInitialization() {
    SimpleTimer timer = new SimpleTimer();

    assertEquals(0, timer.getRound());
    assertEquals(0, timer.getNumObservers());
    assertTrue(timer instanceof Timer);
  }

  /**
   * Tests that a TimerObserver can be added to Simple Timer
   */
  @Test
  public void testCanAddAndRemoveTimerObserver() {
    SimpleTimer timer = new SimpleTimer();
    MockSimpleTimerObserver observer = new MockSimpleTimerObserver();

    assertEquals(0, timer.getNumObservers());

    timer.addTimeObserver(observer);
    assertEquals(1, timer.getNumObservers());

    timer.removeTimeObserver(observer);

    assertEquals(0, timer.getNumObservers());
  }

  /**
   * Tests that SimpleTimer correctly updates time
   */
  @Test
  public void testCanUpdateTime() {
    SimpleTimer timer = new SimpleTimer();
    MockSimpleTimerObserver observer = new MockSimpleTimerObserver();
    MockSimpleTimerObserver observer2 = new MockSimpleTimerObserver();

    timer.addTimeObserver(observer);
    timer.addTimeObserver(observer2);
    timer.timeChanged();

    assertEquals(1, timer.getRound());
    assertEquals(1, observer.myTime);
    assertEquals(1, observer2.myTime);

    timer.timeChanged();

    assertEquals(2, timer.getRound());
    assertEquals(2, observer.myTime);
    assertEquals(2, observer2.myTime);
  }

  /**
   * Tests that timeChanged works even without observers
   */
  @Test
  public void testCanUpdateTimeWithoutObservers() {
    SimpleTimer timer = new SimpleTimer();

    timer.timeChanged();

    assertEquals(1, timer.getRound());
  }

  /**
   * This tests that SimpleTimer will update time once
   * every second.
   */
  @Test
  public void testSimpleTimerAsThread() throws InterruptedException {
    SimpleTimer st = new SimpleTimer(1000);
    st.start();
    Thread.sleep(250); // So we are 1/4th a second different
    for (int x = 0; x < 5; x++) {
      assertEquals(x, st.getRound()); //assumes round starts at 0
      Thread.sleep(1000); // wait for the next time change
    }
  }
}

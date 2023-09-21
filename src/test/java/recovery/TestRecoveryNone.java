package recovery;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the functionality provided by the RecoveryNone class
 */
public class TestRecoveryNone {
  /**
   * Tests the calculateRecovery method when currentLifePoints == maxLifePoints
   */
  @Test
  public void testCalculateRecoveryInitial() {
    RecoveryNone recovery = new RecoveryNone();

    assertEquals(20, recovery.calculateRecovery(20, 20));
  }

  /**
   * Tests the calculateRecovery method when currentLifePoints != maxLifePoints
   */
  @Test
  public void testCalculateRecoveryDynamic() {
    RecoveryNone recovery = new RecoveryNone();

    assertEquals(14, recovery.calculateRecovery(14, 20));
  }
}

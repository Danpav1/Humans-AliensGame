package recovery;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the functionality provided by the RecoveryLinear class
 */
public class TestRecoveryLinear {
  /**
   * Tests that no recovery occurs when currentLifePoints == maxLifePoints
   */
  @Test
  public void testNoRecoveryWhenNotHurt() {
    RecoveryLinear recovery = new RecoveryLinear(3);

    int maxLifePts = 30;
    int result = recovery.calculateRecovery(maxLifePts, maxLifePts);

    assertEquals(maxLifePts, result);
  }

  /**
   * Tests that recovery cannot exceed maxLifePoints
   */
  @Test
  public void testWhenItOnlyHurtsALittle() {
    RecoveryLinear recovery = new RecoveryLinear(5);

    int maxLifePoints = 20;
    int currentLifePoints = maxLifePoints - 3;

    assertEquals(maxLifePoints, recovery.calculateRecovery(currentLifePoints, maxLifePoints));
  }

  /**
   * Tests that recovery will fill by a full recoveryStep per turn when not limited
   */
  @Test
  public void testWhenItReallyHurts() {
    RecoveryLinear recovery = new RecoveryLinear(3);

    int currentLifePoints = 5;

    assertEquals(currentLifePoints + 3, recovery.calculateRecovery(currentLifePoints, 1000));
  }

  /**
   * Tests that recovery will not occur when dead
   */
  @Test
  public void testWhenDead() {
    RecoveryLinear recovery = new RecoveryLinear(6);

    int maxLifePoints = 10;

    assertEquals(0, recovery.calculateRecovery(0, maxLifePoints));
  }
}

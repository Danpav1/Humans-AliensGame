package recovery;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the functionality provided by the RecoveryFractional class
 */
public class TestRecoveryFractional {
  /**
   * Tests that no recovery occurs when currentLifePoints == maxLifePoints
   */
  @Test
  public void testNoRecoveryWhenNotHurt() {
    RecoveryFractional recovery = new RecoveryFractional(0.5);

    int currentLifePoints = 50;
    int maxLifePoints = 50;

    assertEquals(50, recovery.calculateRecovery(currentLifePoints, maxLifePoints));
  }

  /**
   * Tests that recovery cannot exceed maxLifePoints
   */
  @Test
  public void testWhenItOnlyHurtsALittle() {
    RecoveryFractional recovery = new RecoveryFractional(0.5);

    int currentLifePoints = 45;
    int maxLifePoints = 50;

    assertEquals(50, recovery.calculateRecovery(currentLifePoints, maxLifePoints));
  }

  /**
   * Tests that recovery will fill by a full fractional amount per turn when not limited
   */
  @Test
  public void testWhenItReallyHurts() {
    RecoveryFractional recovery = new RecoveryFractional(0.3);

    int currentLifePoints = 20;
    int maxLifePoints = 50;

    assertEquals(26, recovery.calculateRecovery(currentLifePoints, maxLifePoints));
  }

  /**
   * Tests that recovery will not occur when dead
   */
  @Test
  public void testWhenDead() {
    RecoveryFractional recovery = new RecoveryFractional(0.5);

    int currentLifePoints = 0;
    int maxLifePoints = 50;

    assertEquals(0, recovery.calculateRecovery(currentLifePoints, maxLifePoints));
  }

}

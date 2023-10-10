package weapon;

import static org.junit.Assert.*;

import org.junit.Test;

import gameplay.SimpleTimer;

import exceptions.WeaponException;
import exceptions.AttachmentException;

/**
 * Tests that the Attachment abstract class works as it should
 */
public class TestAttachment {
  /**
   * Tests that the attachment can be created and its weapon accessed/fired,
   * and that the weapon cannot have more than two attachments on it
   */
  @Test
  public void testInitialization() throws WeaponException, AttachmentException {
    MockAttachment attachment = new MockAttachment(new MockWeapon());

    assertEquals(1, attachment.getBaseDamage());
    assertEquals(10, attachment.getMaxAmmo());
    assertEquals(2, attachment.fire(0));
    assertEquals(9, attachment.getCurrentAmmo());
    assertEquals(20, attachment.getMaxRange());
    assertEquals(1, attachment.getNumAttachments());
    assertEquals(3, attachment.getRateOfFire());

    attachment.reload();

    MockAttachment attachment2 = new MockAttachment(attachment);

    assertEquals(1, attachment2.getBaseDamage());
    assertEquals(10, attachment2.getMaxAmmo());
    assertEquals(3, attachment2.fire(0));
    assertEquals(9, attachment2.getCurrentAmmo());
    assertEquals(20, attachment2.getMaxRange());
    assertEquals(2, attachment2.getNumAttachments());
    assertEquals(3, attachment2.getRateOfFire());

    attachment2.reload();

    boolean exception1Caught = false;
    boolean exception2Caught = false;

    try {
      MockAttachment attachment3 = new MockAttachment(attachment2);

      attachment3.fire(0);
    } catch (AttachmentException e) {
      exception1Caught = true;
    }

    try{
      MockAttachment attachment3 = new MockAttachment(attachment);

      attachment3.fire(0);
    } catch (AttachmentException e) {
      exception2Caught = true;
    }

    assertTrue(exception1Caught);
    assertFalse(exception2Caught);
  }

  /**
   * Tests that Attachment is a TimerObserver
   */
  @Test
  public void testAttachmentIsTimerObserver() throws WeaponException, AttachmentException {
    SimpleTimer timer = new SimpleTimer();
    MockAttachment attachment = new MockAttachment(new MockWeapon(1, 10, 20, 5));
    timer.addTimeObserver(attachment);

    for (int i = 0; i < 5; i++) {
      assertEquals(10 - i, attachment.getCurrentAmmo());
      attachment.fire(0);
    }

    for (int i = 0; i < 3; i++) {
      assertEquals(10 - 5, attachment.getCurrentAmmo());
      attachment.fire(0);
    }

    timer.timeChanged();

    for (int i = 0; i < 3; i++) {
      assertEquals(10 - 5 - i, attachment.getCurrentAmmo());
      attachment.fire(0);
    }
  }
}

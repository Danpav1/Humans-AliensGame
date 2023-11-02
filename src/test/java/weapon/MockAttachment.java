package weapon;

import exceptions.WeaponException;
import exceptions.AttachmentException;

public class MockAttachment extends Attachment {

  /**
   * Constructor for MockAttachments
   *
   * @param weapon the weapon that the attachment will apply to
   */
  public MockAttachment(Weapon weapon) throws AttachmentException {
    if (weapon.getNumAttachments() >= 2) {
      throw new AttachmentException("Weapon is full, cannot add more than two attachments.");
    }
    this.weapon = weapon;
  }

  public int fire(int distance) throws WeaponException {
    return this.weapon.fire(distance) + 1;
  }

  public String toString() {
    return this.weapon.toString() + " +Mock Attachment";
  }
}

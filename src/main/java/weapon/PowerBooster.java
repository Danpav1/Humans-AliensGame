package weapon;

import exceptions.AttachmentException;
import exceptions.WeaponException;

/**
 * Created by Danny Gonzales
 */
public class PowerBooster extends Attachment {
  /**
   * Constructor for PowerBoosters
   *
   * @param baseWeapon the Weapon to attach the PowerBooster to
   * @throws AttachmentException if the Weapon already has two Attachments on it
   */
  public PowerBooster(Weapon baseWeapon) throws AttachmentException {
    /*
    if (baseWeapon.getNumAttachments() < 2) {
      weapon = baseWeapon;
    } else {
      throw new AttachmentException("Weapon is full, cannot add more than two attachments.");
    }
    weapon = baseWeapon;
     */
    if (baseWeapon.getNumAttachments() >= 2) {
      throw new AttachmentException("Weapon is full. "
              + "Weapons cannot have more than two attachments.");
    }

    this.weapon = baseWeapon;
  }

  /**
   * Fires the Weapon and multiplies its damage by 1 + (currentAmmo / maxAmmo)
   *
   * @param distance the distance between the Weapon and the target
   * @return the modified damage appropriate to the weapon
   * @throws WeaponException when distance is negative
   */
  public int fire(int distance) throws WeaponException {

    double currentAmmo = (double) weapon.getCurrentAmmo();
    double maxAmmo = (double) weapon.getMaxAmmo();
    double damage = (double) weapon.fire(distance);
    double output = damage * (1.0 + (currentAmmo / maxAmmo));
    return (int) output;
  }

  /**
   * Displays the Weapon
   *
   * @return a string representing the Weapon and its Attachments
   */
  public String toString() {
    return weapon.toString() + " +PowerBooster";
  }
}

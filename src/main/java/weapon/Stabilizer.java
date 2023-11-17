package weapon;

import exceptions.AttachmentException;
import exceptions.WeaponException;
import gameplay.TimerObserver;

/**
 * Created by Danny Gonzales
 */
public class Stabilizer extends Attachment implements TimerObserver, Weapon {
  /**
   * Constructor for Stabilizers
   *
   * @param baseWeapon the Weapon to attach the Stabilizer to
   * @throws AttachmentException if the Weapon already has two Attachments on it
   */
  public Stabilizer(Weapon baseWeapon) throws AttachmentException {
    if (baseWeapon.getNumAttachments() < 2) {
      weapon = baseWeapon;
    } else {
      throw new AttachmentException("Weapon is full, cannot add more than two attachments.");
    }
    weapon = baseWeapon;
  }

  /**
   * Fires the Weapon and provides a flat damage buff of 25% to the Weapon
   *
   * @param distance the distance from the Weapon to the target
   * @return the modified damage appropriate to the Weapon
   * @throws WeaponException when distance is negative
   */
  public int fire(int distance) throws WeaponException {
    // always rounded DOWN
    //only call fire one time
    int damage = weapon.fire(distance);
    if (weapon.getCurrentAmmo() <= 0) {
      weapon.reload();
    }
    return (int) (damage + (damage * .25));
  }

  /**
   * @return a string representation of the Weapon
   */
  public String toString() {
    return weapon.toString() + " +Stabilizer";
  }
}

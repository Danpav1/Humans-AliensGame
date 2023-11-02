package weapon;

import exceptions.AttachmentException;
import exceptions.WeaponException;

/**
 * Created by Daniel Armstrong
 */
public class Scope extends Attachment {

  /**
   * Constructs Scope
   *
   * @param baseWeapon the weapon that the scope applies to
   * @throws AttachmentException when the weapon has two attachments already
   */
  public Scope(Weapon baseWeapon) throws AttachmentException {
    if (baseWeapon.getNumAttachments() >= 2) {
      throw new AttachmentException("Weapon is full. "
              + "Weapons cannot have more than two attachments.");
    }

    this.weapon = baseWeapon;
  }

  /**
   * Overrides Attachment.getMaxRange() to increase range value by 10
   *
   * @return the range of the weapon, plus 10 extra
   */
  @Override
  public int getMaxRange() {
    return this.weapon.getMaxRange() + 10;
  }

  /**
   * Fire the weapon and calculate the damage modifier
   *
   * @param distance the distance to the target
   * @return the final calculation of modified damage
   * @throws WeaponException when distance is negative
   */
  public int fire(int distance) throws WeaponException {
    double damage;
    // if distance > this.getMaxRange(), base weapon handles out of range
    if (distance > this.weapon.getMaxRange() && distance <= this.getMaxRange()) {
      damage = (double) this.weapon.fire(this.weapon.getMaxRange()) + 5;

    } else {
      double rangeModifier = (double) (this.getMaxRange() - distance) / (this.getMaxRange());
      damage = this.weapon.fire(distance) * (1.0 + rangeModifier);
    }

    return (int) damage;
  }

  /**
   * Displays the Weapon
   *
   * @return a string form of the Weapon and its Attachments
   */
  public String toString() {
    return this.weapon.toString() + " +Scope";
  }
}

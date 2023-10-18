package weapon;

import exceptions.AttachmentException;
import exceptions.WeaponException;


public class Scope extends Attachment {

  /**
   * Constructs Scope
   * @param weapon the weapon that the scope applies to
   * @throws AttachmentException when the weapon has two attachments already
   */
  public Scope(Weapon weapon) throws AttachmentException {
    if (weapon.getNumAttachments() >= 2) {
      throw new AttachmentException("Weapon is full, cannot add more than two attachments.");
    }
    this.weapon = weapon;
  }

  /**
   * Overrides Attachment.getMaxRange() to increase range value by 10
   * @return the range of the weapon, plus 10 extra
   */
  @Override
  public int getMaxRange() {
    return this.weapon.getMaxRange() + 10;
  }

  /**
   * Fire the weapon and calculate the damage modifier
   * @param distance the distance to the target
   * @return the final calculation of modified damage
   * @throws WeaponException when distance is negative
   */
  public int fire(int distance) throws WeaponException {
    if (distance <= this.getMaxRange()) {
      int damage = this.weapon.getBaseDamage();
      if (this.weapon.getMaxRange() < distance) {
        damage += 5;
      }

      double rangeModifier = (double) (this.getMaxRange() - distance) / (this.getMaxRange());
      double totalDamage = damage * (1.0 + rangeModifier);
      return (int) totalDamage;
    }
    return 0;
  }

  /**
   * @return a string form of the weapon and its attachments
   */
  public String toString() {
    return this.weapon.toString() + "Scope; ";
  }
}

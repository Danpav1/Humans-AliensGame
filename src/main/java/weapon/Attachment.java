package weapon;

import exceptions.WeaponException;

/**
 * A generic Attachment class for modifying concrete Weapon classes
 * Created by Daniel Armstrong
 */
public abstract class Attachment implements Weapon {
  protected Weapon weapon;

  /**
   * Fires the Weapon once, and lowers the currentAmmo of the Weapon by 1
   * @return the damage the Weapon will deal to the target
   */
  public abstract int fire(int distance) throws WeaponException;

  /**
   * @return the baseDamage of the Weapon
   */
  public int getBaseDamage() {
    return this.weapon.getBaseDamage();
  }

  /**
   * @return the currentAmmo of the Weapon
   */
  public int getCurrentAmmo() {
    return this.weapon.getCurrentAmmo();
  }

  /**
   * @return the maxAmmo of the base Weapon
   */
  public int getMaxAmmo() {
    return this.weapon.getMaxAmmo();
  }

  /**
   * @return the maxRange of the base Weapon
   */
  public int getMaxRange() {
    return this.weapon.getMaxRange();
  }

  /**
   * @return the number of Attachments on the Weapon
   */
  public int getNumAttachments() {
    return this.weapon.getNumAttachments() + 1;
  }

  /**
   * @return the rateOfFire of the base Weapon
   */
  public int getRateOfFire() {
    return this.weapon.getRateOfFire();
  }

  /**
   * @return the shotsLeft in the Weapon
   */
  public int getShotsLeft() {
    return this.weapon.getShotsLeft();
  }

  /**
   * Reloads the clip to full capacity
   */
  public void reload() {
    this.weapon.reload();
  }

  /**
   * @return a string display of the Weapon and its Attachments
   */
  public abstract String toString();

  /**
   * Updates the time of the weapon that the Attachment wraps
   * @param time the current time being held by the Timer subject
   */
  public void updateTime(int time) {
    this.weapon.updateTime(time);
  }
}

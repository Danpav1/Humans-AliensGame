package weapon;

import exceptions.WeaponException;

/**
 * The abstract class implementing Weapon that outlines the general behaviors of any base Weapon
 * Created by Daniel Armstrong
 */
public abstract class GenericWeapon implements Weapon {
  protected int baseDamage;
  protected int currentAmmo;
  protected int maxAmmo;
  protected int maxRange;
  protected int rateOfFire;
  protected int shotsLeft;

  /**
   * Fires the Weapon once, and lowers the currentAmmo of the Weapon by 1
   *
   * @param distance the distance to the target being fired at
   * @return the damage the Weapon will deal to the target
   */
  public abstract int fire(int distance) throws WeaponException;

  /**
   * @return the baseDamage of the Weapon
   */
  public int getBaseDamage() {
    return this.baseDamage;
  }

  /**
   * @return the currentAmmo of the Weapon
   */
  public int getCurrentAmmo() {
    return this.currentAmmo;
  }

  /**
   * @return the maxAmmo of the Weapon
   */
  public int getMaxAmmo() {
    return this.maxAmmo;
  }

  /**
   * @return the maxRange of the Weapon
   */
  public int getMaxRange() {
    return this.maxRange;
  }

  /**
   * @return the number of Attachments on the Weapon
   */
  public int getNumAttachments() {
    return 0;
  }

  /**
   * @return the rateOfFire of the Weapon
   */
  public int getRateOfFire() {
    return this.rateOfFire;
  }

  /**
   * @return the shotsLeft in the Weapon
   */
  public int getShotsLeft() {
    return this.shotsLeft;
  }

  /**
   * getter for base weapon
   */
  public abstract Weapon getBaseWeapon();

  /**
   * Reloads the clip to full capacity
   */
  public void reload() {
    this.currentAmmo = this.maxAmmo;
  }

  /**
   * @return a string display of the Weapon and its Attachments
   */
  public abstract String toString();

  /**
   * Updates the weapon when the round changes so that it can fire again
   *
   * @param time the current time being held by the Timer subject
   */
  public void updateTime(int time) {
    this.shotsLeft = this.rateOfFire;
  }
}

package weapon;

import gameplay.TimerObserver;
import exceptions.WeaponException;

/**
 * Outlines the required methods of each Weapon object
 * Created by Daniel Armstrong
 */
public interface Weapon extends TimerObserver {
  /**
   * Fires the Weapon once, and lowers the currentAmmo of the Weapon by 1
   *
   * @return the damage the Weapon will deal to the target
   */
  int fire(int distance) throws WeaponException;

  /**
   * @return the baseDamage of the Weapon
   */
  int getBaseDamage();

  /**
   * @return the currentAmmo of the Weapon
   */
  int getCurrentAmmo();

  /**
   * @return the maxAmmo of the Weapon
   */
  int getMaxAmmo();

  /**
   * @return the maxRange of the Weapon
   */
  int getMaxRange();

  /**
   * @return the number of Attachments on the Weapon
   */
  int getNumAttachments();

  /**
   * @return the rateOfFire of the Weapon
   */
  int getRateOfFire();

  /**
   * @return the shotsLeft in the Weapon
   */
  int getShotsLeft();

  /**
   * Reloads the clip to full capacity
   */
  void reload();

  /**
   * Gets the base weapon
   */
  Weapon getBaseWeapon();

  /**
   * @return a string display of the Weapon and its Attachments
   */
  String toString();
}

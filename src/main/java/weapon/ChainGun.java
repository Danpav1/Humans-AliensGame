package weapon;

import exceptions.WeaponException;

/**
 * Created by Stella Andersen
 */
public class ChainGun extends GenericWeapon {
  /**
   * Constructor for ChainGuns
   */
  public ChainGun() {
    this.baseDamage = 15;
    this.maxRange = 60;
    this.rateOfFire = 4;
    this.maxAmmo = 40;
    this.shotsLeft = rateOfFire;
    this.currentAmmo = maxAmmo;
  }

  /**
   * Fire at a target that is a certain distance away.
   * 
   * @param distance the distance away from the target. If in range, the target
   * will be hit.
   * 
   * @return the damage the weapon deals to the target. The target's armor may
   * reduce this damage. The damage will be zero if the target is out of range, or
   * if the weapon is out of ammo.
   */
  public int fire(int distance) throws WeaponException {
    if (distance < 0) {
      throw new WeaponException("Distance was " + distance
                              + ". Distance cannot be negative.");
    }

    double damage = 0.0;

    if (this.currentAmmo > 0 && this.shotsLeft > 0) {
      if (distance <= this.maxRange) {
        damage = this.baseDamage * (double) distance / this.maxRange;
      }
      this.currentAmmo--;
      this.shotsLeft--;
    }

    return (int) damage;
  }

  /**
   * Displays the Weapon
   *
   * @return the String description for the Weapon
   */
  public String toString() {
    return "ChainGun";
  }
}

package weapon;

import exceptions.WeaponException;

/**
 * Created by Stella Andersen
 */
public class PlasmaCannon extends GenericWeapon {
  /**
   * Constructor for PlasmaCannon weapon.
   */
  public PlasmaCannon() {
    this.baseDamage = 50;
    this.maxRange = 40;
    this.rateOfFire = 1;
    this.maxAmmo = 4;
    this.shotsLeft = this.rateOfFire;
    this.currentAmmo = this.maxAmmo;
  }

  /**
   * Fire at a target that is a certain distance away.
   *
   * @param distance the distance away from the target. If in range, the target
   *                 will be hit.
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
        damage = this.baseDamage * (double) this.currentAmmo / this.maxAmmo;
      }
      this.currentAmmo--;
      this.shotsLeft--;
    }

    return (int) damage;
  }

  /**
   * returns the base weapon
   */
  public Weapon getBaseWeapon() {
    return new PlasmaCannon();
  }

  /**
   * Displays the weapon
   *
   * @return the String description for the weapon.
   */
  public String toString() {
    return "PlasmaCannon";
  }

}

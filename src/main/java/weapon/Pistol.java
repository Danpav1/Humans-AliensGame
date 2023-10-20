package weapon;

import exceptions.WeaponException;

public class Pistol extends GenericWeapon {
  private double damage = 0.0;

  /**
   * The constructor for the Pistol weapon.
   */
  public Pistol() {   

    this.baseDamage = 10;
    this.maxRange = 50;
    this.rateOfFire = 2;
    this.maxAmmo = 10;
    this.shotsLeft = this.rateOfFire;
    this.currentAmmo = this.maxAmmo;

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
  @Override
  public int fire(int distance) throws WeaponException {
    if (distance < 0) {
      throw new WeaponException(null);
    
    } else if (distance > this.maxRange) {
      this.currentAmmo--;
      this.shotsLeft--;
      return 0;
    
    } else if (this.currentAmmo > 0 && this.shotsLeft > 0) {
      damage = (double) this.baseDamage 
          * ((double) this.maxRange - (double) distance + 10.0) / (double) this.maxRange;
      this.currentAmmo--;
      this.shotsLeft--;
    }
    return Double.valueOf(Math.floor(damage)).intValue();

  }

  /**
   * Displays the weapon
   * 
   * @return the String description for the weapon.
   */
  @Override
  public String toString() {
    String pistol = "Pistol";

    return pistol;
  }
}

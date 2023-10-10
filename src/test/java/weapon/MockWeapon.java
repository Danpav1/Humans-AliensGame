package weapon;

import exceptions.WeaponException;

/**
 * A Weapon made for testing that the Attachment class works
 */
public class MockWeapon extends GenericWeapon {

  /**
   * The full constructor for MockWeapon
   * @param baseDamage
   * @param maxAmmo
   * @param maxRange
   * @param rateOfFire
   */
  public MockWeapon(int baseDamage, int maxAmmo, int maxRange, int rateOfFire){


    this.baseDamage = baseDamage;
    this.maxAmmo = maxAmmo;
    this.currentAmmo = this.maxAmmo;
    this.maxRange = maxRange;
    this.rateOfFire = rateOfFire;
    this.shotsLeft = this.rateOfFire;
  }

  /**
   * The no-args constructor for MockWeapon
   */
  public MockWeapon() {
    this(1, 10, 20, 3);
  }

  /**
   * Fires a round as outlined in GenericWeapon
   * @param distance the distance to the target being fired at
   * @return the damage the Weapon will do to the target
   */
  public int fire(int distance) throws WeaponException {
    if (distance < 0) {
      throw new WeaponException("Distance cannot be negative.");
    }

    if (this.currentAmmo > 0 && this.shotsLeft > 0) {
      this.currentAmmo--;
      this.shotsLeft--;
      if (distance < this.maxRange) {
        return this.baseDamage;
      }
    }
    return 0;
  }

  /**
   * @return a string display of the Weapon and its Attachments
   */
  public String toString() {
    return "Mock Weapon: ";
  }
}

package weapon;

import exceptions.WeaponException;

public class Pistol extends GenericWeapon{

  public Pistol() {
 
    this.baseDamage = 1;
    this.maxRange = 50;
    this.rateOfFire = 2;
    this.maxAmmo = 10;
    this.shotsLeft = this.rateOfFire;
    this.currentAmmo = this.maxAmmo;

  }

  @Override
  public int fire(int distance) throws WeaponException {


    double mathDamage = (double)this.baseDamage*(double)(this.maxRange-distance+10.0)/(double)this.maxRange;
    double damage = Math.ceil(mathDamage);
      if (distance <= this.maxRange && distance > 0 && this.currentAmmo > 0 && this.currentAmmo <= this.maxAmmo) {
        this.currentAmmo-=1;
        this.shotsLeft-=1;
        return (int)damage;
      }
      else {throw new WeaponException(null);}
    
  }
  

  @Override
  public String toString() {
    String pistol = "Pistol";

    return pistol;
  }
}

package weapon;

import exceptions.WeaponException;

public class ChainGun extends GenericWeapon{

  public ChainGun() {
    this.baseDamage = 15; 
    this.maxRange = 60;  
    this.rateOfFire = 4;
    this.maxAmmo = 40;
    this.shotsLeft = rateOfFire;
    this.currentAmmo = maxAmmo; 
    }


  @Override
  public int fire(int distance) throws WeaponException {
    double mathDamage = (double)this.baseDamage*(double)distance/(double)this.maxRange;
    int damage = (int)Math.ceil(mathDamage);
      if (distance <= this.maxRange && distance > 0 && this.currentAmmo > 0 && this.currentAmmo <= this.maxAmmo) {
        this.currentAmmo-=1;
        this.shotsLeft-=1;
        return damage;
      }
      else {throw new WeaponException(null);}
      
  }

  @Override
  public String toString() {
    String chainGun = "ChainGun";
    return chainGun;
  }

}

package weapon;

import exceptions.WeaponException;

public class ChainGun extends GenericWeapon{
  private double damage = 0.0;
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

      if (distance <= maxRange && distance > 0 && this.currentAmmo > 0 && this.shotsLeft>0) {
        damage = (double)this.baseDamage*(double)distance/(double)this.maxRange;
        this.currentAmmo--;
        this.shotsLeft--;
        
      }
      else {throw new WeaponException(null);}
      
      return Double.valueOf(Math.floor(damage)).intValue();
      
  }

  @Override
  public String toString() {
    String chainGun = "ChainGun";
    return chainGun;
  }

}

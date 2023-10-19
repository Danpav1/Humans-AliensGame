package weapon;

import exceptions.WeaponException;

public class PlasmaCannon extends GenericWeapon{
private double damage = 0.0;
  public PlasmaCannon() {
    this.baseDamage = 50; 
    this.maxRange = 40;  
    this.rateOfFire = 1;
    this.maxAmmo = 4;
    this.shotsLeft = this.rateOfFire;
    this.currentAmmo = this.maxAmmo;
  }

  @Override
  public int fire(int distance) throws WeaponException {
      if (distance <= maxRange && distance > 0 && this.currentAmmo > 0 && this.shotsLeft>0) {
        damage = (double)this.baseDamage*(double)this.currentAmmo/(double)this.maxAmmo;
        this.currentAmmo--;
        this.shotsLeft--;
      }
      else {throw new WeaponException(null);}
      return Double.valueOf(Math.floor(damage)).intValue();
    
  }
  
  @Override
  public String toString() {
    String plasmaCannon = "PlasmaCannon";
    return plasmaCannon;
  }

}



package weapon;

import exceptions.WeaponException;

public class PlasmaCannon extends GenericWeapon{

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
    double mathDamage = (double)this.baseDamage*(double)this.currentAmmo/(double)this.maxAmmo;
    double damage = Math.ceil(mathDamage);
      if (distance <= this.maxRange && distance > 0 && this.currentAmmo > 0 && this.shotsLeft>0) {
        this.currentAmmo-=1;
        this.shotsLeft-=1;
        return (int)damage;
      }
      else {throw new WeaponException(null);}
    
  }
  
  @Override
  public String toString() {
    String plasmaCannon = "PlasmaCannon";
    return plasmaCannon;
  }

}



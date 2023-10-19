package weapon;

import exceptions.WeaponException;

public class Pistol extends GenericWeapon{
  private double damage = 0.0;

  public Pistol() {
 
    this.baseDamage = 10;
    this.maxRange = 50;
    this.rateOfFire = 2;
    this.maxAmmo = 10;
    this.shotsLeft = this.rateOfFire;
    this.currentAmmo = this.maxAmmo;

  }

  @Override
  public int fire(int distance) throws WeaponException {
    
      if (distance <= maxRange && distance > 0 && this.currentAmmo > 0 && this.shotsLeft>0) {
        damage = (double)this.baseDamage*((double)this.maxRange-(double)distance+10.0)/(double)this.maxRange;
        this.currentAmmo--;
        this.shotsLeft--;

      }
      else {throw new WeaponException(null);}
      return Double.valueOf(Math.floor(damage)).intValue();
  }
  

  @Override
  public String toString() {
    String pistol = "Pistol";

    return pistol;
  }
}

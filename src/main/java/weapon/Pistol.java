package weapon;

import exceptions.WeaponException;

public class Pistol extends GenericWeapon{
  
  public Pistol() {
    
  }

  @Override
  public int fire(int distance) throws WeaponException {
    baseDamage = 1; 
    maxRange = 50;  
    rateOfFire = 2;
    maxAmmo = 10;
    double damage = (double)baseDamage*((maxRange-distance+10)/maxRange);
    if (distance > maxRange || distance < 0) {
    return (int)damage;
    }
    else throw new WeaponException(null);
  }

  @Override
  public String toString() {
    String pistol = "Pistol";

    return pistol;
  }
}

package weapon;

import exceptions.WeaponException;

public class PlasmaCannon extends GenericWeapon{

  public PlasmaCannon() {
    
  }

  @Override
  public int fire(int distance) throws WeaponException {
    baseDamage = 50; 
    maxRange = 40;  
    rateOfFire = 1;
    maxAmmo = 4;
    double damage = (double)baseDamage*((maxRange-distance+10)/maxRange);
    if (distance > maxRange || distance < 0) {
    return (int)damage;
    }
    else throw new WeaponException(null);
  }
  
  @Override
  public String toString() {
    String plasmaCannon = "PlasmaCannon";
    return plasmaCannon;
  }

}



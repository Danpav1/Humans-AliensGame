package weapon;

import exceptions.WeaponException;

public class ChainGun extends GenericWeapon{

  public ChainGun() {
  }

  @Override
  public int fire(int distance) throws WeaponException {
    baseDamage = 15; 
    maxRange = 60;  
    rateOfFire = 4;
    maxAmmo = 40;
    double damage = (double)baseDamage*((maxRange-distance+10)/maxRange);
    if (distance > maxRange || distance < 0) {
    return (int)damage;
    }
    else throw new WeaponException(null);
  }

  @Override
  public String toString() {
    String chainGun = "ChainGun";
    return chainGun;
  }

}

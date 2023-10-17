package weapon;

import exceptions.AttachmentException;
import exceptions.WeaponException;
import gameplay.TimerObserver;

public class Stabilizer extends Attachment implements TimerObserver, Weapon {
  public Stabilizer(Weapon baseWeapon) throws AttachmentException {
    weapon = baseWeapon;
  }

  // A Stabilizer auto reloads if ammo is at 0 after firing A Stabilizer also
  // increases the Weapon's damage by 25%
  public int fire(int distance) throws WeaponException {
    // no ammo (reloads then returns 0 damage)
    if (weapon.getCurrentAmmo() <= 0) {
      weapon.reload();
      return 0;
    }
    // out of range (return 0 damage)
    if (weapon.getMaxRange() < distance) {
      return 0;
    }

    // always rounded DOWN
    return (int) (weapon.fire(distance) + (weapon.fire(distance) * .25));
  }

  @Override
  public String toString() {
    return weapon.toString() + "Stabilizer Attachment; ";
  }

}
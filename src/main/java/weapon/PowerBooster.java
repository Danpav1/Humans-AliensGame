package weapon;

import exceptions.AttachmentException;
import exceptions.WeaponException;
import gameplay.TimerObserver;

public class PowerBooster extends Attachment implements TimerObserver, Weapon {
 public PowerBooster(Weapon baseWeapon) throws AttachmentException {
   if (baseWeapon.getNumAttachments() < 2) {
     weapon = baseWeapon;
   } else {
     throw new AttachmentException("Weapon is full, cannot add more than two attachments.");
   }
   weapon = baseWeapon;
 }
 
@Override
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
  double output = (double) weapon.fire(distance) * (1 + (weapon.getCurrentAmmo() / weapon.getMaxAmmo()));
  return (int) output;
}

@Override
public String toString() {
  return weapon.toString() + "PowerBooster Attachment; ";
}

}

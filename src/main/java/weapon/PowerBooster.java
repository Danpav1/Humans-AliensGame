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

  double currentAmmo = (double) weapon.getCurrentAmmo();
  double maxAmmo = (double) weapon.getMaxAmmo();
  double damage = (double) weapon.fire(distance);
  double output = damage * (1.0 + (currentAmmo / maxAmmo));
  //double output = (double) weapon.fire(distance) * (1.0 + ((double) weapon.getCurrentAmmo() / (double) weapon.getMaxAmmo()));
  return (int) output;
}

@Override
public String toString() {
  return weapon.toString() + "PowerBooster Attachment; ";
}

}

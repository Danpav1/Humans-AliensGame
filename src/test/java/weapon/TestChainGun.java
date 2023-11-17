package weapon;

import static org.junit.Assert.assertEquals;

import exceptions.RecoveryRateException;
import lifeform.Alien;
import lifeform.Human;
import lifeform.LifeForm;
import org.junit.Test;

import exceptions.WeaponException;
import lifeform.MockLifeForm;

public class TestChainGun {

  @Test
  public void testDifferentDistanceGun() throws WeaponException {
    ChainGun weapon = new ChainGun();
    MockLifeForm bob = new MockLifeForm("bob", 40, 2);
    MockLifeForm joe = new MockLifeForm("joe", 150, 2);
    bob.pickUpWeapon(weapon);
    bob.attack(joe, 20);
    assertEquals(145, joe.getCurrentLifePoints());
    bob.attack(joe, 50);
    assertEquals(133, joe.getCurrentLifePoints());
    bob.attack(joe, 40);
    bob.attack(joe, 23);
    assertEquals(118, joe.getCurrentLifePoints());
  }

  @Test
  public void testChainGunWithNoAmmo() throws RecoveryRateException, WeaponException {
    ChainGun gun = new ChainGun();
    LifeForm human = new Human("bob", 10,0);
    LifeForm alien = new Alien("al",100);

    human.pickUpWeapon(gun);
    gun.currentAmmo = 0;

    assertEquals(0, gun.getCurrentAmmo());
    human.attack(alien, 2);
    assertEquals(100, alien.getCurrentLifePoints());
  }
}

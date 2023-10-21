package weapon;

import static org.junit.Assert.assertEquals;

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
}

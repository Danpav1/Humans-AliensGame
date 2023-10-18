package weapon;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.WeaponException;
import lifeform.MockLifeForm;

public class TestChainGun {

  @Test
  public void testDifferentDistancePistol() throws WeaponException {
    ChainGun weapon = new ChainGun();
    MockLifeForm bob = new MockLifeForm("bob", 40, 2);
    MockLifeForm joe = new MockLifeForm("joe",  20, 2);
    bob.pickUpWeapon(weapon);
    bob.attack(joe,20);
    assertEquals(15, joe.getCurrentLifePoints());
    bob.attack(joe,50);
    assertEquals(2, joe.getCurrentLifePoints());
  }

}

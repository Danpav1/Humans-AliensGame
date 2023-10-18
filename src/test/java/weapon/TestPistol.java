package weapon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exceptions.WeaponException;

import lifeform.MockLifeForm;

public class TestPistol {

  @Test
  public void testDifferentDistancePistol() throws WeaponException {
    Pistol weapon = new Pistol();
    MockLifeForm bob = new MockLifeForm("bob", 40, 2);
    MockLifeForm joe = new MockLifeForm("joe", 20, 2);
    bob.pickUpWeapon(weapon);
    bob.attack(joe, 20);
    assertEquals(19, joe.getCurrentLifePoints());
    bob.attack(joe, 50);
    assertEquals(18, joe.getCurrentLifePoints());

  }

}

package weapon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exceptions.WeaponException;
import gameplay.SimpleTimer;
import lifeform.MockLifeForm;

public class TestPlasmaCannon {

  @Test
  public void testDifferentDistanceCannon() throws WeaponException {
    SimpleTimer timer = new SimpleTimer();
    PlasmaCannon weapon = new PlasmaCannon();
    MockLifeForm bob = new MockLifeForm("bob", 40, 2);
    MockLifeForm joe = new MockLifeForm("joe", 150, 2);
    timer.addTimeObserver(weapon);
    bob.pickUpWeapon(weapon);
    bob.attack(joe, 20);
    assertEquals(100, joe.getCurrentLifePoints());
    timer.timeChanged();
    bob.attack(joe, 10);
    assertEquals(62, joe.getCurrentLifePoints());

  }

}

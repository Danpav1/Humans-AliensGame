package weapon;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.AttachmentException;
import exceptions.WeaponException;

public class TestPowerBooster {

  @Test
  public void testDamageCalculation() throws AttachmentException, WeaponException {
    //damage * ( 1 + (currentAmmo / maxAmmo))
    //10 * ( 1 + (5 / 10) = 10 * 1.5 = 15
    PowerBooster b = new PowerBooster(new MockWeapon(10, 10, 10, 10));
    b.fire(5);
    b.fire(5);
    b.fire(5);
    b.fire(5);
    b.fire(5);
    assertEquals(5, b.getCurrentAmmo());
    assertEquals(15, b.fire(5));
  }
  
  @Test
  public void testDamageCalculation2() throws AttachmentException, WeaponException {
    PowerBooster b = new PowerBooster(new MockWeapon(7, 10, 10, 10));
    //7 * (1 + (3 / 10)) = 9.1 = 9
    b.fire(5);
    b.fire(5);
    b.fire(5);
    b.fire(5);
    b.fire(5);
    b.fire(5);
    b.fire(5);
    assertEquals(3, b.getCurrentAmmo());
    assertEquals(9, b.fire(5));
  }
  
  @Test
  public void testAttachmentException() throws AttachmentException {
    
    boolean exception1Caught = false;

    try {
      PowerBooster b = new PowerBooster(new PowerBooster(new PowerBooster(new MockWeapon(10, 10, 10, 10))));
    } catch (AttachmentException e) {
      exception1Caught = true;
    }

    assertTrue(exception1Caught);
  }
}
  /**
  
  @Test
  public void chainGunPowerBooster() throws AttachmentException, WeaponException {
    ChainGun c = new ChainGun();
    assertEquals(2, c.fire(5));
    PowerBooster b = new PowerBooster(new ChainGun());
    assertEquals(2, b.fire(5));
  }
  @Test
  public void pistolScopePowerBooster() {fail();}
  @Test
  public void chainGunPowerBoosterPowerBooster() {fail();}
  @Test
  public void plasmaCannonStabilizerPowerBooster() {fail();}
**/

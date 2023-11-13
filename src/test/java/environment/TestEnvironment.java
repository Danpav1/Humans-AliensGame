package environment;

import static org.junit.Assert.*;

import com.sun.jdi.event.MonitorContendedEnteredEvent;
import commands.MoveCommand;
import exceptions.EnvironmentException;
import exceptions.RecoveryRateException;
import lifeform.Alien;
import lifeform.Human;
import org.junit.Test;

import lifeform.LifeForm;
import lifeform.MockLifeForm;

import recovery.RecoveryNone;
import weapon.Weapon;
import weapon.MockWeapon;

/**
 * The test cases for the Environment class
 */
public class TestEnvironment {
  final double DELTA = 0.01;

  /*
   * Lab 6 tests begin
   */

  /**
   * Tests if aliens and humans move north correctly
   */
  @Test
  public void testMovesSouth() throws RecoveryRateException {
    //Initializes a new environment, a human, and an alien
    Environment environment = Environment.getEnvironment(5, 5);
    Human bob = new Human("bob", 11, 10);
    Alien alien1 = new Alien("alien", 10, new RecoveryNone());
    //Places the human and alien on the board with no obstacles
    environment.addLifeForm(bob, 1, 2);
    environment.addLifeForm(alien1, 1, 3);
    //Changes the LifeForms' directions to south
    bob.changeDirectionSouth();
    alien1.changeDirectionSouth();
    //Moves the human and alien north by their respective maxSpeed
    boolean humanSuccess = environment.move(bob);
    boolean alienSuccess = environment.move(alien1);
    //Tests if the human moved to the correct place
    assertTrue(humanSuccess);
    assertEquals(4, bob.getRow());
    assertEquals(2, bob.getCol());
    //Tests if the alien moved to the correct place
    assertTrue(alienSuccess);
    assertEquals(3, alien1.getRow());
    assertEquals(3, alien1.getCol());
    //Sets human's and alien's location next to the northern border
    environment.updateGridLocation(bob, 4, 2);
    environment.updateGridLocation(alien1, 4, 3);
    //Moves human and alien north again
    humanSuccess = environment.move(bob);
    alienSuccess = environment.move(alien1);
    //Tests if human didn't move due to going out of bounds
    assertFalse(humanSuccess);
    assertEquals(4, bob.getRow());
    assertEquals(2, bob.getCol());
    //Tests if alien didn't move due to going out of bounds
    assertFalse(alienSuccess);
    assertEquals(4, alien1.getRow());
    assertEquals(3, alien1.getCol());
    //Sets human's location directly south of alien
    environment.updateGridLocation(bob, 1, 3);
    environment.updateGridLocation(alien1, 2, 3);
    //Moves human north
    humanSuccess = environment.move(bob);
    //Tests if human moved north through alien correctly
    assertTrue(humanSuccess);
    assertEquals(4, bob.getRow());
    assertEquals(3, bob.getCol());
    //Sets alien's location directly south of human
    environment.updateGridLocation(bob, 2, 3);
    environment.updateGridLocation(alien1, 1, 3);
    //Moves alien north
    alienSuccess = environment.move(alien1);
    //Tests if alien moved north through human correctly
    assertTrue(alienSuccess);
    assertEquals(3, alien1.getRow());
    assertEquals(3, alien1.getCol());
    //Sets human's location 3 spots south of alien
    environment.updateGridLocation(bob, 0, 3);
    environment.updateGridLocation(alien1, 3, 3);
    //Moves human north
    humanSuccess = environment.move(bob);
    //Tests if human moved north up to alien correctly
    assertTrue(humanSuccess);
    assertEquals(2, bob.getRow());
    assertEquals(3, bob.getCol());
    //Initializes another alien
    Alien alien2 = new Alien("alien2", 10, new RecoveryNone());
    environment.addLifeForm(alien2, 3, 2);
    //Moves alien1 directly south of alien2
    environment.updateGridLocation(alien1, 2, 2);
    //Moves human underneath alien1 and alien2 so there is a one space gap
    environment.updateGridLocation(bob, 0, 2);
    //Moves human north
    humanSuccess = environment.move(bob);
    //Tests if human moves north correctly
    assertTrue(humanSuccess);
    assertEquals(1, bob.getRow());
    assertEquals(2, bob.getCol());

    Environment.removeEnvironment();
  }

  /**
   * Tests if aliens and humans move east correctly
   */
  @Test
  public void testMovesEast() throws RecoveryRateException {
    //Initializes a new environment, a human, and an alien
    Environment environment = Environment.getEnvironment(5, 5);
    Human bob = new Human("bob", 10, 10);
    Alien alien1 = new Alien("alien", 10, new RecoveryNone());
    //Places the human and alien on the board with no obstacles
    environment.addLifeForm(bob, 2, 1);
    environment.addLifeForm(alien1, 3, 1);
    //Changes direction of human and alien to east
    bob.changeDirectionEast();
    alien1.changeDirectionEast();
    //Moves the human and alien east by their respective maxSpeed
    boolean humanSuccess = environment.move(bob);
    boolean alienSuccess = environment.move(alien1);
    //Tests if the human moved to the correct place
    assertTrue(humanSuccess);
    assertEquals(2, bob.getRow());
    assertEquals(4, bob.getCol());
    //Tests if the alien moved to the correct place
    assertTrue(alienSuccess);
    assertEquals(3, alien1.getRow());
    assertEquals(3, alien1.getCol());
    //Sets human's and alien's location next to the eastern border
    environment.updateGridLocation(bob, 2, 4);
    environment.updateGridLocation(alien1, 3, 4);
    //Moves human and alien east again
    humanSuccess = environment.move(bob);
    alienSuccess = environment.move(alien1);
    //Tests if human didn't move due to going out of bounds
    assertFalse(humanSuccess);
    assertEquals(2, bob.getRow());
    assertEquals(4, bob.getCol());
    //Tests if alien didn't move due to going out of bounds
    assertFalse(alienSuccess);
    assertEquals(3, alien1.getRow());
    assertEquals(4, alien1.getCol());
    //Sets human's location directly west of alien
    environment.updateGridLocation(bob, 3, 1);
    environment.updateGridLocation(alien1, 3, 2);
    //Moves human east
    humanSuccess = environment.move(bob);
    //Tests if human moved east through alien correctly
    assertTrue(humanSuccess);
    assertEquals(3, bob.getRow());
    assertEquals(4, bob.getCol());
    //Sets alien's location directly west of human
    environment.updateGridLocation(bob, 3, 2);
    environment.updateGridLocation(alien1, 3, 1);
    //Moves alien east
    alienSuccess = environment.move(alien1);
    //Tests if alien moved east through human correctly
    assertTrue(alienSuccess);
    assertEquals(3, alien1.getRow());
    assertEquals(3, alien1.getCol());
    //Sets human's location 3 spots west of alien
    environment.updateGridLocation(bob, 3, 0);
    environment.updateGridLocation(alien1, 3, 3);
    //Moves human east
    humanSuccess = environment.move(bob);
    //Tests if human moved east up to alien correctly
    assertTrue(humanSuccess);
    assertEquals(3, bob.getRow());
    assertEquals(2, bob.getCol());
    //Initializes another alien
    Alien alien2 = new Alien("alien2", 10, new RecoveryNone());
    environment.addLifeForm(alien2, 2, 3);
    alien2.changeDirectionEast();
    //Moves alien1 directly west of alien2
    environment.updateGridLocation(alien1, 2, 2);
    //Moves human beside alien1 and alien2 so there is a one space gap
    environment.updateGridLocation(bob, 2, 0);
    //Moves human east
    humanSuccess = environment.move(bob);
    //Tests if human moves east correctly
    assertTrue(humanSuccess);
    assertEquals(2, bob.getRow());
    assertEquals(1, bob.getCol());

    Environment.removeEnvironment();
  }

  /**
   * Tests if human and alien move south correctly
   */
  @Test
  public void testMovesNorth() throws RecoveryRateException {
    //Initializes a new environment, a human, and an alien
    Environment environment = Environment.getEnvironment(5, 5);
    Human bob = new Human("bob", 10, 10);
    Alien alien1 = new Alien("alien", 10, new RecoveryNone());
    //Places the human and alien on the board with no obstacles
    environment.addLifeForm(bob, 4, 2);
    environment.addLifeForm(alien1, 4, 3);
    //Changes human and alien direction to south
    bob.changeDirectionNorth();
    alien1.changeDirectionNorth();
    //Moves the human and alien south by their respective maxSpeed
    boolean humanSuccess = environment.move(bob);
    boolean alienSuccess = environment.move(alien1);
    //Tests if the human moved to the correct place
    assertTrue(humanSuccess);
    assertEquals(1, bob.getRow());
    assertEquals(2, bob.getCol());
    //Tests if the alien moved to the correct place
    assertTrue(alienSuccess);
    assertEquals(2, alien1.getRow());
    assertEquals(3, alien1.getCol());
    //Sets human's and alien's location next to the southern border
    environment.updateGridLocation(bob, 0, 2);
    environment.updateGridLocation(alien1, 0, 3);
    //Moves human and alien south again
    humanSuccess = environment.move(bob);
    alienSuccess = environment.move(alien1);
    //Tests if human didn't move due to going out of bounds
    assertFalse(humanSuccess);
    assertEquals(0, bob.getRow());
    assertEquals(2, bob.getCol());
    //Tests if alien didn't move due to going out of bounds
    assertFalse(alienSuccess);
    assertEquals(0, alien1.getRow());
    assertEquals(3, alien1.getCol());
    //Sets human's location directly north of alien
    environment.updateGridLocation(bob, 4, 3);
    environment.updateGridLocation(alien1, 3, 3);
    //Moves human south
    humanSuccess = environment.move(bob);
    //Tests if human moved south through alien correctly
    assertTrue(humanSuccess);
    assertEquals(1, bob.getRow());
    assertEquals(3, bob.getCol());
    //Sets alien's location directly north of human
    environment.updateGridLocation(bob, 3, 3);
    environment.updateGridLocation(alien1, 4, 3);
    //Moves alien south
    alienSuccess = environment.move(alien1);
    //Tests if alien moved south through human correctly
    assertTrue(alienSuccess);
    assertEquals(2, alien1.getRow());
    assertEquals(3, alien1.getCol());
    //Sets human's location 3 spots north of alien
    environment.updateGridLocation(bob, 3, 3);
    environment.updateGridLocation(alien1, 0, 3);
    //Moves human south
    humanSuccess = environment.move(bob);
    //Tests if human moved south down to alien correctly
    assertTrue(humanSuccess);
    assertEquals(1, bob.getRow());
    assertEquals(3, bob.getCol());
    //Initializes another alien
    Alien alien2 = new Alien("alien2", 10, new RecoveryNone());
    environment.addLifeForm(alien2, 0, 2);
    alien2.changeDirectionNorth();
    //Moves alien1 directly north of alien2
    environment.updateGridLocation(alien1, 1, 2);
    //Moves human above alien1 and alien2 so there is a one space gap
    environment.updateGridLocation(bob, 3, 2);
    //Moves human south
    humanSuccess = environment.move(bob);
    //Tests if human moves south correctly
    assertTrue(humanSuccess);
    assertEquals(2, bob.getRow());
    assertEquals(2, bob.getCol());

    Environment.removeEnvironment();
  }

  /**
   * Tests if humans and aliens move west correctly
   */
  @Test
  public void testMovesWest() throws RecoveryRateException {
    //Initializes a new environment, a human, and an alien
    Environment environment = Environment.getEnvironment(5, 5);
    Human bob = new Human("bob", 10, 10);
    Alien alien1 = new Alien("alien", 10, new RecoveryNone());
    //Places the human and alien on the board with no obstacles
    environment.addLifeForm(bob, 2, 4);
    environment.addLifeForm(alien1, 3, 4);
    //Changes direction of human and alien to west
    bob.changeDirectionWest();
    alien1.changeDirectionWest();
    //Moves the human and alien west by their respective maxSpeed
    boolean humanSuccess = environment.move(bob);
    boolean alienSuccess = environment.move(alien1);
    //Tests if the human moved to the correct place
    assertTrue(humanSuccess);
    assertEquals(2, bob.getRow());
    assertEquals(1, bob.getCol());
    //Tests if the alien moved to the correct place
    assertTrue(alienSuccess);
    assertEquals(3, alien1.getRow());
    assertEquals(2, alien1.getCol());
    //Sets human's and alien's location next to the western border
    environment.updateGridLocation(bob, 2, 0);
    environment.updateGridLocation(alien1, 3, 0);
    //Moves human and alien west again
    humanSuccess = environment.move(bob);
    alienSuccess = environment.move(alien1);
    //Tests if human didn't move due to going out of bounds
    assertFalse(humanSuccess);
    assertEquals(2, bob.getRow());
    assertEquals(0, bob.getCol());
    //Tests if alien didn't move due to going out of bounds
    assertFalse(alienSuccess);
    assertEquals(3, alien1.getRow());
    assertEquals(0, alien1.getCol());
    //Sets human's location directly east of alien
    environment.updateGridLocation(bob, 3, 3);
    environment.updateGridLocation(alien1, 3, 2);
    //Moves human west
    humanSuccess = environment.move(bob);
    //Tests if human moved west through alien correctly
    assertTrue(humanSuccess);
    assertEquals(3, bob.getRow());
    assertEquals(0, bob.getCol());
    //Sets alien's location directly east of human
    environment.updateGridLocation(bob, 3, 2);
    environment.updateGridLocation(alien1, 3, 3);
    //Moves alien west
    alienSuccess = environment.move(alien1);
    //Tests if alien moved west through human correctly
    assertTrue(alienSuccess);
    assertEquals(3, alien1.getRow());
    assertEquals(1, alien1.getCol());
    //Sets human's location 3 spots east of alien
    environment.updateGridLocation(bob, 3, 3);
    environment.updateGridLocation(alien1, 3, 0);
    //Moves human west
    humanSuccess = environment.move(bob);
    //Tests if human moved west up to alien correctly
    assertTrue(humanSuccess);
    assertEquals(3, bob.getRow());
    assertEquals(1, bob.getCol());
    //Initializes another alien
    Alien alien2 = new Alien("alien2", 10, new RecoveryNone());
    environment.addLifeForm(alien2, 2, 1);
    alien2.changeDirectionWest();
    //Moves alien1 directly east of alien2
    environment.updateGridLocation(alien1, 2, 0);
    //Moves human beside alien1 and alien2 so there is a one space gap
    environment.updateGridLocation(bob, 2, 3);
    //Moves human west
    humanSuccess = environment.move(bob);
    //Tests if human moves west correctly
    assertTrue(humanSuccess);
    assertEquals(2, bob.getRow());
    assertEquals(2, bob.getCol());

    Environment.removeEnvironment();
  }

  /**
   * Tests if aliens and humans move correctly along/near the border
   */
  @Test
  public void testMovingOnEdge() throws RecoveryRateException {
    //Initializes a new environment, a human, and an alien
    Environment environment = Environment.getEnvironment(5, 5);
    Human bob = new Human("bob", 10, 10);
    Alien alien1 = new Alien("alien", 10, new RecoveryNone());
    //Places the Human and Alien on the board, with Human being 2 away from northern border
    // and Alien being 1 away
    environment.addLifeForm(bob, 2, 2);
    environment.addLifeForm(alien1, 3, 3);
    //Changes direction of LifeForms to north
    bob.changeDirectionSouth();
    alien1.changeDirectionSouth();
    //Moves the LifeForms north
    boolean humanSuccess = environment.move(bob);
    boolean alienSuccess = environment.move(alien1);
    //Tests if Human moved correctly
    assertTrue(humanSuccess);
    assertEquals(4, bob.getRow());
    assertEquals(2, bob.getCol());
    //Tests if Alien moved correctly
    assertTrue(alienSuccess);
    assertEquals(4, alien1.getRow());
    assertEquals(3, alien1.getCol());
    //Places Human 1 away from northern border
    environment.updateGridLocation(bob, 3, 2);
    //Moves Human north
    humanSuccess = environment.move(bob);
    //Tests if Human moved correctly
    assertTrue(humanSuccess);
    assertEquals(4, bob.getRow());
    assertEquals(2, bob.getCol());
    //Changes LifeForms direction to east
    bob.changeDirectionEast();
    alien1.changeDirectionEast();
    //Places Human 2 away from eastern border
    environment.updateGridLocation(bob, 2, 2);
    //Places Alien 1 away from eastern border
    environment.updateGridLocation(alien1, 3, 3);
    //Moves Human and Alien east
    humanSuccess = environment.move(bob);
    alienSuccess = environment.move(alien1);
    //Tests if Human moved correctly
    assertTrue(humanSuccess);
    assertEquals(2, bob.getRow());
    assertEquals(4, bob.getCol());
    //Tests if Alien moved correctly
    assertTrue(alienSuccess);
    assertEquals(3, alien1.getRow());
    assertEquals(4, alien1.getCol());
    //Places Human 1 away from eastern border
    environment.updateGridLocation(bob, 2, 3);
    //Moves Human east
    humanSuccess = environment.move(bob);
    //Tests if Human moved correctly
    assertTrue(humanSuccess);
    assertEquals(2, bob.getRow());
    assertEquals(4, bob.getCol());
    //Changes LifeForms direction to south
    bob.changeDirectionNorth();
    alien1.changeDirectionNorth();
    //Places Human 2 away from southern border
    environment.updateGridLocation(bob, 2, 1);
    //Places Alien 1 away from southern border
    environment.updateGridLocation(alien1, 1, 3);
    //Moves Alien and Human south
    humanSuccess = environment.move(bob);
    alienSuccess = environment.move(alien1);
    //Tests if Human moves correctly
    assertTrue(humanSuccess);
    assertEquals(0, bob.getRow());
    assertEquals(1, bob.getCol());
    //Tests if Alien moves correctly
    assertTrue(alienSuccess);
    assertEquals(0, alien1.getRow());
    assertEquals(3, alien1.getCol());
    //Places Human 1 away from southern border
    environment.updateGridLocation(bob, 1, 1);
    //Moves Human south
    humanSuccess = environment.move(bob);
    //Tests if Human moves correctly
    assertTrue(humanSuccess);
    assertEquals(0, bob.getRow());
    assertEquals(1, bob.getCol());
    //Changes LifeForms direction to west
    bob.changeDirectionWest();
    alien1.changeDirectionWest();
    //Places Human 2 away from western border
    environment.updateGridLocation(bob, 2, 2);
    //Places Alien 1 away from western border
    environment.updateGridLocation(alien1, 3, 1);
    //Moves LifeForms west
    humanSuccess = environment.move(bob);
    alienSuccess = environment.move(alien1);
    //Tests if Human moves correctly
    assertTrue(humanSuccess);
    assertEquals(2, bob.getRow());
    assertEquals(0, bob.getCol());
    //Tests if Alien moves correctly
    assertTrue(alienSuccess);
    assertEquals(3, alien1.getRow());
    assertEquals(0, alien1.getCol());
    //Places Human 1 away from western border
    environment.updateGridLocation(bob, 2, 1);
    //Moves Human west
    humanSuccess = environment.move(bob);
    //Tests if Human moves correctly
    assertTrue(humanSuccess);
    assertEquals(2, bob.getRow());
    assertEquals(0, bob.getCol());

    Environment.removeEnvironment();
  }

  /**
   * Why is testInvoker failing
   */
  @Test
  public void testMovementOfSingleCell() {
    LifeForm bob = new MockLifeForm();
    MoveCommand moveCommand = new MoveCommand(bob);
    Environment environment = Environment.getEnvironment(5, 5);

    environment.addLifeForm(bob, 1, 1);

    bob.changeDirectionSouth();

    assertTrue(environment.move(bob));

    Environment.removeEnvironment();
  }

  /*
   * Lab 6 tests end; Lab 5 tests begin ------------------------------------------------------------
   */

  /**
   * Tests that the Environment is a singleton
   */
  @Test
  public void testInitializationSingleton() {
    Environment environment1 = Environment.getEnvironment(2, 3);
    Environment environment2 = Environment.getEnvironment(1, 1);

    assertEquals(environment2, environment1);

    Environment.removeEnvironment();
  }

  /**
   * Tests that you can get the number of rows and columns
   */
  @Test
  public void testInitializationSize() {
    Environment environment = Environment.getEnvironment(4, 5);

    assertEquals(4, environment.getNumRows());
    assertEquals(5, environment.getNumCols());

    Environment.removeEnvironment();
  }

  /**
   * Tests that weapons can be added to the Environment properly
   */
  @Test
  public void testCanAddWeaponToCell() {
    Environment environment = Environment.getEnvironment(3, 5);
    Weapon weapon = new MockWeapon();
    Weapon weapon2 = new MockWeapon();
    Weapon weapon3 = new MockWeapon();

    assertFalse(environment.addWeapon(weapon, -1, 5));

    environment.addWeapon(weapon, 2, 4);

    boolean hasWeapon = false;
    for (Weapon target : environment.getWeapons(2, 4)) {
      if (target == weapon) {
        hasWeapon = true;
      }
    }
    assertTrue(hasWeapon);

    assertFalse(environment.addWeapon(weapon, 2, 4));
    assertTrue(environment.addWeapon(weapon2, 2, 4));
    assertFalse(environment.addWeapon(weapon3, 2, 4));

    Environment.removeEnvironment();
  }

  /**
   * Tests that Weapons can be removed from the Environment
   */
  @Test
  public void testCanRemoveWeaponFromCell() {
    Environment environment = Environment.getEnvironment(5, 6);
    Weapon weapon1 = new MockWeapon();
    Weapon weapon2 = new MockWeapon();

    // tests that removeWeapon() fails gracefully when out of bounds
    environment.removeWeapon(weapon1, -1, 6);

    // tests that removeWeapon() fails gracefully when Weapon not in Cell
    environment.removeWeapon(weapon1, 3, 3);

    environment.addWeapon(weapon1, 3, 3);
    environment.addWeapon(weapon2, 3, 3);

    assertEquals(2, countWeapons(environment.getWeapons(3, 3)));

    environment.removeWeapon(weapon1, 3, 3);

    assertEquals(1, countWeapons(environment.getWeapons(3, 3)));

    environment.removeWeapon(weapon2, 3, 3);

    assertEquals(0, countWeapons(environment.getWeapons(3, 3)));

    Environment.removeEnvironment();
  }

  /**
   * Tests that getDistance works within the same row
   */
  @Test
  public void testGetDistanceInRow() throws EnvironmentException {
    Environment environment = Environment.getEnvironment(1, 6);
    LifeForm thing1 = new MockLifeForm("Thing 1", 1);
    LifeForm thing2 = new MockLifeForm("Thing 2", 1);

    environment.addLifeForm(thing1, 0, 0);
    environment.addLifeForm(thing2, 0, 5);

    assertEquals(25.0, environment.getDistance(thing1, thing2), DELTA);

    Environment.removeEnvironment();
  }

  /**
   * Tests that getDistance() works within the same column
   */
  @Test
  public void testGetDistanceInColumn() throws EnvironmentException {
    Environment environment = Environment.getEnvironment(8, 1);
    LifeForm thing1 = new MockLifeForm("Thing 1", 1);
    LifeForm thing2 = new MockLifeForm("Thing 2", 1);

    environment.addLifeForm(thing1, 0, 0);
    environment.addLifeForm(thing2, 7, 0);

    assertEquals(35.0, environment.getDistance(thing1, thing2), DELTA);

    Environment.removeEnvironment();
  }

  /**
   * Tests that getDistance() works regardless of location in the Environment
   */
  @Test
  public void testGetDistance() throws EnvironmentException {
    Environment environment = Environment.getEnvironment(6, 13);
    LifeForm thing1 = new MockLifeForm("Thing 1", 1);
    LifeForm thing2 = new MockLifeForm("Thing 2", 1);

    environment.addLifeForm(thing1, 2, 3);
    environment.addLifeForm(thing2, 5, 7);

    assertEquals(25.0, environment.getDistance(thing1, thing2), DELTA);

    environment.removeLifeForm(2, 3);
    environment.removeLifeForm(5, 7);

    environment.addLifeForm(thing1, 0, 0);
    environment.addLifeForm(thing2, 5, 12);

    assertEquals(65.0, environment.getDistance(thing1, thing2), DELTA);

    Environment.removeEnvironment();
  }

  /**
   * Tests that, if passed an invalid coordinate pair, getDistance will throw an exception
   */
  @Test
  public void testGetDistanceThrowsException() throws EnvironmentException {
    Environment environment = Environment.getEnvironment(1, 6);
    LifeForm thing1 = new MockLifeForm("Thing 1", 1);
    LifeForm thing2 = new MockLifeForm("Thing 2", 1);

    environment.addLifeForm(thing1, 0, 0);

    boolean exceptionCaught = false;

    try {
      environment.getDistance(thing1, thing2);
    } catch (EnvironmentException e) {
      exceptionCaught = true;
    }

    assertTrue(exceptionCaught);

    Environment.removeEnvironment();
  }

  /**
   * Helper function that counts the number of Weapons in an Environment's getWeapons() return
   *
   * @param weapons the array of Weapons returned by getWeapons()
   * @return the number of weapons in the array
   */
  int countWeapons(Weapon[] weapons) {
    int numWeapons = 0;
    for (Weapon weapon : weapons) {
      if (weapon != null) {
        numWeapons++;
      }
    }
    return numWeapons;
  }

  /*
   * Lab 5 tests end; Lab 4 tests begin ------------------------------------------------------------
   */

  /**
   * Tests that the environment can be initialized and that its
   * contents exist
   */
  @Test
  public void testInitialization() {
    Environment environment = Environment.getEnvironment(1, 1);
    assertNull(environment.getLifeForm(0, 0));

    Environment.removeEnvironment();
  }

  /**
   * Tests that LifeForms can be added and removed from the
   * Environment
   */
  @Test
  public void testAddAndGetLifeForm() {
    Environment environment = Environment.getEnvironment(2, 3);
    LifeForm charlie = new MockLifeForm("Charlie", 30);

    environment.addLifeForm(charlie, 0, 1);
    assertEquals(charlie, environment.getLifeForm(0, 1));

    Environment.removeEnvironment();
  }

  /**
   * Tests that the Environment will prevent the user from crashing the program
   * by trying to access a cell outside the Environment
   */
  @Test
  public void testInvalidCell() {
    Environment environment = Environment.getEnvironment(4, 3);
    LifeForm steve = new MockLifeForm("Steve", 700);

    boolean success = environment.addLifeForm(steve, 4, 3);
    assertFalse(success);

    assertNotEquals(steve, environment.getLifeForm(4, 3));
    assertNull(environment.getLifeForm(4, 3));

    // to ensure that removeLifeForm does not crash the program if out of bounds
    environment.removeLifeForm(4, 3);

    Environment.removeEnvironment();
  }

  /**
   * Tests that LifeForms can be removed from the Environment
   */
  @Test
  public void testRemoveLifeForm() {
    Environment environment = Environment.getEnvironment(1, 1);
    LifeForm craig = new MockLifeForm("Craig", 50);

    environment.addLifeForm(craig, 0, 0);
    assertEquals(craig, environment.getLifeForm(0, 0));

    environment.removeLifeForm(0, 0);
    assertNull(environment.getLifeForm(0, 0));

    Environment.removeEnvironment();
  }
}

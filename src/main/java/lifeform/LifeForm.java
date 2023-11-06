package lifeform;

import environment.Environment;
import exceptions.WeaponException;
import weapon.Weapon;

/**
 * Keeps track of the information associated with a simple life form.
 * Also provides the functionality related to the life form.
 * Weapons functionality added by Gavin Albright
 */
public abstract class LifeForm {
  private final String myName;
  protected int currentLifePoints;
  protected int attackStrength;
  protected int column;
  protected int row;

  protected Weapon weapon;
  protected String currentDirection = "north";
  protected int maxSpeed;

  /**
   * Create a LifeForm without specified strength
   *
   * @param name   the name of the life form
   * @param points the current starting life points of the life form
   */
  public LifeForm(String name, int points) {
    this(name, points, 1);
  }

  /**
   * Create a LifeForm with specified strength
   *
   * @param name     the name of the life form
   * @param points   the current starting life points of the life form
   * @param strength the attack strength of the life form
   */
  public LifeForm(String name, int points, int strength) {
    this.myName = name;
    this.currentLifePoints = points;
    this.attackStrength = strength;

    this.row = -1;
    this.column = -1;
  }

  /**
   * Causes a LifeForm to "attack" another LifeForm. The passed LifeForm's health is
   * lowered by the called LifeForm's attackStrength.
   *
   * @param opponent the LifeForm to be attacked
   */
  public void attack(LifeForm opponent, int distance) throws WeaponException {
    int damage = 0;

    if (hasWeapon() && this.weapon.getCurrentAmmo() > 0) {
      damage = this.weapon.fire(distance);
    } else if (distance <= 5) {
      damage = this.attackStrength;
    }

    if (this.currentLifePoints != 0) {
      opponent.takeHit(damage);
    }
  }

  /**
   * Drops the weapon that the LifeForm is holding and returns it
   *
   * @return the weapon the LifeForm was holding, null if it wasn't holding anything
   */
  public Weapon dropWeapon() {
    Weapon returnVal = this.weapon;
    this.weapon = null;
    return returnVal;
  }

  /**
   * @return the attackStrength of the LifeForm
   */
  public int getAttackStrength() {
    return this.attackStrength;
  }

  /**
   * @return the column of the Environment that the LifeForm resides in;
   * -1, if not in an Environment
   */
  public int getCol() {
    return this.column;
  }

  /**
   * @return the amount of current life points the life form has
   */
  public int getCurrentLifePoints() {
    return currentLifePoints;
  }

  /**
   * @return the name of the life form
   */
  public String getName() {
    return myName;
  }

  /**
   * @return the row of the Environment that the LifeForm resides in;
   * -1, if not in an Environment
   */
  public int getRow() {
    return this.row;
  }

  /**
   * Determines whether the LifeForm is holding a weapon
   *
   * @return true, if the LifeForm is holding a weapon, false otherwise
   */
  boolean hasWeapon() {
    return this.weapon != null;
  }

  /**
   * Picks up a weapon if the LifeForm is not already holding one
   *
   * @param weapon the weapon for the LifeForm to pick up
   * @return true, if the appointed weapon was picked up, false otherwise
   */
  public boolean pickUpWeapon(Weapon weapon) {
    if (this.hasWeapon()) {
      return false;
    } else {
      this.weapon = weapon;
      return true;
    }
  }

  /**
   * Getter for the weapon field
   * @return the currently held weapon, null if there is none
   */
  public Weapon getWeapon() {
    return this.weapon;
  }

  /**
   * Used by the Environment to set the location of a LifeForm for reference
   *
   * @param row the specified row of the Environment
   * @param col the specified column of the Environment
   */
  public void setLocation(int row, int col) {
    if (row >= 0 && col >= 0) {
      this.row = row;
      this.column = col;
    }
  }

  /**
   * Lowers the LifeForm's currentLifePoints by the given number. Will not allow the
   * currentLifePoints to fall below zero.
   *
   * @param damage the number of points to damage the LifeForm by
   */
  void takeHit(int damage) {
    int newLifePoints = this.currentLifePoints - damage;

    this.currentLifePoints = Math.max(0, newLifePoints);
  }

  public String getCurrentDirection() {
    return this.currentDirection;
  }

  public int getMaxSpeed() {
    return this.maxSpeed;
  }

  public void changeDirectionNorth() {
    this.currentDirection = "north";
  }

  public void changeDirectionEast() {
    this.currentDirection = "east";
  }

  public void changeDirectionSouth() {
    this.currentDirection = "south";
  }

  public void changeDirectionWest() {
    this.currentDirection = "west";
  }
}

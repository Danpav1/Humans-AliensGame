package environment;

import lifeform.LifeForm;

import weapon.Weapon;

/**
 * A Cell that can hold a LifeForm
 */
public class Cell {

  private LifeForm lifeForm;

  private Weapon[] weapons = new Weapon[2];

  /**
   * Tries to add the LifeForm to the Cell. Will not add if a
   * LifeForm is already present
   *
   * @param entity the LifeForm held in the cell
   *
   * @return true if the LifeForm was added to the Cell, false otherwise
   */
  public boolean addLifeForm(LifeForm entity) {
    if (this.lifeForm != null) {
      return false;
    }

    this.lifeForm = entity;

    return true;
  }

  /**
   * Tries to add a Weapon to the most available empty field. Returns false
   * if the operation cannot be done.
   *
   * @param weapon the Weapon to be added to the Cell
   *
   * @return true, if the operation was a success; false, otherwise
   */
  public boolean addWeapon(Weapon weapon) {
    if (this.weapons[0] == weapon || this.weapons[1] == weapon) {
      return false;
    }

    if (this.weapons[0] != null) {
      if (this.weapons[1] != null) {
        return false;
      }
      this.weapons[1] = weapon;
      return true;
    }
    this.weapons[0] = weapon;
    return true;
  }

  /**
   * @return the LifeForm in this Cell
   */
  public LifeForm getLifeForm() {
    return this.lifeForm;
  }

  /**
   * Accessor for weapon1
   *
   * @return the weapon in weapon1
   */
  public Weapon getWeapon1() {
    return this.weapons[0];
  }

  /**
   * Accessor for weapon2
   *
   * @return the weapon in weapon2
   */
  public Weapon getWeapon2() {
    return this.weapons[1];
  }

  /**
   * Counts the number of Weapons currently held in the Cell
   *
   * @return the number of Weapons in the Cell
   */
  public int getWeaponsCount() {
    int weaponsCount = 0;

    for (Weapon weapon : this.weapons) {
      if (weapon != null) {
        weaponsCount++;
      }
    }

    return weaponsCount;
  }

  /**
   * Removes any LifeForm from this Cell
   */
  public void removeLifeForm() {
    this.lifeForm = null;
  }

  /**
   * Tries to remove a specified Weapon from the Cell. Returns null if it fails.
   *
   * @param weapon the Weapon to remove from the Cell
   *
   * @return the Weapon requested; null, if the requested Weapon isn't in the Cell
   */
  public Weapon removeWeapon(Weapon weapon) {
    for (int i = 0; i < 2; i++) {
      if (weapon == this.weapons[i]) {
        this.weapons[i] = null;
        return weapon;
      }
    }
    return null;
  }
}

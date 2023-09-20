package environment;

import lifeform.LifeForm;

/**
 * A Cell that can hold a LifeForm
 */
public class Cell {

  private LifeForm lifeForm;

  /**
   * @return the LifeForm in this Cell
   */
  public LifeForm getLifeForm() {
    return this.lifeForm;
  }

  /**
   * Tries to add the LifeForm to the Cell. Will not add if a
   * LifeForm is already present
   * @param entity the LifeForm held in the cell
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
   * Removes any LifeForm from this Cell
   */
  public void removeLifeForm() {
    this.lifeForm = null;
  }
}

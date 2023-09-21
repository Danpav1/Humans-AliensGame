package lifeform;

/**
 * Represents a Human, as an extension of LifeForm. Includes added armor functionality over
 * LifeForm, which affects hit calculation
 */
public class Human extends LifeForm {
  private int armorPoints;

  /**
   * Create a Human
   * @param name the name of the Human being created
   * @param lifepoints the life points of the human being created
   * @param armor the armor of the human being created
   */
  public Human(String name, int lifepoints, int armor) {
    super(name, lifepoints);
    if (armor < 0) {
      this.armorPoints = 0;
    } else {
      this.armorPoints = armor;
    }
  }

  /**
   * Accessor for the Human's armor points
   * @return the current armor points of the Human
   */
  public int getArmorPoints() {
    return this.armorPoints;
  }

  /**
   * Mutator for the Human's armor points
   * @param points the desired number of points for the human to have
   */
  public void setArmorPoints(int points) {
    if (points < 0) {
      this.armorPoints = 0;
    } else {
      this.armorPoints = points;
    }
  }

  /**
   * Overrides the superclass takeHit method to account for armor damage reduction
   * @param damage the number of points to damage the LifeForm by
   */
  @Override
  public void takeHit(int damage) {
    super.takeHit(damage);
  }
}

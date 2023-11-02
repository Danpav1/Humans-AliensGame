package lifeform;

/**
 * Represents a Human, as an extension of LifeForm. Includes added armor functionality over
 * LifeForm, which affects hit calculation
 */
public class Human extends LifeForm {
  private int armorPoints;

  /**
   * Create a Human
   *
   * @param name       the name of the Human being created
   * @param lifePoints the life points of the human being created
   * @param armor      the armor of the human being created
   */
  public Human(String name, int lifePoints, int armor) {
    super(name, lifePoints, 5);
    this.armorPoints = Math.max(0, armor);
    this.maxSpeed = 3;
  }

  /**
   * Accessor for the Human's armor points
   *
   * @return the current armor points of the Human
   */
  int getArmorPoints() {
    return this.armorPoints;
  }

  /**
   * Mutator for the Human's armor points
   *
   * @param points the desired number of points for the human to have
   */
  void setArmorPoints(int points) {
    if (points >= 0) {
      this.armorPoints = points;
    }
  }

  /**
   * Overrides the superclass takeHit method to account for armor damage reduction
   *
   * @param damage the number of points to damage the LifeForm by
   */
  @Override
  void takeHit(int damage) {
    super.takeHit(Math.max(0, damage - this.armorPoints));
  }
}

package lifeform;

/**
 * Keeps track of the information associated with a simple life form.
 * Also provides the functionality related to the life form.
 */
public abstract class LifeForm {
  private final String myName;
  protected int currentLifePoints;
  protected int attackStrength;

  /**
   * Create a LifeForm
   * @param name the name of the life form
   * @param points the current starting life points of the life form
   */
  public LifeForm(String name, int points) {
    this.myName = name;
    this.currentLifePoints = points;
    this.attackStrength = 1;
  }

  public LifeForm(String name, int points, int strength) {
    this(name, points);
    this.attackStrength = strength;
  }

  /**
   * @return the name of the life form
   */
  public String getName() {
    return myName;
  }

  /**
   * @return the amount of current life points the life form has
   */
  public int getCurrentLifePoints() {
    return currentLifePoints;
  }

  /**
   * Lowers the LifeForm's currentLifePoints by the given number. Will not allow the
   * currentLifePoints to fall below zero.
   * @param damage the number of points to damage the LifeForm by
   */
  public void takeHit(int damage) {
    int newLifePoints = this.currentLifePoints - damage;

    if (newLifePoints < 0) {
      this.currentLifePoints = 0;
    } else {
      this.currentLifePoints = newLifePoints;
    }
  }
}

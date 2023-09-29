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
   * Create a LifeForm without specified strength
   * @param name the name of the life form
   * @param points the current starting life points of the life form
   */
  public LifeForm(String name, int points) {
    this(name, points, 1);
  }

  /**
   * Create a LifeForm with specified strength
   * @param name the name of the life form
   * @param points the current starting life points of the life form
   * @param strength the attack strength of the life form
   */
  public LifeForm(String name, int points, int strength) {
    this.myName = name;
    this.currentLifePoints = points;
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
   * @return the attackStrength of the LifeForm
   */
  public int getAttackStrength() {
    return this.attackStrength;
  }

  /**
   * Lowers the LifeForm's currentLifePoints by the given number. Will not allow the
   * currentLifePoints to fall below zero.
   * @param damage the number of points to damage the LifeForm by
   */
  void takeHit(int damage) {
    int newLifePoints = this.currentLifePoints - damage;

    this.currentLifePoints = Math.max(0, newLifePoints);
  }

  /**
   * Causes a LifeForm to "attack" another LifeForm. The passed LifeForm's health is
   * lowered by the called LifeForm's attackStrength.
   * @param opponent the LifeForm to be attacked
   */
  void attack(LifeForm opponent) {
    if (this.currentLifePoints != 0) {
      opponent.takeHit(this.attackStrength);
    }
  }
}

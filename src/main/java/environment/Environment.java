package environment;

import lifeform.LifeForm;

import weapon.Weapon;

import exceptions.EnvironmentException;

/**
 * The grid of Cells in which the LifeForms live
 */
public class Environment {

  private static Environment uniqueEnvironment;

  protected Cell[][] grid;

  private final int rows;
  private final int columns;

  /**
   * Create a new Environment
   *
   * @param rows the number of rows of the Environment
   * @param cols the number of columns of the Environment
   */
  private Environment(int rows, int cols) {
    this.rows = rows;
    this.columns = cols;

    this.grid = new Cell[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        this.grid[i][j] = new Cell();
      }
    }
  }

  /**
   * Adds a LifeForm to a Cell in the Environment
   *
   * @param entity the LifeForm being added
   * @param row    the row of the Cell to add the LifeForm to
   * @param col    the column of the Cell to add the LifeForm to
   * @return true, if the LifeForm was successfully added,
   * false otherwise
   */
  public boolean addLifeForm(LifeForm entity, int row, int col) {
    if (this.isInBounds(row, col)) {
      boolean successfullyAdded = this.grid[row][col].addLifeForm(entity);
      if (successfullyAdded) {
        entity.setLocation(row, col);
        return true;
      }
    }
    return false;
  }

  /**
   * Adds a specified Weapon to a specified location in the Environment
   *
   * @param weapon the specified Weapon
   * @param row    the specified row of the Environment
   * @param col    the specified column of the Environment
   * @return true, if the weapon was successfully added; false, otherwise
   */
  public boolean addWeapon(Weapon weapon, int row, int col) {
    if (isInBounds(row, col)) {
      return this.grid[row][col].addWeapon(weapon);
    }
    return false;
  }

  /**
   * Helper function that clears the existing board for testing purposes
   */
  public void clearBoard() {
    for (int row = 0; row < this.rows; row++) {
      for (int col = 0; col < this.columns; col++) {
        this.grid[row][col].removeLifeForm();
        this.grid[row][col].removeWeapon(this.grid[row][col].getWeapon1());
        this.grid[row][col].removeWeapon(this.grid[row][col].getWeapon2());
      }
    }
  }

  /**
   * Gets the distance between two coordinate pairs of points in the Environment
   *
   * @param row1 the first point's row
   * @param col1 the first point's column
   * @param row2 the second point's row
   * @param col2 the second point's column
   * @return the distance between the two points
   */
  public double getDistance(int row1, int col1, int row2, int col2) throws EnvironmentException {
    if (!(isInBounds(row1, col1) && isInBounds(row2, col2))) {
      throw new EnvironmentException("An invalid coordinate was entered. "
              + "LifeForms should be placed in the grid "
              + "before taking distances between them.");
    }

    double horizontalDistance = Math.abs(5 * (row2 - row1));
    double verticalDistance = Math.abs(5 * (col2 - col1));

    return Math.sqrt(Math.pow(horizontalDistance, 2.0) + Math.pow(verticalDistance, 2.0));
  }

  /**
   * Gets the distance between two LifeForms in the Environment
   *
   * @param lifeform1 the first LifeForm
   * @param lifeform2 the second LifeForm
   * @return the distance between the two LifeForms
   */
  public double getDistance(LifeForm lifeform1, LifeForm lifeform2) throws EnvironmentException {
    return this.getDistance(lifeform1.getRow(), lifeform1.getCol(),
            lifeform2.getRow(), lifeform2.getCol());
  }

  /**
   * Singleton constructor for Environment
   *
   * @return the unique instance of the Environment class
   */
  public static Environment getEnvironment(int rows, int cols) {
    if (Environment.uniqueEnvironment == null) {
      Environment.uniqueEnvironment = new Environment(rows, cols);
    }
    return Environment.uniqueEnvironment;
  }

  /**
   * Gets the LifeForm stored at a certain cell, specified by
   * the row and column inputs
   *
   * @param row the row of the Cell requested
   * @param col the column of the Cell requested
   * @return the LifeForm contained in the Cell requested
   */
  public LifeForm getLifeForm(int row, int col) {
    if (this.isInBounds(row, col)) {
      return this.grid[row][col].getLifeForm();
    }
    return null;
  }

  /**
   * Accessor for columns
   *
   * @return number of columns in the Environment
   */
  public int getNumCols() {
    return this.columns;
  }

  /**
   * Accessor for rows
   *
   * @return number of rows in the Environment
   */
  public int getNumRows() {
    return this.rows;
  }

  /**
   * Accessor for weapons
   *
   * @param row the row to check
   * @param col the column to check
   * @return an array of Weapons representing the weapons stored in the cell.
   */
  public Weapon[] getWeapons(int row, int col) {
    Weapon weapon1 = this.grid[row][col].getWeapon1();
    Weapon weapon2 = this.grid[row][col].getWeapon2();

    return new Weapon[]{weapon1, weapon2};
  }

  /**
   * Helper method that tests whether the requested row and column exists
   * or not
   *
   * @param row the row being requested
   * @param col the column being requested
   * @return boolean representing existence of the requested row and column
   */
  private boolean isInBounds(int row, int col) {
    return (0 <= row) && (row < this.rows) && (0 <= col) && (col < this.columns);
  }

  /**
   * Helper function that destroys the Environment for testing purposes
   */
  public static void removeEnvironment() {
    Environment.uniqueEnvironment = null;
  }

  /**
   * Removes the LifeForm at a specified location of the Environment
   *
   * @param row the row of the Cell to remove the LifeForm from
   * @param col the column of the Cell to remove the LifeForm from
   */
  public void removeLifeForm(int row, int col) {
    if (this.isInBounds(row, col)) {
      this.grid[row][col].removeLifeForm();
    }
  }

  /**
   * Removes a Weapon from a specified location in the Environment
   *
   * @param weapon the specified Weapon
   * @param row    the specified row of the Environment
   * @param col    the specified column of the Environment
   */
  public void removeWeapon(Weapon weapon, int row, int col) {
    if (isInBounds(row, col)) {
      this.grid[row][col].removeWeapon(weapon);
    }
  }

  /**
   * Updates the location of the entity on the grid as well as
   * updates the row and column instance variables of the entity
   *
   * @param entity is the entity whose location is being updated
   * @param row    is the row the entity has been moved to
   * @param col    is the column the entity has been moved to
   */
  public void updateGridLocation(LifeForm entity, int row, int col) {
    removeLifeForm(entity.getRow(), entity.getCol());
    if (this.isInBounds(row, col)) {
      boolean successfullyAdded = this.grid[row][col].addLifeForm(entity);
      if (successfullyAdded) {
        entity.setLocation(row, col);
      }
    }
  }

  /**
   * Moves an entity in a selected cardinal direction
   *
   * @param entity the entity that is moving
   * @return boolean that is true if move is successful or false if it fails
   */
  public boolean move(LifeForm entity) {
    int speed = entity.getMaxSpeed();
    int entityRow = entity.getRow();
    int entityCol = entity.getCol();
    String direction = entity.getCurrentDirection();

    boolean vertical = (direction.equals("north") || direction.equals("south"));
    boolean positive = (direction.equals("south") || direction.equals("east"));

    for (int i = speed; i > 0; i--) {

      if (vertical) {

        if (positive) {

          if (isInBounds(entityRow + i, entityCol)) {
            if (this.grid[entityRow + i][entityCol].getLifeForm() == null) {
              this.updateGridLocation(entity, entityRow + i, entityCol);
              return true;
            }
          }

        } else { // not positive

          if (isInBounds(entityRow - i, entityCol)) {
            if (this.grid[entityRow - i][entityCol].getLifeForm() == null) {
              this.updateGridLocation(entity, entityRow - i, entityCol);
              return true;
            }
          }

        }

      } else { // not vertical

        if (positive) {

          if (isInBounds(entityRow, entityCol + i)) {
            if (this.grid[entityRow][entityCol + i].getLifeForm() == null) {
              this.updateGridLocation(entity, entityRow, entityCol + i);
              return true;
            }
          }

        } else { // not positive

          if (isInBounds(entityRow, entityCol - i)) {
            if (this.grid[entityRow][entityCol - i].getLifeForm() == null) {
              this.updateGridLocation(entity, entityRow, entityCol - i);
              return true;
            }
          }

        }

      }

    }

    return false;
  }
}
package environment;

import lifeform.LifeForm;

/**
 * The grid of Cells in which the LifeForms live
 */
public class Environment {

  private final Cell[][] grid;
  private final int rows;
  private final int columns;

  /**
   * Create a new Environment
   * @param rows the number of rows of the Environment
   * @param cols the number of columns of the Environment
   */
  public Environment(int rows, int cols) {
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
   * @param entity the LifeForm being added
   * @param row the row of the Cell to add the LifeForm to
   * @param col the column of the Cell to add the LifeForm to
   * @return true, if the LifeForm was successfully added,
   * false otherwise
   */
  public boolean addLifeForm(LifeForm entity, int row, int col) {
    if (this.isInBounds(row, col)) {
      return this.grid[row][col].addLifeForm(entity);
    }
    return false;
  }

  /**
   * Removes the LifeForm at a specified location of the Environment
   * @param row the row of the Cell to remove the LifeForm from
   * @param col the column of the Cell to remove the LifeForm from
   */
  public void removeLifeForm(int row, int col) {
    if (this.isInBounds(row, col)) {
      this.grid[row][col].removeLifeForm();
    }
  }

  /**
   * Gets the LifeForm stored at a certain cell, specified by
   * the row and column inputs
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
   * Helper method that tests whether the requested row and column exists
   * or not
   * @param row the row being requested
   * @param col the column being requested
   * @return boolean representing existence of the requested row and column
   */
  private boolean isInBounds(int row, int col) {
    return (0 <= row) && (row < this.rows) && (0 <= col) && (col < this.columns);
  }
}

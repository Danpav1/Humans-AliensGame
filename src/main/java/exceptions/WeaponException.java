package exceptions;

/**
 * Exception thrown when something goes wrong in any Weapon
 */
public class WeaponException extends Exception {
  public WeaponException(String message) {
    super(message);
  }
}

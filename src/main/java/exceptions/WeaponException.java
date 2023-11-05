package exceptions;

/**
 * Exception thrown when fire() is passed a negative value for distance
 */
public class WeaponException extends Exception {
  public WeaponException(String message) {
    super(message);
  }
}

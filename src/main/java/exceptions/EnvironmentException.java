package exceptions;

/**
 * An Exception thrown when the Environment tries to get a distance using an invalid point
 */
public class EnvironmentException extends Exception {
  public EnvironmentException(String message) {
    super(message);
  }
}

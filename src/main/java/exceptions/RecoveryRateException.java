package exceptions;

/**
 * Exception thrown when an invalid recovery rate is input
 */
public class RecoveryRateException extends Exception {
  public RecoveryRateException(String message) {
    super(message);
  }
}

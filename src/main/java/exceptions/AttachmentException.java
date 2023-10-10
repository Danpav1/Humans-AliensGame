package exceptions;

/**
 * An exception that is thrown when an attachment tries to attach to a full weapon
 */
public class AttachmentException extends Exception {
  public AttachmentException(String message) {
    super(message);
  }
}

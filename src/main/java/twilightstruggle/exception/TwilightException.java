package twilightstruggle.exception;

/**
 * Created by eguliyev on 8/2/14.
 */
public class TwilightException extends Exception {
    public TwilightException(String message) {
        super(message);
    }
    public TwilightException(String message, Throwable throwable) {
        super(message, throwable);
    }
}

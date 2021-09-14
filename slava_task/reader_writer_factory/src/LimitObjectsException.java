public class LimitObjectsException extends RuntimeException{

    public LimitObjectsException(String message) {
        super(message);
    }

    public LimitObjectsException(String message, Throwable cause) {
        super(message, cause);
    }
}

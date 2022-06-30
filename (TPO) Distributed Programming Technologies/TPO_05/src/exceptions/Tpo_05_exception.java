package exceptions;

public class Tpo_05_exception extends RuntimeException {

    public Tpo_05_exception(String message, Throwable cause) {
        super(message, cause);
    }

    public Tpo_05_exception(String message) {
        super(message);
    }
}

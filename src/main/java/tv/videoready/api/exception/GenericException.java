package tv.videoready.api.exception;

/**
 * Created by ekansh on 15/9/15.
 */
public class GenericException extends RuntimeException {

    private static final long serialVersionUID = 62938371762936942L;

    public GenericException(String message) {
        super(message);
    }
}

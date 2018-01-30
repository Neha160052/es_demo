package tv.videoready.api.enums;

import org.springframework.http.HttpStatus;

/**
 * The {@link ErrorResponse} contains codes and messages corresponding to api response.
 *
 * @author Vikram Jakhar
 */
public enum ErrorResponse {
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "BAD_REQUEST"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL_SERVER_ERROR");

    private HttpStatus status;
    private String messageCode;

    ErrorResponse(HttpStatus status, String messageCode) {
        this.status = status;
        this.messageCode = messageCode;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }
}

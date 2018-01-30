package tv.videoready.api.enums;

import org.springframework.http.HttpStatus;

/**
 * The {@link SuccessResponse} contains codes and messages corresponding to api response.
 *
 * @author Vikram Jakhar
 */
public enum SuccessResponse {
    SAMPLE_MESSAGE(HttpStatus.OK, "SAMPLE_MESSAGE");

    private HttpStatus status;
    private String messageCode;

    SuccessResponse(HttpStatus status, String messageCode) {
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

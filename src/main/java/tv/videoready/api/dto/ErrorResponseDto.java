package tv.videoready.api.dto;

import org.springframework.http.HttpStatus;
import tv.videoready.api.enums.SuccessResponse;

import java.util.Date;
import java.util.Locale;

/**
 * The {@link ErrorResponseDto} is the actual api response class.
 *
 * @author Vikram Jakhar
 */
public class ErrorResponseDto<T> implements ResponseDto<T> {

    private Long timestamp;
    private String error;
    private String message;
    private Integer code = 1;
    private Integer status = 200;
    private T data;

    public ErrorResponseDto() {
    }

    public ErrorResponseDto(T data, Integer code, HttpStatus httpStatus) {
        this.data = data;
        this.status = httpStatus.value();
        this.code = code;
        this.error = httpStatus.getReasonPhrase();
        this.timestamp = new Date().getTime();
    }

    public ErrorResponseDto(T data, SuccessResponse successResponse) {
        this.data = data;
        this.status = successResponse.getStatus().value();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    private Locale getLocale(String locale) {
        return locale != null ? new Locale(locale) : Locale.UK;
    }
}

package tv.videoready.api.dto;

import org.springframework.http.HttpStatus;
import tv.videoready.api.enums.SuccessResponse;

import java.util.Locale;

/**
 * The {@link SuccessResponseDto} is the actual api response class.
 *
 * @author Vikram Jakhar
 */
public class SuccessResponseDto<T> implements ResponseDto<T> {

    private String message;
    private Integer code = 1;
    private Integer status = 200;
    private T data;

    public SuccessResponseDto() {
    }

    public SuccessResponseDto(T data) {
        this.data = data;
    }

    public SuccessResponseDto(T data, Integer code, HttpStatus httpStatus) {
        this.data = data;
        this.status = httpStatus.value();
        this.code = code;
    }

    public SuccessResponseDto(T data, SuccessResponse successResponse) {
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

    private Locale getLocale(String locale) {
        return locale != null ? new Locale(locale) : Locale.UK;
    }
}

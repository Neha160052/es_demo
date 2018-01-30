package tv.videoready.api.dto;

/**
 * The {@link ResponseDto} generic interface for api response.
 *
 * @author Vikram Jakhar
 */
public interface ResponseDto<T> {

    void setMessage(String message);

    void setCode(Integer code);

    void setStatus(Integer status);

    void setData(T data);

    String getMessage();

    Integer getCode();

    Integer getStatus();

    T getData();
}

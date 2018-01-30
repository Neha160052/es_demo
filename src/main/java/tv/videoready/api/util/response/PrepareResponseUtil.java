package tv.videoready.api.util.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import tv.videoready.api.dto.SuccessResponseDto;
import tv.videoready.api.dto.ErrorResponseDto;
import tv.videoready.api.dto.ResponseDto;
import tv.videoready.api.enums.ErrorResponse;
import tv.videoready.api.enums.SuccessResponse;

import java.util.Locale;

/**
 * The {@link PrepareResponseUtil} is for preparing responses for Api's.
 *
 * @author Vikram Jakhar
 */
@Component
public class PrepareResponseUtil {

    @Autowired
    private MessageSource messageSource;

    private Locale getLocale(String locale) {
        return locale != null ? new Locale(locale) : Locale.UK;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public ResponseDto prepareSuccessResponse(Object data, SuccessResponse successResponse, String locale) {
        ResponseDto responseDto = new SuccessResponseDto(data, successResponse);
        responseDto.setMessage(messageSource.getMessage(successResponse.getMessageCode(), null, getLocale(locale)));
        return responseDto;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public ResponseDto exception(Exception e, ErrorResponse errorResponse) {
        ResponseDto responseDto = new ErrorResponseDto(e.getCause(), 0, errorResponse.getStatus());
        responseDto.setMessage(messageSource.getMessage(errorResponse.getMessageCode(), null, getLocale(null)));
        return responseDto;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public ResponseDto exception(Exception e) {
        ResponseDto responseDto = new ErrorResponseDto(e.getCause(), 0, HttpStatus.BAD_REQUEST);
        responseDto.setMessage(e.getMessage());
        return responseDto;
    }
}

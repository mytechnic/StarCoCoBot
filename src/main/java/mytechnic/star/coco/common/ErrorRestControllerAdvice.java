package mytechnic.star.coco.common;

import lombok.extern.slf4j.Slf4j;
import mytechnic.star.coco.common.domain.BusinessError;
import mytechnic.star.coco.common.domain.BusinessErrorException;
import mytechnic.star.coco.common.domain.JsonResponse;
import mytechnic.star.coco.common.error.CommonError;
import org.springframework.core.convert.ConversionException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ErrorRestControllerAdvice {

    @ExceptionHandler({ResourceNotFoundException.class, HttpRequestMethodNotSupportedException.class})
    public Object onNotFoundException(Exception exception) {
        return error(CommonError.NOT_FOUND, exception.getMessage());
    }

    @ExceptionHandler({ConversionException.class})
    public Object onInternalServerErrorException(Exception exception) {
        return error(CommonError.INTERNAL_SERVER_ERROR, exception.getMessage());
    }

    @ExceptionHandler(BusinessErrorException.class)
    public Object onBusinessErrorException(BusinessErrorException exception) {
        return error(exception.getError());
    }

    private Object error(BusinessError error) {

        return new ResponseEntity<>(JsonResponse.error(error), error.getHttpStatus());
    }

    private Object error(BusinessError error, Object... parameter) {

        return new ResponseEntity<>(JsonResponse.error(error, parameter), error.getHttpStatus());
    }
}

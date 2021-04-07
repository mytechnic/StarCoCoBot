package mytechnic.star.coco.service.common;

import lombok.extern.slf4j.Slf4j;
import mytechnic.star.coco.data.response.JsonResponse;
import mytechnic.star.coco.service.common.domain.BusinessError;
import mytechnic.star.coco.service.common.domain.BusinessErrorException;
import mytechnic.star.coco.service.common.error.CommonError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ErrorRestControllerAdvice {

    @ExceptionHandler(BusinessErrorException.class)
    public Object onBusinessErrorException(BusinessErrorException exception) {
        return error(exception.getError());
    }

    @ExceptionHandler({Exception.class, RuntimeException.class})
    public Object onEtcException(Exception exception) {
        return error(CommonError.ERROR, exception.getMessage());
    }

    private Object error(BusinessError error) {

        return new ResponseEntity<>(JsonResponse.error(error), error.getHttpStatus());
    }

    private Object error(BusinessError error, Object... parameter) {

        return new ResponseEntity<>(JsonResponse.error(error, parameter), error.getHttpStatus());
    }
}

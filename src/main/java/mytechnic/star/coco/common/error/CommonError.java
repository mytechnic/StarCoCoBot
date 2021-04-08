package mytechnic.star.coco.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import mytechnic.star.coco.common.domain.BusinessError;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum CommonError implements BusinessError {
    NOT_FOUND(HttpStatus.NOT_FOUND, "%s"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "%s");

    private final HttpStatus httpStatus;
    private final String error;
}

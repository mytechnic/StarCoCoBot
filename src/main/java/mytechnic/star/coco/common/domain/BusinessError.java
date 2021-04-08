package mytechnic.star.coco.common.domain;

import org.springframework.http.HttpStatus;

public interface BusinessError {

    HttpStatus getHttpStatus();

    String getError();

    String name();
}

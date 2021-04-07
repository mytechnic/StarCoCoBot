package mytechnic.star.coco.service.common.domain;

import org.springframework.http.HttpStatus;

public interface BusinessError {

    HttpStatus getHttpStatus();

    String getError();

    String name();
}

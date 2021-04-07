package mytechnic.star.coco.service.common.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BusinessErrorException extends RuntimeException {
    private final BusinessError error;

    public BusinessErrorException(BusinessError error) {
        super(error.getError());
        this.error = error;
    }
}

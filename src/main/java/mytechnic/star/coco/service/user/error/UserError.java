package mytechnic.star.coco.service.user.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import mytechnic.star.coco.common.domain.BusinessError;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum UserError implements BusinessError {
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "유저를 찾을 수 없습니다.");

    private final HttpStatus httpStatus;
    private final String error;
}

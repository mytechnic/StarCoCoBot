package mytechnic.star.coco.common.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@ApiModel
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonResponse<T> {

    @ApiModelProperty(value = "오류 그룹", position = 1)
    private String errorGroup;

    @ApiModelProperty(value = "오류 코드", position = 2)
    private String errorCode;

    @ApiModelProperty(value = "오류 메시지", position = 3)
    private String error;

    @ApiModelProperty(value = "결과 데이터", position = 4)
    private T result;

    private JsonResponse() {
    }

    private JsonResponse(T result) {
        this.result = result;
    }

    private JsonResponse(BusinessError error) {
        this.errorGroup = error.getClass().getSimpleName();
        this.errorCode = error.name();
        this.error = error.getError();
    }

    private JsonResponse(BusinessError error, Object... parameter) {
        this.errorGroup = error.getClass().getSimpleName();
        this.errorCode = error.name();
        this.error = String.format(error.getError(), parameter);
    }

    public static <T> JsonResponse<T> ok() {
        return new JsonResponse<>();
    }

    public static <T> JsonResponse<T> ok(T result) {
        return new JsonResponse<>(result);
    }

    public static JsonResponse<?> error(BusinessError error) {
        return new JsonResponse<>(error);
    }

    public static JsonResponse<?> error(BusinessError error, Object... parameter) {
        return new JsonResponse<>(error, parameter);
    }
}

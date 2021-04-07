package mytechnic.star.coco.service.user.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ApiModel
@NoArgsConstructor
@Setter
@Getter
@ToString
public class UserCreateResponse {

    @ApiModelProperty(value = "로그인 NO", example = "guest", position = 1)
    private Long userNo;
}

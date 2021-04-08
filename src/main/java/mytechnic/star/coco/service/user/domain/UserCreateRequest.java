package mytechnic.star.coco.service.user.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import mytechnic.star.coco.data.code.Gender;

@ApiModel
@NoArgsConstructor
@Setter
@Getter
@ToString
public class UserCreateRequest {

    @ApiModelProperty(value = "로그인 ID", example = "guest", position = 1)
    private String loginId;

    @ApiModelProperty(value = "비밀번호", example = "1111", position = 2)
    private String password;

    @ApiModelProperty(value = "이름", example = "홍길동", position = 3)
    private String name;

    @ApiModelProperty(value = "성별", example = "MALE", position = 4)
    private Gender gender;
}

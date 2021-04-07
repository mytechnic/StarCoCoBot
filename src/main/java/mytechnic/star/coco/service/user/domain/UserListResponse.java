package mytechnic.star.coco.service.user.domain;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ApiModel
@NoArgsConstructor
@Setter
@Getter
@ToString
public class UserListResponse {

    private List<UserInfoResponse> userList;
}

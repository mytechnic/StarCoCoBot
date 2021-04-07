package mytechnic.star.coco.service.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import mytechnic.star.coco.data.response.JsonResponse;
import mytechnic.star.coco.service.user.domain.UserCreateRequest;
import mytechnic.star.coco.service.user.domain.UserCreateResponse;
import mytechnic.star.coco.service.user.domain.UserInfoResponse;
import mytechnic.star.coco.service.user.domain.UserUpdateRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @ApiOperation(value = "사용자 추가")
    @PostMapping("/")
    public JsonResponse<UserCreateResponse> createUser(@RequestBody UserCreateRequest request) {
        return JsonResponse.ok(userService.createUser(request));
    }

    @ApiOperation(value = "사용자 수정")
    @PutMapping("/{userNo}")
    public JsonResponse<?> updateUser(@PathVariable Long userNo, @RequestBody UserUpdateRequest request) {
        userService.updateUser(userNo, request);
        return JsonResponse.ok();
    }

    @ApiOperation(value = "사용자 삭제")
    @DeleteMapping("/{userNo}")
    public JsonResponse<?> deleteUser(@PathVariable Long userNo) {
        userService.deleteUser(userNo);
        return JsonResponse.ok();
    }

    @ApiOperation(value = "사용자 조회")
    @GetMapping("/{userNo}")
    public JsonResponse<UserInfoResponse> getUserInfo(@PathVariable Long userNo) {
        return JsonResponse.ok(userService.getUserInfo(userNo));
    }

    @ApiOperation(value = "사용자 목록")
    @GetMapping("/")
    public JsonResponse<List<UserInfoResponse>> getUserList() {
        return JsonResponse.ok(userService.getUserList());
    }
}

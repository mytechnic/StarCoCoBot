package mytechnic.star.coco.service.user;

import lombok.RequiredArgsConstructor;
import mytechnic.star.coco.data.UserRepository;
import mytechnic.star.coco.data.entity.UserEntity;
import mytechnic.star.coco.service.common.domain.BusinessErrorException;
import mytechnic.star.coco.service.user.domain.UserCreateRequest;
import mytechnic.star.coco.service.user.domain.UserCreateResponse;
import mytechnic.star.coco.service.user.domain.UserInfoResponse;
import mytechnic.star.coco.service.user.domain.UserUpdateRequest;
import mytechnic.star.coco.service.user.error.UserError;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserCreateResponse createUser(UserCreateRequest request) {

        UserEntity user = new UserEntity();
        user.setLoginId(request.getLoginId());
        user.setPassword(request.getPassword());
        user.setName(request.getName());
        user.setIsDeleted(false);
        user.setUpdatedDate(new Date());
        user.setCreatedDate(new Date());
        user = userRepository.save(user);

        UserCreateResponse response = new UserCreateResponse();
        response.setUserNo(user.getUserNo());
        return response;
    }

    private UserInfoResponse getUserInfoResponse(UserEntity user) {
        UserInfoResponse response = new UserInfoResponse();
        response.setUserNo(user.getUserNo());
        response.setLoginId(user.getLoginId());
        response.setName(user.getName());
        response.setPassword(user.getPassword());
        response.setIsDeleted(user.getIsDeleted());
        return response;
    }

    public UserInfoResponse getUserInfo(Long userNo) {

        return getUserInfoResponse(userRepository.findById(userNo)
                .orElseThrow(() -> new BusinessErrorException(UserError.USER_NOT_FOUND)));
    }

    public void updateUser(Long userNo, UserUpdateRequest request) {

        UserEntity user = userRepository.findById(userNo)
                .orElseThrow(() -> new BusinessErrorException(UserError.USER_NOT_FOUND));

        user.setLoginId(request.getLoginId());
        user.setPassword(request.getPassword());
        user.setName(request.getName());
        user.setUpdatedDate(new Date());
        userRepository.save(user);
    }

    public List<UserInfoResponse> getUserList() {

        Sort.TypedSort<UserEntity> user = Sort.sort(UserEntity.class);
        Sort sort = user.by(UserEntity::getUserNo).descending();
        return userRepository.findByIsDeleted(false, PageRequest.of(1, 20, sort))
                .stream()
                .map(this::getUserInfoResponse)
                .collect(Collectors.toList());
    }

    public void deleteUser(Long userNo) {

        UserEntity user = userRepository.findById(userNo)
                .orElseThrow(() -> new BusinessErrorException(UserError.USER_NOT_FOUND));

        user.setIsDeleted(true);
        user.setUpdatedDate(new Date());
        userRepository.save(user);
    }
}

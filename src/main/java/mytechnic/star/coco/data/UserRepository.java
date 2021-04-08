package mytechnic.star.coco.data;

import mytechnic.star.coco.data.entity.UserEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    List<UserEntity> findByIsDeleted(Boolean isDeleted, Pageable pageable);
}

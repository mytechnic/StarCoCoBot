package mytechnic.star.coco.data.jdbc;

import mytechnic.star.coco.data.jdbc.entity.UserEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource(path = "user", itemResourceRel = "user", collectionResourceRel = "users")
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    List<UserEntity> findByIsDeleted(@Param("isDeleted") Boolean isDeleted, Pageable pageable);
}

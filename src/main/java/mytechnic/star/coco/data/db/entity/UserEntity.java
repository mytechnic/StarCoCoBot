package mytechnic.star.coco.data.db.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Table("USER")
@NoArgsConstructor
@Setter
@Getter
@ToString
public class UserEntity {

    @Id
    private Long userNo;
    private String loginId;
    private String name;
    private String password;
    private Boolean isDeleted;
    private Date updatedDate;
    private Date createdDate;
}

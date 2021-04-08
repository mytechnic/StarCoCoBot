package mytechnic.star.coco.data.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public enum Gender {
    MALE("남자"), FEMALE("여성");
    private final String name;
}

package seungsoo.springmvc.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Member {

    private Long id;    // Repository에서 자동으로 할당하는 id
    private String username;
    private int age;

    public Member() {
    }

    public Member(String username, int age) {
        this.username = username;
        this.age = age;
    }
}

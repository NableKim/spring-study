package seungsoo.springmvc.basic.requestmapping;

import org.springframework.web.bind.annotation.*;

@RestController
public class MappingClassController {

    // 모든 회원 정보 보기
    @GetMapping("/mapping/users")
    public String users() {
        return "users";
    }

    // 회원 등록
    @PostMapping("/mapping/users")
    public String createUser() {
        return "create user";
    }

    // 특정 회원 정보 보기
    @GetMapping("/mapping/users/{userId}")
    public String findUser(@PathVariable String userId) {
        return "findUser "+ userId;
    }

    // 특정 회원 정보 수정
    @PatchMapping("/mapping/users/{userId}")
    public String updateUser(@PathVariable String userId) {
        return "updateUser "+ userId;
    }

    // 특정 회원 정보 삭제
    @DeleteMapping("/mapping/users/{userId}")
    public String deleteUser(@PathVariable String userId) {
        return "deleteUser "+userId;
    }

}

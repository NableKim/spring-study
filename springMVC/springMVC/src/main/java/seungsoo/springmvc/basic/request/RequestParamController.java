package seungsoo.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @ResponseBody   // return 문자열을 View네임이 아닌 Response Body에 넣어줌
    @RequestMapping("/request-param")
    public String requestParam(
            @RequestParam("username") String username,
            @RequestParam("age") int age
    ) {
        log.info("username = {}, age = {}", username, age);
        return "ok";
    }

    @ResponseBody   // return 문자열을 View네임이 아닌 Response Body에 넣어줌
    @RequestMapping("/request-param-v2")
    public String requestParam2(
            @RequestParam String username,
            @RequestParam int age
    ) {
        log.info("username = {}, age = {}", username, age);
        return "ok";
    }


    @ResponseBody   // return 문자열을 View네임이 아닌 Response Body에 넣어줌
    @RequestMapping("/request-param-v3")
    public String requestParam3(
            String username,
            Integer age
    ) {
        log.info("username = {}, age = {}", username, age);
        return "ok";
    }

    @ResponseBody   // return 문자열을 View네임이 아닌 Response Body에 넣어줌
    @RequestMapping("/request-param-map")
    public String requestParamMap(
            @RequestParam Map<String, Object> paramMap) {
        log.info("username = {}, age = {}", paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }

    @ResponseBody   // return 문자열을 View네임이 아닌 Response Body에 넣어줌
    @RequestMapping("/request-param-multimap")
    public String requestParamMultiMap(
            @RequestParam MultiValueMap<String, Object> paramMap) {
        log.info("username = {}, age = {}", paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }

}

package seungsoo.springmvc.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = {"/hello-basic", "hello-go"}, method = RequestMethod.GET)
    public String helloBasic() {
        log.info("helloBasic");
        return "OK";
    }

    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable String userId) {
        log.info("mappingPath userId={}", userId);
        return "OK";
    }

    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam() {
        log.info("mappingParam");
        return "OK";
    }

    @GetMapping(value="/mapping-header", headers="mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "OK";
    }

    // Http 요청 메시지의 Content-Type 헤더와 관련 있음. 요청 데이터의 메시지가 어떤 형식으로 오는지
    @PostMapping(value="/mapping-consumes", consumes = "application/json")
    public String mappingConsumes() {
        log.info("mappingConsumes");
        return "OK";
    }

    // Http 요청의 Accept 헤더와 관련 있음. 응답 데이터로 어떤 형식을 받을 수 있는지
    @PostMapping(value = "mapping-produce", produces = MediaType.TEXT_PLAIN_VALUE)
    public String mappingProduces() {
        log.info("mappingProduces");
        return "OK";
    }
}

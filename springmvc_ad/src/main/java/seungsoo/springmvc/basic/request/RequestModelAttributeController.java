package seungsoo.springmvc.basic.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import seungsoo.springmvc.basic.HelloData;


@Controller
public class RequestModelAttributeController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData) {
        log.info("helloData.username={}, helloData.age={}", helloData.getUsername(), helloData.getAge());
        log.info("helloData={}", helloData);
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData) {
        log.info("helloData.username={}, helloData.age={}", helloData.getUsername(), helloData.getAge());
        return "OK";
    }
}

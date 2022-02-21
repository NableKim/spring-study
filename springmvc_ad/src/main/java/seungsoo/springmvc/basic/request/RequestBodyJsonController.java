package seungsoo.springmvc.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import seungsoo.springmvc.basic.HelloData;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Controller
public class RequestBodyJsonController {

    private ObjectMapper objectMapper = new ObjectMapper();
    private Logger log = LoggerFactory.getLogger(getClass());

    @ResponseBody
    @RequestMapping("/request-body-json-v1")
    public String requestBodyJsonV1(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        
        // 객체로 바꾸기
        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);

        // 로그 남기기
        log.info("helloData={}", helloData);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-body-json-v2")
    public String requestBodyJsonV2(HttpEntity<HelloData> httpEntity) throws IOException {

        HelloData helloData = httpEntity.getBody();

        // 로그 남기기
        log.info("helloData={}", helloData);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-body-json-v3")
    public String requestBodyJsonV3(@RequestBody HelloData helloData) throws IOException {
        // 로그 남기기
        log.info("helloData={}", helloData);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-body-json-v4")
    public HelloData requestBodyJsonV4(@RequestBody HelloData helloData) throws IOException {
        // 로그 남기기
        log.info("helloData={}", helloData);
        return helloData;
    }

    @ResponseBody
    @RequestMapping("/request-body-json-v5")
    public HttpEntity<HelloData> requestBodyJsonV5(@RequestBody HelloData helloData) throws IOException {
        // 로그 남기기
        log.info("helloData={}", helloData);
        return new HttpEntity<>(helloData);
    }
}

package seungsoo.springmvc.basic.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;

@Controller
public class RequestBodyStringController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/request-body-string-v1")
    public void requestBodyString(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        // message body를 읽기 위해 inputstream 객체를 얻어옴
        ServletInputStream inputStream = request.getInputStream();
        
        // inputstream 안의 바이트코드와 인코딩 정보를 갖고 문자열로 읽어들임
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messagebody={}", messageBody);
        response.getWriter().write("ok");

    }

    @RequestMapping("/request-body-string-v2")
    public void requestBodyStringV2(InputStream inputStream, Writer responseWriter) throws IOException {
        // message body를 읽기 위해 inputstream 객체 만드는 일을 Spring MVC가 해줌
        // inputstream 안의 바이트코드와 인코딩 정보를 갖고 문자열로 읽어들임
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        log.info("messagebody={}", messageBody);
        responseWriter.write("ok");
    }

    @RequestMapping("/request-body-string-v3")
    public HttpEntity<String> requestBodyStringV3(HttpEntity<String> httpEntity) throws IOException {
        String messageBody = httpEntity.getBody();
        log.info("messagebody={}", messageBody);
        return new HttpEntity<>("ok");
    }

    @RequestMapping("/request-body-string-v4")
    public HttpEntity<String> requestBodyStringV4(RequestEntity<String> httpEntity) throws IOException {
        String messageBody = httpEntity.getBody();
        log.info("messagebody={}", messageBody);
        return new ResponseEntity<String>("ok", HttpStatus.CREATED);
    }

    @ResponseBody
    @RequestMapping("/request-body-string-v5")
    public String requestBodyStringV5(@RequestBody String messageBody) throws IOException {
        log.info("messagebody={}", messageBody);
        return "ok";
    }
}

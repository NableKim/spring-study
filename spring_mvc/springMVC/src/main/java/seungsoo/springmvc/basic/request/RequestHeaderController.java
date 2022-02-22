package seungsoo.springmvc.basic.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@RestController
public class RequestHeaderController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/mappingHeader")
    public String headers(HttpServletRequest request,
                          HttpServletResponse response,
                          HttpMethod method,
                          Locale locale,
                          @RequestHeader MultiValueMap<String, String> headerMap,
                          @RequestHeader("host") String host,
                          @CookieValue(value="myCookie", required = false, defaultValue = "default") String cookie)
    {

        log.info("requst = {}", request);
        log.info("response = {}", response);
        log.info("method = {}", method);
        log.info("locale = {}", locale);
        log.info("headerMap = {}", headerMap);
        log.info("host = {}", host);
        log.info("cookie = {}", cookie);

        return "OK";
    }

}

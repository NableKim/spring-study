package hello.itemservice.message;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

import java.util.Locale;

@SpringBootTest
public class MessageSourceTest {

    @Autowired
    MessageSource ms;

    @Test
    void helloMessage() {
        // 디폴트 메세지 파일에서 hello 메시지 읽어오기
        String result = ms.getMessage("hello", null, null);
        System.out.println("result = " + result);
        Assertions.assertThat(result).isEqualTo("안녕");
    }

    @Test
    void helloMessageWithParam() {
        String result = ms.getMessage("hello.name", new Object[]{"Spring"}, null);
        Assertions.assertThat(result).isEqualTo("안녕 Spring");
    }

    @Test
    void notFoundMessage() {
        Assertions.assertThatThrownBy(() -> ms.getMessage("not_found", null, null))
                .isInstanceOf(NoSuchMessageException.class);
    }

    @Test
    void notFoundMessageDefaultMessage() {
        String message = ms.getMessage("not_found_default", null, "default_name", null);
        Assertions.assertThat(message).isEqualTo("default_name");
    }

}

package hello.spring.fristpjt.fieldmatching;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

public class FieldMatchingTest {
    @Test
    @DisplayName("Field Matching Test when two have same type")
    void fieldMatchingTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        ServiceImplementation bean = ac.getBean(ServiceImplementation.class);
        Assertions.assertThat(bean.getFunctionInterface())
                .isInstanceOf(FuncImplementationAAA.class);
    }

    @Configuration
    @ComponentScan
    static class AppConfig {
    }
}

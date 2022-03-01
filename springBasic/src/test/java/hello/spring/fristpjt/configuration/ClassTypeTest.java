package hello.spring.fristpjt.configuration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class ClassTypeTest {


    @Test
    @DisplayName("일반 Class의 타입을 출력할 때와 @Configuration 붙인 것과의 차이")
    void classTypeTest() {
        TestConfig testConfig = new TestConfig();
        System.out.println(testConfig);

        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfigWithConfig.class);
        TestConfigWithConfig bean = ac.getBean(TestConfigWithConfig.class);
        System.out.println("bean = " + bean.getClass());
        Map<String, TestConfigWithConfig> beansOfType = ac.getBeansOfType(TestConfigWithConfig.class);
        for (String s : beansOfType.keySet()) {
            System.out.println(s);
        }
        //System.out.println(ac.getBeanNamesForType(TestConfigWithConfig.class));
    }


}

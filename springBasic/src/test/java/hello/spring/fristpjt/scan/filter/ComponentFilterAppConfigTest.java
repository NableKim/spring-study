package hello.spring.fristpjt.scan.filter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

import static org.springframework.context.annotation.ComponentScan.*;

public class ComponentFilterAppConfigTest {

    @Test
    @DisplayName("사용자 정의 Component Annotation 만들기")
    void componentFilterAppConfigTest() {

        ApplicationContext ac = new AnnotationConfigApplicationContext(FilterAppConfig.class);
        BeanA beanA = ac.getBean(BeanA.class);
        System.out.println("bean = " + beanA);

        Assertions.assertThrows(NoSuchBeanDefinitionException.class, ()->
                ac.getBean(BeanB.class));
    }

    @Configuration
    @ComponentScan(
            includeFilters = @Filter(type= FilterType.ANNOTATION, classes = MyIncludeComponent.class),
            excludeFilters = @Filter(type=FilterType.ANNOTATION, classes = MyExcludeComponent.class)
    )
    static class FilterAppConfig {

    }

}

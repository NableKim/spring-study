package hello.spring.fristpjt.beanfind;

import hello.spring.fristpjt.discount.DiscountPolicy;
import hello.spring.fristpjt.discount.FixDiscountPolicy;
import hello.spring.fristpjt.discount.RateDiscountPolicy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

public class ApplicationContextExtendsFindTest {

    ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("부모 타입으로 조회 시, 자식이 둘 이상 있으면 중복 오류 발생")
    void findBeanByParentTypeDuplicate() {
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(DiscountPolicy.class));
    }

    @Test
    @DisplayName("부모 타입으로 자식 모두 조회하기")
    void findAllBeanByParentType() {
        Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key="+key + " value="+beansOfType.get(key));
        }
        System.out.println(beansOfType.size());
    }

    @Test
    @DisplayName("Object 타입으로 모든 스프링 빈 조회하기")
    void findAllBeanByObjectType() {
        Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key="+key + " value="+beansOfType.get(key));
        }
        System.out.println(beansOfType.size());
    }
    
    @Configuration
    static class TestConfig {
        @Bean
        public DiscountPolicy discountPolicy1() {
            return new FixDiscountPolicy();
        }

        @Bean
        public DiscountPolicy discountPolicy2() {
            return new RateDiscountPolicy();
        }
    }

}

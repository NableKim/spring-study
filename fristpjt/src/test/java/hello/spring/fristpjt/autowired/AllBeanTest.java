package hello.spring.fristpjt.autowired;

import hello.spring.fristpjt.AutoAppConfig;
import hello.spring.fristpjt.discount.DiscountPolicy;
import hello.spring.fristpjt.member.Grade;
import hello.spring.fristpjt.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

public class AllBeanTest {


    @Test
    @DisplayName("같은 타입의 스프링 빈을 모두 조회하고, 쓰임에 따라 바꿔사용하는 예제")
    void findAllBean() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);
        DiscountService discountService = ac.getBean(DiscountService.class);

        Member member = new Member(1L, "SeungsooKim", Grade.VIP);

        int discount = discountService.getDiscountPrice(member, 10000, "fixDiscountPolicy");
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    public static class DiscountService {
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policyList;

        @Autowired
        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policyList) {
            this.policyMap = policyMap;
            this.policyList = policyList;
            System.out.println("policyMap = " + policyMap);
            System.out.println("policyList = " + policyList);
        }

        public int getDiscountPrice(Member member, int price, String discountPolicyName) {
            System.out.println("discountPolicyName = " + discountPolicyName);

            DiscountPolicy discountPolicy = policyMap.get(discountPolicyName);
            return discountPolicy.discount(member, price);
        }
    }
}

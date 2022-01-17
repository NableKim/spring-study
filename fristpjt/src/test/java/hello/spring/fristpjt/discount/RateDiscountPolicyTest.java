package hello.spring.fristpjt.discount;

import hello.spring.fristpjt.member.Grade;
import hello.spring.fristpjt.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인을 적용한다")
    void vip_o() {

        // given
        Member member = new Member(1L, "seungsoo", Grade.VIP);

        // when
        int discount = discountPolicy.discount(member,10000);

        // then
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니라면 할인이 적용되지 않아야한다")
    void vip_x() {
        // given
        Member member = new Member(2L, "seunghoon", Grade.BASIC);

        // when
        int discount = discountPolicy.discount(member, 10000);

        // then
        Assertions.assertThat(discount).isEqualTo(0);
    }
}
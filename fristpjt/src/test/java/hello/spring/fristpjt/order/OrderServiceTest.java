package hello.spring.fristpjt.order;

import hello.spring.fristpjt.member.Grade;
import hello.spring.fristpjt.member.Member;
import hello.spring.fristpjt.member.MemberService;
import hello.spring.fristpjt.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {

        // given
        Member member = new Member(1L, "seungsoo", Grade.VIP);
        memberService.join(member);

        // when
        Order order = orderService.createOrder(member.getId(), "iPhone13", 1500000);

        // then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
package hello.spring.fristpjt;

import hello.spring.fristpjt.discount.DiscountPolicy;
import hello.spring.fristpjt.discount.RateDiscountPolicy;
import hello.spring.fristpjt.member.MemberRepository;
import hello.spring.fristpjt.member.MemberService;
import hello.spring.fristpjt.member.MemberServiceImpl;
import hello.spring.fristpjt.member.MemoryMemberRepository;
import hello.spring.fristpjt.order.OrderService;
import hello.spring.fristpjt.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}

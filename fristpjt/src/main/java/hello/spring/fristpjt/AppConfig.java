package hello.spring.fristpjt;

import hello.spring.fristpjt.discount.DiscountPolicy;
import hello.spring.fristpjt.discount.FixDiscountPolicy;
import hello.spring.fristpjt.discount.RateDiscountPolicy;
import hello.spring.fristpjt.member.MemberRepository;
import hello.spring.fristpjt.member.MemberService;
import hello.spring.fristpjt.member.MemberServiceImpl;
import hello.spring.fristpjt.member.MemoryMemberRepository;
import hello.spring.fristpjt.order.OrderService;
import hello.spring.fristpjt.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}

package hello.spring.fristpjt;

import hello.spring.fristpjt.discount.FixDiscountPolicy;
import hello.spring.fristpjt.member.MemberService;
import hello.spring.fristpjt.member.MemberServiceImpl;
import hello.spring.fristpjt.member.MemoryMemberRepository;
import hello.spring.fristpjt.order.OrderService;
import hello.spring.fristpjt.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}

package hello.spring.fristpjt;

import hello.spring.fristpjt.member.Grade;
import hello.spring.fristpjt.member.Member;
import hello.spring.fristpjt.member.MemberService;
import hello.spring.fristpjt.member.MemberServiceImpl;
import hello.spring.fristpjt.order.Order;
import hello.spring.fristpjt.order.OrderService;
import hello.spring.fristpjt.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();
        //OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "seungsoo", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "iPhone13", 1500000);
        System.out.println("order = " + order);
        System.out.println("discount price = " +order.calculatePrice());
    }

}

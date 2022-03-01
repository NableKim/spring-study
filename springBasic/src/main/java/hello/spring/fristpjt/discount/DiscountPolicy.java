package hello.spring.fristpjt.discount;

import hello.spring.fristpjt.member.Member;

public interface DiscountPolicy {
    /**
     * @return 할인되는 금액
     */
    int discount(Member member, int price);
}

package hello.spring.fristpjt.order;

import hello.spring.fristpjt.discount.DiscountPolicy;
import hello.spring.fristpjt.discount.FixDiscountPolicy;
import hello.spring.fristpjt.member.Member;
import hello.spring.fristpjt.member.MemberRepository;
import hello.spring.fristpjt.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    MemberRepository memberRepository = new MemoryMemberRepository();
    DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}

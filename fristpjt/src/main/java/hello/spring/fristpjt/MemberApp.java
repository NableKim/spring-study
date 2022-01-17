package hello.spring.fristpjt;

import hello.spring.fristpjt.member.Grade;
import hello.spring.fristpjt.member.Member;
import hello.spring.fristpjt.member.MemberService;
import hello.spring.fristpjt.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1L, "seungsoo", Grade.VIP);

        // 회원 가입 시키기
        memberService.join((member));

        // 회원 가입한 정보와 조회한 정보가 일치하는지 확인
        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}

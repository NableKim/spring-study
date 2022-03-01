package seungsoo.springmvc.web.frontcontroller.v2.controller;

import seungsoo.springmvc.domain.Member;
import seungsoo.springmvc.domain.MemberRepository;
import seungsoo.springmvc.web.frontcontroller.MyView;
import seungsoo.springmvc.web.frontcontroller.v2.ControllerV2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class MemberListControllerV2 implements ControllerV2 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) {
        List<Member> memberList = memberRepository.findAll();
        request.setAttribute("memberList", memberList);
        return new MyView("/WEB-INF/views/members.jsp");
    }
}

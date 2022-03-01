package seungsoo.springmvc.web.frontcontroller.v4.controller;

import seungsoo.springmvc.domain.Member;
import seungsoo.springmvc.domain.MemberRepository;
import seungsoo.springmvc.web.frontcontroller.v4.ControllerV4;

import java.util.List;
import java.util.Map;

public class MemberListControllerV4 implements ControllerV4 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        List<Member> memberList = memberRepository.findAll();
        model.put("memberList", memberList);
        return "members";
    }
}

package seungsoo.springmvc.web.frontcontroller.v3.controller;

import seungsoo.springmvc.domain.Member;
import seungsoo.springmvc.domain.MemberRepository;
import seungsoo.springmvc.web.frontcontroller.ModelView;
import seungsoo.springmvc.web.frontcontroller.v3.ControllerV3;

import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {

        // ModelView에 member 정보를 모두 가져와서 넣어주고 반환
        List<Member> memberList = memberRepository.findAll();
        ModelView modelView = new ModelView("members");
        modelView.getModel().put("memberList", memberList);

        return modelView;
    }
}

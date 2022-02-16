package seungsoo.springmvc.web.frontcontroller.v3.controller;

import seungsoo.springmvc.domain.Member;
import seungsoo.springmvc.domain.MemberRepository;
import seungsoo.springmvc.web.frontcontroller.ModelView;
import seungsoo.springmvc.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {

        // repo에 새로운 member 정보 저장
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));
        Member member = new Member(username, age);
        memberRepository.save(member);

        // 뷰에서 사용할 View 논리주소와 모델 정보 만들기
        ModelView modelView = new ModelView("save-result");
        modelView.getModel().put("member", member);

        return modelView;
    }
}

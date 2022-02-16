package seungsoo.springmvc.web.frontcontroller.v2.controller;

import seungsoo.springmvc.domain.Member;
import seungsoo.springmvc.domain.MemberRepository;
import seungsoo.springmvc.web.frontcontroller.MyView;
import seungsoo.springmvc.web.frontcontroller.v2.ControllerV2;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberSaveControllerV2 implements ControllerV2 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) {
        // 요청온 데이터를 가지고 repo에 저장하는 비지니스 로직 실행
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        // 뷰에서 사용할 데이터를 Model에 담기
        request.setAttribute("member", member);

        // 제대로 저장이 되었다는 사실을 client에게 알려줘야함.
        return new MyView("/WEB-INF/views/save-result.jsp");
    }
}

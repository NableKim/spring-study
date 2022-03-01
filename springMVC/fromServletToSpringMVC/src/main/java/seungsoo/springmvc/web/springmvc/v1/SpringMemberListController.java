package seungsoo.springmvc.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import seungsoo.springmvc.domain.Member;
import seungsoo.springmvc.domain.MemberRepository;

import java.util.List;

@Controller
public class SpringMemberListController {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/springmvc/v1/members")
    public ModelAndView process() {
        List<Member> memberList = memberRepository.findAll();

        ModelAndView modelAndView = new ModelAndView("members");
        modelAndView.addObject("memberList", memberList);
        return modelAndView;
    }
}

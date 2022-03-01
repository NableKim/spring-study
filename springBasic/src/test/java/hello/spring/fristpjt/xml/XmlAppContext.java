package hello.spring.fristpjt.xml;

import hello.spring.fristpjt.member.MemberService;
import hello.spring.fristpjt.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class XmlAppContext {
    
    @Test
    @DisplayName("xml 구성 파일로 스프링 컨테이너 만들기")
    void xmlAppContext() {

        ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");

        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    
}

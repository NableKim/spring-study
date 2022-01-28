package hello.spring.fristpjt.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class ProtoTypeTest {

    @Test
    public void prototypeBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ProtoTypeBean.class);
        
        // 스프링 컨테이너에 ProtoTypeBean 빈 첫 번째 요청
        ProtoTypeBean protoTypeBean1 = ac.getBean(ProtoTypeBean.class);
        System.out.println("protoTypeBean1 = " + protoTypeBean1);

        // 스프링 컨테이너에 ProtoTypeBean 빈 두 번째 요청
        ProtoTypeBean protoTypeBean2 = ac.getBean(ProtoTypeBean.class);
        System.out.println("protoTypeBean2 = " + protoTypeBean2);
        
        // 반환된 두 스프링 빈이 다름을 확인할 수 있음
        Assertions.assertThat(protoTypeBean1).isNotSameAs(protoTypeBean2);
        
        // 스프링 컨테이너 종료
        ac.close();
    }


    @Scope("prototype")
    static class ProtoTypeBean {

        @PostConstruct
        public void init() {
            System.out.println("ProtoTypeBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("ProtoTypeBean.destroy");
        }

    }
}

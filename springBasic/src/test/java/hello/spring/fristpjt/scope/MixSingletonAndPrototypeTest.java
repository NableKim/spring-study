package hello.spring.fristpjt.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class MixSingletonAndPrototypeTest {

    @Test
    void mixSingletonAndPrototypeTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);

        SingletonBean singletonBean1 = ac.getBean(SingletonBean.class);
        ProtoTypeBean protoTypeBean1 = singletonBean1.protoTypeBean;
        protoTypeBean1.addCount();
        Assertions.assertThat(protoTypeBean1.getCount()).isEqualTo(1);

        SingletonBean singletonBean2 = ac.getBean(SingletonBean.class);
        ProtoTypeBean protoTypeBean2 = singletonBean2.protoTypeBean;
        protoTypeBean2.addCount();
        Assertions.assertThat(protoTypeBean2.getCount()).isEqualTo(2);

        // 싱글톤 스코프의 빈 객체가 동일하다
        Assertions.assertThat(singletonBean1).isSameAs(singletonBean2);
        
        // 싱글톤 빈에 주입된 프로토타입 스코프의 빈 객체도 동일하다
        Assertions.assertThat(protoTypeBean1).isSameAs(protoTypeBean2);
    }

    @ComponentScan
    @Scope("singleton")
    static class SingletonBean {

        private final ProtoTypeBean protoTypeBean;

        @Autowired
        SingletonBean(ProtoTypeBean protoTypeBean) {
            this.protoTypeBean = protoTypeBean;
        }

        @PostConstruct
        public void init() {
            System.out.println("SingletonBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("SingletonBean.destroy");
        }
    }

    @Component
    @Scope("prototype")
    static class ProtoTypeBean {

        private int count = 0;

        @PostConstruct
        public void init() {
            System.out.println("ProtoTypeBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("ProtoTypeBean.destroy");
        }

        public void addCount() {
            this.count++;
        }

        public int getCount() {
            return this.count;
        }
    }

}

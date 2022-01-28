package hello.spring.fristpjt.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class MakeNewPrototypeWheneverUsingTest {
    @Test
    void makeNewPrototypeWheneverUsingTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);

        SingletonBean singletonBean1 = ac.getBean(SingletonBean.class);
        int count1 = singletonBean1.single_logic();
        Assertions.assertThat(count1).isEqualTo(1);

        SingletonBean singletonBean2 = ac.getBean(SingletonBean.class);
        int count2 = singletonBean2.single_logic();
        Assertions.assertThat(count2).isEqualTo(1);

        // 싱글톤 스코프의 빈 객체가 동일하다
        Assertions.assertThat(singletonBean1).isSameAs(singletonBean2);
    }

    @ComponentScan
    @Scope("singleton")
    static class SingletonBean {

        private final ObjectProvider<ProtoTypeBean> protoTypeBeanObjectProvider;

        @Autowired
        SingletonBean(ObjectProvider<ProtoTypeBean> protoTypeBeanObjectProvider) {
            this.protoTypeBeanObjectProvider = protoTypeBeanObjectProvider;
        }

        @PostConstruct
        public void init() {
            System.out.println("SingletonBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("SingletonBean.destroy");
        }

        public int single_logic() {
            ProtoTypeBean protoTypeBean = protoTypeBeanObjectProvider.getObject();
            protoTypeBean.addCount();
            return protoTypeBean.getCount();
        }
    }

    @Component
    @Scope("prototype")
    static class ProtoTypeBean {

        private int count = 0;

        @PostConstruct
        public void init() {
            System.out.println("ProtoTypeBean.init " + this);
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
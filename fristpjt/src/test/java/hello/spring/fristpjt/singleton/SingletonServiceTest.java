package hello.spring.fristpjt.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonServiceTest {
    
    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        // 싱글톤 조회 1
        SingletonService singletonService1 = SingletonService.getInstance();

        // 싱글톤 조회 2
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1 : " + singletonService1);
        System.out.println("singletonService2 : " + singletonService2);

        Assertions.assertThat(singletonService1).isSameAs(singletonService2);
    }
    
}

package hello.spring.fristpjt.lombok;

import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class LombokTest {
    @Test
    @DisplayName("Lombok Test")
    void lombokTest() {
        TestLombok testLombok = new TestLombok();
        testLombok.setName("hello");
        testLombok.setAge(12);

        System.out.println("testLombok.getName() = " + testLombok.getName());
        System.out.println("testLombok.getAge() = " + testLombok.getAge());
    }

    @Getter
    @Setter
    static class TestLombok {
        public String name;
        public int age;
    }
}

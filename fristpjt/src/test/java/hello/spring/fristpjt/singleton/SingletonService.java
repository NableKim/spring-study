package hello.spring.fristpjt.singleton;

public class SingletonService {

    // static 영역에 인스턴스를 1개만 생성해두기
    private static final SingletonService instance = new SingletonService();
    
    // 싱글톤 인스턴스를 얻어오기 위한 메소드
    public static SingletonService getInstance() {
        return instance;
    }

    // 싱글톤의 생성자는 private 접근지정자로 설정. 추가적인 인스턴스 생성 막기
    private SingletonService() {

    }

    public void logic() {
        System.out.println("Singleton Object's method call");
    }



}

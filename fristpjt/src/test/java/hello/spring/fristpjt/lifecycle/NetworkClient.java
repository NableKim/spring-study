package hello.spring.fristpjt.lifecycle;

public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println("NetworkClient 생성자 호출 " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작 시 호출할 함수
    public void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String message) {
        System.out.println("call: "+ url + " message: "+ message);
    }

    // 서비스 종료 전 호출할 함수
    public void disconnect() {
        System.out.println("disconnect : " + url);
    }

    public void init(){
        connect();
        call("초기화합니다");
    }

    public void destroy() {
        disconnect();
    }
}

package hello.core.singleton;

// 객체를 미리 생성하는 싱글톤 패턴
public class SingletonService {

    // static을 사용하면 static 영역에 딱 하나만 올라감
    private static final SingletonService instance = new SingletonService();

    // 1. 조회 (객체 인스턴스가 필요하면 getInstance()를 통해서만 조회할 수 있다)
    public static SingletonService getInstance() {
        return instance;
    }

    // 2. private 생성자 (실수로 new 키워드로 만드려 해도 외부에서 생성되는 것을 막음)
    private  SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}

package hello.servlet.web.frontcontroller.v1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 프론트 컨트롤러 도입
// 프론트 컨트롤러가 이 인터페이스를 호출해서 구현과 관계없이 로직의 일관성을 지킬 수 있음
public interface ControllerV1 {

    void process(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException, ServletException;
}

package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor    // 자동 주입
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final MyLogger myLogger;
    // private final ObjectProvider<MyLogger> myLoggerProvider;

    @RequestMapping("log-demo")     // log-demo라는 요청이 오면
    @ResponseBody                   // 문자를 그대로 web에서 응답함
    public String logDemo(HttpServletRequest request) {

        String requestURL = request.getRequestURL().toString();     // 고객이 어떤 URL로 요청했는지 알 수 있음
        myLogger.setRequestURL(requestURL);
        System.out.println("myLogger = " + myLogger.getClass());

//        MyLogger myLogger = myLoggerProvider.getObject();
//        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }
}

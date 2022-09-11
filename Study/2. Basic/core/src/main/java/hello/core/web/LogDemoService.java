package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    // 의존관계 주입 받음

    /*provider 사용 방법
    private final ObjectProvider<MyLogger> myLoggerProvider;

    public void logic(String id) {
        myLoggerProvider.getObject()
        myLogger.log("service id = " + id);
        }*/

    // 프록시 사용 방법
    private final MyLogger myLogger;

    public void logic(String id) {
        myLogger.log("service id = " + id);
    }
}

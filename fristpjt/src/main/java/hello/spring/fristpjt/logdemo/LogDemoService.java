package hello.spring.fristpjt.logdemo;

import hello.spring.fristpjt.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LogDemoService {

    //private final ObjectProvider<MyLogger> myLoggerObjectProvider;
    private final MyLogger myLogger;

    public void logic(String testId) {
        //MyLogger myLogger = myLoggerObjectProvider.getObject();
        myLogger.log("testId = " + testId);
    }
}

package hello.spring.fristpjt.fieldmatching;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("funcImplementationAAA")
public class FuncImplementationAAA implements FunctionInterface {

}

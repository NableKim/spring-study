package hello.spring.fristpjt.fieldmatching;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class ServiceImplementation implements ServiceInterface {
    private final FunctionInterface functionInterface;

    @Autowired
    public ServiceImplementation(FunctionInterface funcImplementationAAA) {
        this.functionInterface = funcImplementationAAA;
    }

    public FunctionInterface getFunctionInterface() {
        return functionInterface;
    }
}
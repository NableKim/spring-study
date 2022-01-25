package hello.spring.fristpjt.fieldmatching;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
class ServiceImplementation implements ServiceInterface {
    private final FunctionInterface functionInterface;

    @Autowired
    public ServiceImplementation(@Qualifier("funcImplementationAAA")
                                             FunctionInterface funcImplementation) {
        this.functionInterface = funcImplementation;
    }

    public FunctionInterface getFunctionInterface() {
        return functionInterface;
    }
}
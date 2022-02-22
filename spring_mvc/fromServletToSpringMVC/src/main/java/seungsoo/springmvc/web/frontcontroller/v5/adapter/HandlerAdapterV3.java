package seungsoo.springmvc.web.frontcontroller.v5.adapter;

import seungsoo.springmvc.web.frontcontroller.ModelView;
import seungsoo.springmvc.web.frontcontroller.MyView;
import seungsoo.springmvc.web.frontcontroller.v3.ControllerV3;
import seungsoo.springmvc.web.frontcontroller.v5.HandlerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class HandlerAdapterV3 implements HandlerAdapter {
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV3);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        ControllerV3 controller = (ControllerV3)handler;
        Map<String, String> paramMap = createParamMap(request);
        return controller.process(paramMap);
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                        .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}

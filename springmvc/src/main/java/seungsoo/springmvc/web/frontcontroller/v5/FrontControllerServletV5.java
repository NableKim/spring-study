package seungsoo.springmvc.web.frontcontroller.v5;

import seungsoo.springmvc.web.frontcontroller.ModelView;
import seungsoo.springmvc.web.frontcontroller.MyView;
import seungsoo.springmvc.web.frontcontroller.v3.controller.MemberFormControllerV3;
import seungsoo.springmvc.web.frontcontroller.v3.controller.MemberListControllerV3;
import seungsoo.springmvc.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import seungsoo.springmvc.web.frontcontroller.v5.adapter.HandlerAdapterV3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "frontControllerServletV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerServletV5 extends HttpServlet {

    private Map<String, Object> handlerMap = new HashMap<>();
    private List<HandlerAdapter> handlerAdapterList = new ArrayList<>();

    public FrontControllerServletV5() {
        initHandler();
        initHandlerAdapter();
    }

    private void initHandlerAdapter() {
        handlerAdapterList.add(new HandlerAdapterV3());
    }

    private void initHandler() {
        handlerMap.put("/front-controller/v5/v3/members/new-form", new MemberFormControllerV3());
        handlerMap.put("/front-controller/v5/v3/members/save", new MemberSaveControllerV3());
        handlerMap.put("/front-controller/v5/v3/members", new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // URI 경로에 맞는 핸들러 찾기
        Object handler = getHandler(request);
        if(handler==null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        
        // 핸들러를 실행시킬 수 있는 어댑터 찾기
        HandlerAdapter handlerAdapter = getHandlerAdapter(handler);
        if(handlerAdapter == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // 그 어댑터로 핸들러를 실행시키도록 함
        ModelView modelview = handlerAdapter.handle(request, response, handler);

        // 핸들러 실행 결과 받아온 모델뷰로 뷰리졸브 실행
        String viewName = modelview.getViewName();
        MyView myView = new MyView("/WEB-INF/views/"+viewName+".jsp");

        // 렌더링 시작
        myView.render(modelview.getModel(), request, response);
    }

    private HandlerAdapter getHandlerAdapter(Object handler) {
        for (HandlerAdapter handlerAdapter : handlerAdapterList) {
            if(handlerAdapter.supports(handler))
                return handlerAdapter;
        }
        throw new IllegalArgumentException("handler adapter를 찾을 수 없습니다. handler="+handler);
    }

    private Object getHandler(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        return handlerMap.get(requestURI);
    }
}

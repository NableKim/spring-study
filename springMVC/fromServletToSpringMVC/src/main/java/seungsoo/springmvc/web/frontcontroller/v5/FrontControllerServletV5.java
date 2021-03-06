package seungsoo.springmvc.web.frontcontroller.v5;

import seungsoo.springmvc.web.frontcontroller.ModelView;
import seungsoo.springmvc.web.frontcontroller.MyView;
import seungsoo.springmvc.web.frontcontroller.v3.controller.MemberFormControllerV3;
import seungsoo.springmvc.web.frontcontroller.v3.controller.MemberListControllerV3;
import seungsoo.springmvc.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import seungsoo.springmvc.web.frontcontroller.v4.controller.MemberFormControllerV4;
import seungsoo.springmvc.web.frontcontroller.v4.controller.MemberListControllerV4;
import seungsoo.springmvc.web.frontcontroller.v4.controller.MemberSaveControllerV4;
import seungsoo.springmvc.web.frontcontroller.v5.adapter.HandlerAdapterV3;
import seungsoo.springmvc.web.frontcontroller.v5.adapter.HandlerAdapterV4;

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
        handlerAdapterList.add(new HandlerAdapterV4());
    }

    private void initHandler() {
        handlerMap.put("/front-controller/v5/v3/members/new-form", new MemberFormControllerV3());
        handlerMap.put("/front-controller/v5/v3/members/save", new MemberSaveControllerV3());
        handlerMap.put("/front-controller/v5/v3/members", new MemberListControllerV3());

        handlerMap.put("/front-controller/v5/v4/members/new-form", new MemberFormControllerV4());
        handlerMap.put("/front-controller/v5/v4/members/save", new MemberSaveControllerV4());
        handlerMap.put("/front-controller/v5/v4/members", new MemberListControllerV4());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // URI ????????? ?????? ????????? ??????
        Object handler = getHandler(request);
        if(handler==null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        
        // ???????????? ???????????? ??? ?????? ????????? ??????
        HandlerAdapter handlerAdapter = getHandlerAdapter(handler);
        if(handlerAdapter == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // ??? ???????????? ???????????? ?????????????????? ???
        ModelView modelview = handlerAdapter.handle(request, response, handler);

        // ????????? ?????? ?????? ????????? ???????????? ???????????? ??????
        String viewName = modelview.getViewName();
        MyView myView = new MyView("/WEB-INF/views/"+viewName+".jsp");

        // ????????? ??????
        myView.render(modelview.getModel(), request, response);
    }

    private HandlerAdapter getHandlerAdapter(Object handler) {
        for (HandlerAdapter handlerAdapter : handlerAdapterList) {
            if(handlerAdapter.supports(handler))
                return handlerAdapter;
        }
        throw new IllegalArgumentException("handler adapter??? ?????? ??? ????????????. handler="+handler);
    }

    private Object getHandler(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        return handlerMap.get(requestURI);
    }
}

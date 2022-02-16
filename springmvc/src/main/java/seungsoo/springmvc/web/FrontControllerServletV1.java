package seungsoo.springmvc.web;

import seungsoo.springmvc.web.frontcontroller.v1.MemberFormControllerV1;
import seungsoo.springmvc.web.frontcontroller.v1.ControllerV1;
import seungsoo.springmvc.web.frontcontroller.v1.MemberListControllerV1;
import seungsoo.springmvc.web.frontcontroller.v1.MemberSaveControllerV1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name="frontControllerServletV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {

    HashMap<String, ControllerV1> controllerMap = new HashMap<>();

    public FrontControllerServletV1() {
        controllerMap.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
        controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
        controllerMap.put("/front-controller/v1/members", new MemberListControllerV1());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("FrontController.service");

        String requestURI = request.getRequestURI();
        ControllerV1 controllerV1 = controllerMap.get(requestURI);

        if(controllerV1 == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        controllerV1.process(request, response);
    }
}

package seungsoo.springmvc.web.frontcontroller.v2;

import seungsoo.springmvc.web.frontcontroller.MyView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ControllerV2 {
    MyView process(HttpServletRequest request, HttpServletResponse response);
}

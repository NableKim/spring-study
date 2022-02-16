package seungsoo.springmvc.web.frontcontroller.v3;

import seungsoo.springmvc.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {
    ModelView process(Map<String, String> paramMap);
}

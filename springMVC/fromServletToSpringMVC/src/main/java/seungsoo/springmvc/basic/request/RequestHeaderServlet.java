package seungsoo.springmvc.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        printStartLine(request);
        printRequestHeader(request);

    }

    private void printStartLine(HttpServletRequest request) {
        System.out.println("----Start Line----");
        System.out.println("request.getRequestURL() : " + request.getRequestURL());
        System.out.println("request.getRequestURI() : " + request.getRequestURI());
        System.out.println("----End----");
    }

    private void printRequestHeader(HttpServletRequest request) {
        System.out.println("----Request Header----");
        request.getHeaderNames().asIterator()
                        .forEachRemaining(headName -> System.out.println(headName + " = " + request.getHeader(headName)));
        System.out.println("----End----");
    }
}

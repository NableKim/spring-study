package seungsoo.springmvc.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setStatus(HttpServletResponse.SC_OK);

//        response.setHeader("Content-Type", "text/plan;charset=utf-8");
//        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
//        response.setHeader("Pragma", "no-cache");
//        response.setHeader("my-custom-header", "hello");

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");

        Cookie cookie = new Cookie("myCustomCookie", "hihello");
        cookie.setMaxAge(600);
        response.addCookie(cookie);

        response.sendRedirect("/basic/hello-form.html");

        response.getWriter().write("ok");
    }
}


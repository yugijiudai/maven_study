package zttc.itat.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yugi
 * @apiNote
 * @since 2017-02-28
 */
@WebServlet(name = "HelloServlet", urlPatterns = "/hello.do")
public class HelloServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("user", "龟爷");
        request.getRequestDispatcher("/WEB-INF/user/emp.jsp").forward(request, response);
    }
}

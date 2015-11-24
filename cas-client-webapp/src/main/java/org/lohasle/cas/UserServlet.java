package org.lohasle.cas;

import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.util.AssertionHolder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Administrator on 2015/11/21 0021.
 */
@WebServlet(
        name = "user",
        urlPatterns = {"/user"},
        loadOnStartup = 1
)
public class UserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        // 获取CAS用户名方式一
        String user = request.getRemoteUser();

        // 获取CAS同户名方式二
        String user2 = AssertionHolder.getAssertion().getPrincipal().getName();

        // 获取CAS返回的属性字段值
        AttributePrincipal principal = (AttributePrincipal)request.getUserPrincipal();
        Map attributes = principal.getAttributes();
        System.out.println(attributes);

        request.setAttribute("user",user);
        request.setAttribute("user2",user2);
        request.setAttribute("attributes",attributes);


        request.getRequestDispatcher("user.jsp").forward(request,response);
    }
}

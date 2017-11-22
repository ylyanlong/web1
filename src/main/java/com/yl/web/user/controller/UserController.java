package com.yl.web.user.controller;

import com.yl.web.user.entity.AccountBean;
import com.yl.web.user.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Description: Created by leon.yan on 2017/11/21.
 */
public class UserController extends HttpServlet {
    private UserService userService = new UserService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("pwd");

        if(userService.isValidUser(userName, password) ) {  // 校验通过
            AccountBean accountBean = new AccountBean();
            accountBean.setUserName(userName);
            accountBean.setPassword(password);

            // 设置 session
            HttpSession session = request.getSession();
            session.setAttribute("account", accountBean);  // 后面考虑定义为常量
            System.out.println("session:" + session);

            // 跳转设置
            // response.sendRedirect("session.jsp");
            // response.sendRedirect("/WEB-INF/views/session2.jsp");
            //
            String contextPath1 = request.getContextPath();
            String pathInfo1 = request.getPathInfo();
            String servletPath1 = request.getServletPath();
            String pathTranslated1 = request.getPathTranslated();
            System.out.println("contextPath1:" + contextPath1 + ", pathInfo1:" + pathInfo1 + ", servletPath1:" + servletPath1 +
                    ", pathTranslated1:" + pathTranslated1);
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/session2.jsp");
            dispatcher.forward(request, response);
            String contextPath2 = request.getContextPath();
            String pathInfo2 = request.getPathInfo();
            String servletPath2 = request.getServletPath();
            String pathTranslated2 = request.getPathTranslated();
            System.out.println("contextPath2:" + contextPath2 + ", pathInfo2:" + pathInfo2 + ", servletPath2:" + servletPath2 +
                    ", pathTranslated2:" + pathTranslated2);
            // 跳转的另外一种写法, 比上面分两次写要简单;  路径都给绝对路径; 如果是在 webapp 下面 如 index.jsp 直接写文件名就可以
            // request.getRequestDispatcher("/WEB-INF/views/session2.jsp").forward(request, response);
            return;  // 退出，避免执行到后面去了
        }
        // 校验不通过的情况
        // response.sendRedirect("fail.jsp");
        // response.sendRedirect("/WEB-INF/views/fail2.jsp");
        //
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/fail2.jsp");
        dispatcher.forward(request, response);
        //
        return;
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);  // 可以验下
    }


}

package com.yl.web.user.controller;

import com.yl.web.user.entity.AccountBean;
import com.yl.web.user.service.UserService;

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
            response.sendRedirect("session.jsp");
            return;  // 退出，避免执行到后面去了
        }
        // 校验不通过的情况
        response.sendRedirect("fail.jsp");
        return;
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);  // 可以验下
    }


}

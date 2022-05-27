//package com.montrell.controller;
//
//import java.io.IOException;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.montrell.model.*;
//import com.montrell.dao.*;
//
//@WebServlet("/amount")
//public class AmountServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L ;
//    private LoginDao loginDao;
//
//    public void init() {
//        loginDao = new LoginDao();
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        String user = request.getParameter("user");
//        String amount = request.getParameter("amount");
//        Login login = new Login();
//        amount.setUser(user);
//        amount.setAmount(amount);
//
//        try {
//            if (loginDao.validate(amount)) {
//                //HttpSession session = request.getSession();
//                // session.setAttribute("username",username);
//                response.sendRedirect("home.jsp");
//            } else {
//                HttpSession session = request.getSession();
//                //session.setAttribute("user", username);
//                //response.sendRedirect("login.jsp");
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//}

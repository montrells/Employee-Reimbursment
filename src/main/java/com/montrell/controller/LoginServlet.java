package com.montrell.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.montrell.model.*;
import com.montrell.dao.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LoginDao loginDao;
    //private String message;

    public void init() {
        loginDao = new LoginDao();
        //message = "Oops, Looks like you may not be registered";
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Login login = new Login();
        login.setUsername(username);
        login.setPassword(password);

        try {
            if (loginDao.validate(login)) {
                //HttpSession session = request.getSession();
                // session.setAttribute("username",username);
                response.sendRedirect("home.jsp");
            } else {
               // HttpSession session = request.getSession();
                //session.setAttribute("user", username);
                response.sendRedirect("login.jsp");
                //response.setContentType("text/html");

                // Oops

//                PrintWriter out = response.getWriter();
//                out.println("<html><body>");
//                out.println("<h1>" + message + "</h1>");
//                out.println("</body></html>");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

//    <%--<%--%>
//<%--int amount = Integer.parseInt(request.getParameter("amount"));--%>
//<%--String user = request.getParameter("user");--%>
//
//<%--try{--%>
//<%--    Class.forName("com.mysql.jdbc.Driver");--%>
//<%--    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","Password12!");--%>
//<%--    PreparedStatement p = conn.prepareStatement("insert into account(amount,user)) values(?,?)");--%>
//<%--    p.setInt(1,amount);--%>
//<%--    p.setString(2,user);--%>
//<%--    int execute = p.executeUpdate();//print how many rows affected--%>
//<%--    if(execute > 0){--%>
//<%--        System.out.println("Added successfully");--%>
//<%--    }else{--%>
//<%--        System.out.println("Failed to add data to the database");--%>
//<%--    }--%>
//<%--}catch (Exception e){--%>
//<%--    System.out.println(e);--%>
//<%--}--%>
//<%--%>--%>

//}

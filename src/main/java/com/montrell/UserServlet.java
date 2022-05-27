package com.montrell;

import com.montrell.dao.LoginDao;
import com.montrell.model.Login;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Servlet implementation class UserControllerServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDao loginDao;
	private UserDao userDao;
	
	@Resource(name="jdbc/testreimbursmentsystem")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();

		// create our user db util ... and pass in the conn pool / datasource
		try {
			userDao = new UserDao(dataSource);
			loginDao = new LoginDao();
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			
			// if the command is missing, then default to listing users
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			// route to the appropriate method
			switch (theCommand) {
			
			case "LIST":
				listUsers(request, response);
				break;
				
			case "ADD":
				addUser(request, response);
				break;
				
			case "LOAD":
				loadUser(request, response);
				break;
				
			case "UPDATE":
				updateUser(request, response);
				break;
			
			case "DELETE":
				deleteUser(request, response);
				break;
				
			default:
				listUsers(request, response);
			}
				
		}
		catch (Exception exc) {
			 throw new ServletException(exc);
		}

	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read user id from form data
		String theUserId = request.getParameter("userId");
		
		// delete user from database
		userDao.deleteUser(theUserId);
		
		// send them back to "list users" page
		listUsers(request, response);
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read user info from form data
		 int id = Integer.parseInt(request.getParameter("userId"));
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		// create a new user object
		User theUser = new User(id,first_name, last_name,username,password, email);

		// perform update on database
		userDao.updateUser(theUser);

		// send them back to the "list users" page
		listUsers(request, response);
		
	}

	private void loadUser(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read user id from form data
		String theUserId = request.getParameter("userId");
		
		// get user from database (db util)
		User theUser = userDao.getUser(theUserId);
		
		// place user in the request attribute
		request.setAttribute("THE_USER", theUser);
		
		// send to jsp page: update-user-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-user-form.jsp");
		dispatcher.forward(request, response);		
	}

	private void addUser(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read user info from form data
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		// create a new user object
		User theUser = new User(first_name, last_name, username, password,email);

		// add the user to the database
		userDao.addUser(theUser);

		// send back to main page (the user list)
		listUsers(request, response);
	}

	private void listUsers(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// get users from db util
		List<User> users = userDao.getUsers();
		
		// add users to the request
		request.setAttribute("USER_LIST", users);
				
		// send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-users.jsp");
		dispatcher.forward(request, response);
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
				HttpSession session = request.getSession();
				//session.setAttribute("user", username);
				response.sendRedirect("login.jsp");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}














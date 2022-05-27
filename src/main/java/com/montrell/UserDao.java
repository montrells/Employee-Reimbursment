package com.montrell;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class UserDao {

	private DataSource dataSource;

	public UserDao(DataSource theDataSource) {
		dataSource = theDataSource;
	}



	public List<User> getUsers() throws Exception {
		
		List<User> users = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();

			// create sql statement
			String sql = "select * from users order by last_name";

			myStmt = myConn.createStatement();

			// execute query
			myRs = myStmt.executeQuery(sql);

			// process result set
			while (myRs.next()) {

				// retrieve data from result set row
				int id = myRs.getInt("id");
				String first_name = myRs.getString("first_name");
				String last_name = myRs.getString("last_name");
				String username = myRs.getString("username");
				String password = myRs.getString("password");
				String email = myRs.getString("email");

				// create new user object
				User tempUser= new User(id, first_name, last_name, username, password, email);

				// add it to the list of users
				users.add(tempUser);
			}
			
			return users;
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}		
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();   // doesn't really close it ... just puts back in connection pool
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public void addUser(User theUser) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get db connection
			myConn = dataSource.getConnection();



			// create sql for insert
			String sql = "insert into users "
					+ "(first_name, last_name, username, password, email,user_roll_id) "
					+ "values (?, ?, ?,?,?,?)";

			myStmt = myConn.prepareStatement(sql);

			// set the param values for the user
			myStmt.setString(1, theUser.getFirst_name());
			myStmt.setString(2, theUser.getLast_name());
			myStmt.setString(3, theUser.getUsername());
			myStmt.setString(4, theUser.getPassword());
			myStmt.setString(5, theUser.getEmail());
			myStmt.setInt(6, theUser.getUser_roll_id());

			// execute sql insert
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public User getUser(String theUserId) throws Exception {

		User theUser = null;
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int userId;
		
		try {
			// convert user id to int
			userId = Integer.parseInt(theUserId);
			
			// get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to get selected user
			String sql = "select * from users where id=?";
			
			// create prepared statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, userId);
			
			// execute statement
			myRs = myStmt.executeQuery();
			
			// retrieve data from result set row
			if (myRs.next()) {
				String first_name = myRs.getString("first_name");
				String last_name = myRs.getString("last_name");
				String username = myRs.getString("username");
				String password = myRs.getString("password");
				String email = myRs.getString("email");

				// use the userId during construction
				theUser = new User(userId, first_name, last_name, email);
			}
			else {
				throw new Exception("Could not find user id: " + userId);
			}

			return theUser;
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, myRs);
		}
	}

	public void updateUser(User theUser) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();

			// create SQL update statement
			String sql = "update users "
					+ "set first_name=?, last_name=?, username=?, password=?,email=? "
					+ "where id=?";

			// prepare statement
			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setString(1, theUser.getFirst_name());
			myStmt.setString(2, theUser.getLast_name());
			myStmt.setString(3, theUser.getUsername());
			myStmt.setString(4, theUser.getPassword());
			myStmt.setString(5, theUser.getEmail());
			myStmt.setInt(6, theUser.getId());

			// execute SQL statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public void deleteUser(String theUserId) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// convert user id to int
			int userId = Integer.parseInt(theUserId);
			
			// get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to delete user
			String sql = "delete from users where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, userId);
			
			// execute sql statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC code
			close(myConn, myStmt, null);
		}	
	}
/**
 * Testing USERDAO
 * **/

public UserDao(Connection connection) {
	this.connection=connection;
}

public UserDao() {

}
private Connection connection;


    public User save(User user) {
		String sql= "insert into users(first_name,last_name,username,password,email) values(?,?,?,?,?)";
		try {
			PreparedStatement state = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			state.setString(1,user.getFirst_name());
			state.setString(2,user.getLast_name());
			state.setString(3,user.getUsername());
			state.setString(4,user.getPassword());
			state.setString(5,user.getEmail());
			int numOfrecordsAffected = state.executeUpdate();
			ResultSet r = state.getGeneratedKeys();
			while (r.next()){ //looking for the generated key to pull out
				int person_id = r.getInt(1);// only one column and id per record
				//set the id on the person class
				user.setId(person_id);
				//prints out the person after setting the ID thanks to the Persons class toString method
				System.out.println(user);
			}
			System.out.printf("Records affected: %d%n", numOfrecordsAffected);//output to see what is going on
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;

    }

	//Junit Test Constructor

}
















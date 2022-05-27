package com.montrell;
import com.montrell.User;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.ZonedDateTime;

import com.montrell.UserDao;
import static org.assertj.core.api.Assertions.assertThat;


public class UserDaoTest {


    private Connection connection;

    @Before
    public void setUp() throws Exception {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testreimbursmentsystem", "root", "Password12!");
    }
    /*CLOSING THE DATABASE CONNECTION
     * @Before and @After is acts like a try-catch-finally block
     */
    @After
    public void tearDown() throws Exception {
        if(connection != null){
            connection.close();
        }
    }

    @Test
    public void canSaveOneUser() throws SQLException {
        UserDao dao = new UserDao(connection);
        User jimmy = new User("Jimmy", "Jones", "Jay", "jimmy", "jay@randle.com");
        dao.save(jimmy);
        User savedPerson = dao.save(jimmy);
        assertThat(savedPerson.getId()).isGreaterThan(0);

    }
    @Test
    public void saveTwoPersonNotEqualID() throws SQLException {
        UserDao dao = new UserDao(connection);
        //Creating a connection to the database.
        User jimmy = new User("Jimmy", "Jones", "Jay", "jimmy", "jay@randle.com");
        User biggie = new User("Biggie", "Man", "Biggie", "11111", "IamBig@.Yahoo.com");
        User savedPerson = dao.save(jimmy);
        User savedPerson2 = dao.save(biggie);
        assertThat(savedPerson.getId()).isNotEqualTo(savedPerson2.getId());

    }




}


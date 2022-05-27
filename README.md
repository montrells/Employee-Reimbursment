# Project 1 - Employee Reimbursment System (ERS)-RMMS

## Executive Summary
The Expense Reimbursement System (ERS) will manage the process of reimbursing employees for expenses incurred while on company time. All employees in the company can login and submit requests for reimbursements and view their past tickets and pending requests. Finance managers can log in and view all reimbursement users. The finance managers should also be able to Create, Read, Update and Delete any user on the system. 


# Tech Stack
 - Java 8
 - Apache Maven
 - AWS RDS
 - Java Servlets
 - JDBC
 - HTML
 - CSS
 - JavaScript
 - AJAX / Fetch API
 - Java Server Pages (JSP's)

# Features
 - Domain objects persisted in relational database
 - Database should be in 3NF
 - CRUD functionality for all domain objects
 - All CRUD functionality accessible via RESTful API
 - Functional web UI to consume RESTful API
 - Validate all user input
 - Unit test coverage for service-layer classes

The persistence-layer system use JDBC to connect to a MySql database. The API-layer utilizes Java servlets to expose a public interface. The front-end view uses HTML/CSS/JavaScript/JSP's to make an application that can call server-side components in a generally RESTful manner. The middle tier follows proper layered architecture, and have JUnit test to verify user persistance into the database. Webpages is styled to be functional and readable. 


#### System Users:
 - Should be deleted when no longer needed on the system
 - User should be able to log in to the system
 - User will be able to change profile information
 - User will be able to create an account on the system
 - The user information will persist on the database

#### Getting Started
 - Make sure you use a server like Tomcat
 - MySQL database 
 - IDE preferably Intellij
 - Make sure your IDE knows where to find the sql-connector
 - Connect your IDE with the database schema of your choice
 
# Usage
-Images should look like the below images:
# Add User
![Add User](https://user-images.githubusercontent.com/15221031/168384107-ec6383f6-0d98-4fd2-b32d-f116c86992d2.png)


# Update User


![Update User](https://user-images.githubusercontent.com/15221031/168384385-9c0ca458-ca9a-4c7a-af94-10dc42064465.png)

# Login
![Login](https://user-images.githubusercontent.com/15221031/168384694-38817dcd-8618-4b66-8b97-23a30ed9416d.png)



# List of Users
![User List](https://user-images.githubusercontent.com/15221031/168384770-cc3e10fc-9008-4542-b54a-4ecf52bd2203.png)




# Contributors
-Montrell Story

# License


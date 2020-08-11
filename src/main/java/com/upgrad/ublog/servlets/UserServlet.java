package com.upgrad.ublog.servlets;

/**
 * TODO: 4.5. Modify the class definition to make it a Servlet class (through inheritance) and
 *  override doPost() method from the base class.
 * TODO: 4.6. Retrieve the values of form attributes defined in the index.jsp file
 * TODO: 4.7. Check if password is empty or null. If empty or null, then redirect to
 *  the index.jsp file with an error message "Password is a required field".
 *  (Hint: Store the error message as an attribute inside the request object before redirecting
 *  to the index.jsp. This error message will be displayed in the index.jsp page when this
 *  error arises.)
 * TODO: 4.8. If Sign In button is clicked, print "User Signed In" with the user
 *  details on the console. Also, store the email id in the session object.
 * TODO: 4.9. If Sign Up button is clicked, then print "User Signed Up" with the
 *  user details on the console. Also, store the email id in the session object.
 * TODO: 4.10. Check if the user is logged in or not. If yes, then redirect them
 *  to the Home.jsp file. (Hint: Make use of the email id stored in the session object to check if
 *  the user is logged in or not. This email id should be stored in the session object when the user
 *  successfully sign in or sign up.)
 */

/**
 * TODO: 5.4. Validate the email id that is retrieved from the request object using the
 *  EmailValidator class. If the email is not valid, then redirect the user to the Sign In/
 *  Sign Up page with the error message that is stored in the EmailNotValidException. This error
 *  message should be displayed on the index.jsp page.
 *  Note: Add the return statement after you redirect to the index.jsp page, otherwise you may get error
 * TODO: 5.5. Map this Servlet to "/ublog/user" url using the @WebServlet annotation.
 * TODO: 5.6: Remove the same mapping from the Deployment Descriptor otherwise, you will get an error.
 */

import com.upgrad.ublog.db.DatabaseConnection;
import com.upgrad.ublog.dto.UserDTO;
import com.upgrad.ublog.exceptions.EmailNotValidException;
import com.upgrad.ublog.services.ServiceFactory;
import com.upgrad.ublog.services.UserService;
import com.upgrad.ublog.utils.EmailValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

/**
 * TODO: 6.16. When the user click on the Sign In button on the Sign In/ Sign Up page, handle the
 *  following scenarios. (Hint: Use ServiceFactory to get UserService. Override the init() method
 *  to instantiate the UserService attribute.)
 *  1. If the user's email is not found in the database, display "No user registered with the given email address!"
 *   message on the Sign In/ Sign Up page. (Hint: You should load this message in the request object as an attribute
 *   and redirect to the index.jsp page.)
 *  2. If the user's email is registered but the password is incorrect, display "Please enter valid credentials"
 *   message on the Sign In/ Sign Up page.
 *  3. If the user's credentials are correct, then redirect the user to the Home.jsp page.
 *   Note: In this if condition, you should set the email id in the session object.
 *
 * TODO: 6.17. When the user click on the Sign Up button on the Sign In/ Sign Up page, handle the
 *  following scenarios.
 *  1. If the user's email is already registered on the database, display
 *   "A user with this email address already exists!" message on the Sign In/ Sign Up page.
 *  2. If the user's email is unregistered, then store the user's details in the database and
 *   redirect the user to the Home.jsp page.
 *   Note: In this if condition, you should set the email id in the session object.
 *
 *  TODO 6.18: If UserService is not able to process the request and throws an exception, get the
 *   message stored in the exception object and display the same message on the index.jsp page.
 */
@WebServlet("/ublog/user")
public class UserServlet extends HttpServlet {

    UserService userService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        if(httpSession.getAttribute("userEmail") != null) {
            resp.sendRedirect("/Home.jsp");
        }

        String userEmail = req.getParameter("userEmail");
        String password = req.getParameter("password");
        String actionType = req.getParameter("actionType");
        //resp.getWriter().println(userEmail);

        try {
            EmailValidator.isValidEmail(userEmail);
        } catch(EmailNotValidException ex) {
            req.setAttribute("isError",true);
            req.setAttribute("errorMessage",ex.getMessage());
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
            return;
        }
        if(password==null|| password.isEmpty()) {
            req.setAttribute("isError",true);
            req.setAttribute("errorMessage","Password is a required field");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
            return;
        }

// Sign In Part

        if(actionType.equals("Sign In")) {
            httpSession.setAttribute("userEmail",userEmail);
            resp.getWriter().println("User Signed In");
            resp.getWriter().println("userEmail " + userEmail);
            boolean regEmail = true;
            boolean valid = true;
            try {
                Connection connection=DatabaseConnection.getConnection();
                String emailRegisteredQuery = "SELECT * FROM UBLOG_USERS WHERE email_id = ?";
                PreparedStatement statement = connection.prepareStatement(emailRegisteredQuery);
                statement.setString(1,userEmail);
                ResultSet resultSet = statement.executeQuery();
                regEmail = resultSet.next();
                String validLogin ="SELECT * FROM UBLOG_USERS WHERE email_id = ? and password = ?";
                statement = connection.prepareStatement(validLogin);
                statement.setString(1,userEmail);
                statement.setString(2,password);
                resultSet = statement.executeQuery();
                valid = resultSet.next();
            } catch(SQLException ex) {}
            if(!regEmail) {
                req.setAttribute("isError",true);
                req.setAttribute("errorMessage","No user registered with the given email address!");
                req.getRequestDispatcher("/index.jsp").forward(req,resp);
                return;
            }
            else if(!valid) {
                req.setAttribute("isError",true);
                req.setAttribute("errorMessage","Please enter valid credentials");
                req.getRequestDispatcher("/index.jsp").forward(req,resp);
                return;
            }
            else {
                httpSession.setAttribute("userEmail",userEmail);
                req.getRequestDispatcher("/Home.jsp").forward(req,resp);
                return;
            }

        }
//Sign Up Part

        else {
            httpSession.setAttribute("userEmail",userEmail);
            resp.getWriter().println("User Signed Up");
            resp.getWriter().println("userEmail " + userEmail);
            try {
                Connection connection=DatabaseConnection.getConnection();
                String emailRegisteredQuery = "SELECT * FROM UBLOG_USERS WHERE email_id = ?";
                PreparedStatement statement = connection.prepareStatement(emailRegisteredQuery);
                statement.setString(1,userEmail);
                ResultSet resultSet = statement.executeQuery();
                boolean regEmail = resultSet.next();
                if(!regEmail) {
                    String query = "INSERT INTO UBLOG_USERS(id, email_id, password) VALUES (?,?,?)";
                    statement = connection.prepareStatement(query);
                    statement.setInt(1,1);
                    statement.setString(2,userEmail);
                    statement.setString(3,password);
                    statement.executeUpdate();
                    req.getRequestDispatcher("/Home.jsp").forward(req,resp);
                }
                else {
                    req.setAttribute("isError",true);
                    req.setAttribute("errorMessage","A user with this email address already exists!");
                    req.getRequestDispatcher("/index.jsp").forward(req,resp);
                    return;
                }
            }
            catch(Exception ex) {
                req.setAttribute("isError",true);
                req.setAttribute("errorMessage",ex.getMessage());
                req.getRequestDispatcher("/index.jsp").forward(req,resp);
                return;
            }
        }
    }

    @Override
    public void init() throws ServletException {
        ServiceFactory serviceFactory = new ServiceFactory();
        userService = serviceFactory.createUserService();
    }


}

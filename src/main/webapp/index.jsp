<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    /*If user tries to click on browser back button then he/ she should not be able to access this page*/
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>

<!--
	TODO: 4.11. If a user is already logged in then, redirect the user to the Home.jsp page directly.
	(Hint: Make use of the email id stored in the session object. This email id should be stored in
	the session object when the user successfully signs in or sign up.)
-->

<!--
	TODO: 4.4. Design the "Sign In / Sign Up" page with following properties.
	    1. Title of the page should be "Sign In / Sign Up"
	    2. Provide method and action attributes of the form tag such that when user submit
	        the form, the doPost() method of UserServlet get invoked.
	    3. Provide "User Email:" label along with the text field as shown on the learn platform.
	    4. Also, for the "User Email:" text field, provide placeholder as "example@email.com" and
	        make this field required.
	    5. Provide "Password:" label along with the text field as shown on the learn platform.
        6. Also, for the "Password:" text field, provide type as password, placeholder as "********"
            and make this field required.
        7. Use the table tag to align the labels and text fields.
        8. Provide "Sign In" and "Sign Up" submit buttons.
-->
<html>
<head>
    <title>Sign In / Sign Up</title>
</head>

<body>
<form method="POST" action="/ublog/user">
    <table>
        <tr>
            <td><label for="userEmail">User Email:</label></td>
            <td><input type="text" placeholder="example@email.com" required name="userEmail" id="userEmail"/></td>
        </tr>

        <tr>
            <td><label for="password">Password:</label></td>
            <td><input type="password" placeholder="********" required name="password" id="password"/></td>
        </tr>
    </table>

    <input type="submit" value="Sign In" name="actionType"/>
    <input type="submit" value="Sign Up" name="actionType"/>
    <%
    try {
        if((Boolean)request.getAttribute("isError")) {
            out.println((String)request.getAttribute("errorMessage"));
        }
    } catch(NullPointerException e) {
    }
    %>
</form>
</body>
</html>

<!--
    TODO: 4.12. Write the Java code to display the error message present in the request object. The
    error message should be displayed below the Sign In and Sing Up buttons. These error messages
    will be set inside the UserServlet. There can be multiple error messages such as
    "No user registered with the given email address!" when a user tries to log in using an
    email address which is not registered in the database. The java code should be able to print
    all such kinds of error messages.
-->
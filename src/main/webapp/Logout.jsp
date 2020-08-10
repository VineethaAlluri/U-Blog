<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!--
    TODO: 4.27. Implement the Java logic, such that when the Logout hyperlink on the
    Home.jsp is clicked, the session is invalidated and user is redirected to the
    Sign In/ Sign Up page.
-->
<% session.setAttribute("userEmail", false);
   response.sendRedirect("/index.jsp"); %>
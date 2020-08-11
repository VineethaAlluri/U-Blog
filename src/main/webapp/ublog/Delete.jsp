<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    /*If user tries to click on browser back button then he/ she should not be able to access this page*/
    response.setHeader("Cache-Control","no-cache");
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader ("Expires", 0);
%>

<!--
	TODO: 7.16. Check if user is logged in or not. If not then redirect user to the default page i.e index.jsp.
	(Hint: You need to handle NullPointerException.)
	(Hint: Make use of the email id stored in the session object to check if user is logged in or not.)
-->
<%
    try {

        if(session.getAttribute("userEmail") == null) {
                    response.sendRedirect("/index.jsp");
                }
    } catch(NullPointerException ex) {
        response.sendRedirect("/index.jsp");
    }
%>
<!--
	TODO: 7.17. Design the "Delete Post" page with the following properties.
	    1. Title of the page should be "Delete Post"
	    2. Provide method and action attributes of the form tag such that when user submit
	        the form, the doPost() method of PostUtilServlet get invoked.
	    3. Provide "Post Id:" label along with the text field as shown on the learn platform.
	    4. Also, for the "Post Id:" text field, provide type as number, min as 1, placeholder as
	        "Post Id" and make this field required.
	    5. Provide a "Delete" submit button.
        6. Provide a link to the "Home Page".
-->

<!--
    TODO: 7.18. If the user is logged in then display the string before @ in the user email id
    on this web page. For example, if email id is example@gmail.com, then display "Logged In as example"
    in the top left corner of the web page as shown on the learn platform.
-->

<!--
    TODO: 7.20. Check if there exists an error message in the request object. If so, then display the message
    below the Delete button.
    TODO: 7.21. Check if there exists a normal message in the request object. If so, then display the message
    below the Delete button.
-->

<html>
       <head>
            <title>Delete Post</title>
       </head>
       <body>
            <%
                try {
                    String email[] = session.getAttribute("userEmail").toString().split("@");
                    out.println("Logged In as " + email[0]);
                    } catch(NullPointerException ex) {
                }
            %>
            <br><br>
            <form method="POST" action="/ublog/post/util">
                <table>
                    <tr>
                        <td><label for="deleteId">Post Id :</label></td>
                        <td><input type="number" placeholder="post Id" required name="deleteId" /></td>
                    </tr>
                    <tr>
                    <td><input type="submit" value="Delete" name="actionType"/></td>
                    </tr>
                </table>

            </form>
            <a href="/Home.jsp">Home Page </a>
            <br><br>
                <%
                try {
                    if((Boolean)request.getAttribute("isError")) {
                        out.println((String)request.getAttribute("errorMessage"));
                    }
                } catch(NullPointerException e) {
                }
                try {
                    if((Boolean)request.getAttribute("postDeletionStatus")) {
                        out.println((String)request.getAttribute("normalMessage"));
                    }
                } catch(NullPointerException e) {
                }
                %>
       </body>
</html>
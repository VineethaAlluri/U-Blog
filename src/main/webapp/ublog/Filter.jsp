<%@ page import="com.upgrad.ublog.dto.PostDTO" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.List" %>
<%@ page import="com.upgrad.ublog.utils.DateTimeFormatter" %>
<%@ page import="com.upgrad.ublog.services.ServiceFactory" %>
<%@ page import="com.upgrad.ublog.services.PostService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    /*If user tries to click on browser back button then he/ she should not be able to access this page*/
    response.setHeader("Cache-Control","no-cache");
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader ("Expires", 0);
%>

<!--
	TODO: 7.26. Check if user is logged in or not. If not then redirect user to the default page i.e index.jsp.
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
	TODO: 7.27. Design the "Filter Post" page with the following properties.
	    1. Title of the page should be "Filter Post"
	    2. Provide method and action attributes of the form tag such that when user submit
	        the form, the doPost() method of PostUtilServlet get invoked.
	    3. Provide "Select tag:" label along with the dropdown menu as shown on the learn platform.
	    4. Also, for the dropdown menu, load all the unique tags using the getAllTags() method of the
	        PostService class. (Note: You should use ServiceFactory to get the PostService object)
	    5. Provide a "Filter" submit button.
        6. Provide a link to the "Home Page".
-->

<!--
    TODO: 7.28. If the user is logged in then display the string before @ in the user email id
    on this web page. For example, if email id is example@gmail.com, then display "Logged In as example"
    in the top left corner of the web page as shown on the learn platform.
-->

<!--
    TODO: 7.30. Check if there exists an error message in the request object. If so, then display the message
    below the Filter button.
    TODO: 7.31. Check if posts exist in the request object. If so, then display the posts as shown on the learn
    platform.
     Note: Use the table tag to align the fields.
     Note: Try to provide a horizontal rule or some spacing between the posts as shown on the learn platform.
-->
<html>
       <head>
            <title>Filter Post</title>
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
                        <td><label for="selectTag">Select Tag :</label></td>
                        <td>
                        <select name="tag" id="tag">
                           <option value="java">Java</option>
                           <option value="ms">MS</option>
                         </select>
                        </td>
                    </tr>
                    <tr>
                    <td><input type="submit" value="Filter" name="actionType"/></td>
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
                %>
                <table>
                <%
                try{
                    if((Boolean)request.getAttribute("PostFound")) {
                    List<PostDTO> list = request.getAttribute("searchPostResults");
                    for(int i=0; i<list.size() ;i++ )  { %>
                    <tr>
                    <td><label for="postId">Post Id :</label></td>
                    <td><% out.println(list.get(i).getPostId()); %></td>
                    </tr>
                    <tr>
                    <td><label for="userEmail">User Email:</label></td>
                    <td><% out.println(list.get(i).getEmailId()); %></td>
                    </tr>
                    <tr>
                    <td><label for="title">Title :</label></td>
                    <td><% out.println(list.get(i).getTitle()); %></td>
                    </tr>
                    <tr>
                    <td><label for="tag">Tag :</label></td>
                    <td><% out.println(list.get(i).getTag()); %></td>
                    </tr>
                    <tr>
                    <td><label for="desc">Description :</label></td>
                    <td><% out.println(list.get(i).getDescription()); %></td>
                    </tr>
                    <tr>
                    <td><label for="time">User Email:</label></td>
                    <td><% out.println(list.get(i).getTimestamp()); %></td>
                    </tr>
                    <tr>
                    <td><hr></td>
                    <td><hr></td>
                    </tr>
                    <% }
                %>
            </table>
       </body>
</html>
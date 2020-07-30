package com.upgrad.ublog.servlets;

/**
 * TODO 4.18: Modify the class definition to make it a Servlet class (through inheritance).
 * TODO 4.19: Override doPost() method from the base Class and implement the following TODOs in this method.
 * TODO 4.20: Check if the user is logged in or not. If not, then redirect them to the
 *  login page. (Hint: Make use of session object)
 * TODO 4.21: Retrieve all the relevant information from the request object and create a
 *  new PostDTO object.
 *  (Note: 1. For now, you can set the postId attribute of the newly created PostDTO object
 *  as (int) 1. You will soon know the reason behind it.)
 *  (Note: 2. You can set the timestamp attribute of the newly created PostDTO object using
 *  LocalDateTime.now(). This method will fetch you the current date and time. Later in the
 *  session, you will learn in detail the use of this method.)
 * TODO 4.22. Print the PostDTO object's data on the console.
 * TODO 4.23. You should also redirect the user to the "View.jsp" page and pass the PostDTO
 *  object along with the request. View page will be created later in the project and
 *  display the blog posted by the user.
 */

/**
 * TODO: 5.7. Map this Servlet to "/ublog/post" url using the @WebServlet annotation.
 * TODO: 5.8: Remove the same mapping from the Deployment Descriptor.
 */

/**
 * TODO: 6.26. Store the post details into the database using PostService that is received from the
 *  Create.jsp page and then redirect the user to the View.jsp page. (Hint: Use ServiceFactory to get
 *  Post Service. Override the init() method to instantiate the PostService attribute.)
 */

/**
 * TODO 8.2: After saving post details into the database and before you redirect the
 *  user to the View.jsp page, you should write logs into the following format.
 *  <formatted timestamp for that post><\t>New post with title [ <title for that post> ] created by [ <emailId of the creator> ]
 *  (Hint: you should use the LogWriter object)
 *  (Hint: Use the following method to get the user's current directory. All the logs should be stored
 *  in the file that is located at the following directory.
 *  System.getProperty("user.dir")
 *  Print the "System.getProperty("user.dir")" to know where the log file is created.
 */

/**
 * TODO 9.1: Modify the existing code such that the following two operations occur simultaneously on
 *  two independent threads.
 *  thread1: Saving data into the database
 *  thread2: Writing logs into the file
 */

public class PostServlet {

}
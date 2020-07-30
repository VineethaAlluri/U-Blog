package com.upgrad.ublog.dao;

/**
 * TODO: 6.19. Implement the PostsDAO interface and implement this class using the Singleton pattern.
 *  (Hint: Should have a private no-arg Constructor, a private static instance attribute of type
 *  PostDAOImpl and a public static getInstance() method which returns the instance attribute.)
 *   Note: getPostDAO() method of the DAOFactory should return the PostDAOImpl object using
 *   getInstance() method of the PostDAOImpl class
 * TODO: 6.20. Define the following methods and return null for each of them. You will provide a
 *  proper implementation for each of these methods, later in this project.
 *  a. findByEmail()
 *  b. findByTag()
 *  c. findAllTags()
 *  d. findById()
 *  e. deleteById() (return false for this method for now)
 * TODO: 6.21. create() method should take post details as input and insert these details into
 *  the UBLOG_POSTS table. Return the same PostDTO object which was passed as an input argument.
 *  (Hint: You should get the connection using the DatabaseConnection class)
 */

/**
 * TODO: 7.1. Implement findByEmail() method which takes email id as an input parameter and
 *  returns all the posts corresponding to the email id from the UBLOG_POSTS table defined
 *  in the database.
 */

/**
 * TODO: 7.13. Implement the deleteById() method which takes post id as an input argument and delete
 *  the corresponding post from the database. If the post was deleted successfully, then return true,
 *  otherwise, return false.
 * TODO: 7.14. Implement the findById() method which takes post id as an input argument and return the
 *  post details from the database. If no post exists for the given id, then return an PostDTO object
 *  without setting any of its attributes.
 */

/**
 * TODO: 7.22. Implement findAllTags() method which returns a list of all unique tags in the UBLOG_POSTS
 *  table.
 * TODO: 7.23. Implement findByTag() method which takes "tag" as an input argument and returns all the
 *  posts corresponding to the input "tag" from the UBLOG_POSTS table defined in the database.
 */

public class PostDAOImpl {

}

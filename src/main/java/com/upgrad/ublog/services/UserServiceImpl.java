package com.upgrad.ublog.services;

/**
 * TODO: 6.10. Implement the UserService interface and implement this class using the Singleton pattern.
 *  (Hint: Should have a private no-arg Constructor, a private static instance attribute of type
 *  UserServiceImpl and a public static getInstance() method which returns the instance attribute.)
 * TODO: 6.11. Provide an attribute of type UserDAO and instantiate it using the DAOFactory class.
 *  Note: You should not have any reference to UserDAOImpl in this class.
 * TODO: 6.12. getUser() method should take email id as an input parameter and return the user
 *  details corresponding to the email id using the findByEmail() method of the UserDAO interface.
 *  Note: The exception passed by DAO layer should not be passed to presentation layer. Print the stack
 *  trace corresponding to the exception passed by DAO layer and throw a new exception of type Exception
 *  with a message "Some unexpected error occurred!"
 * TODO: 6.13. saveUser() method should take user details as input and insert these details into the
 *  database using create() method of the UserDAO interface. Return the UserDTO object which was returned
 *  by the create() method.
 *  Note: The exception passed by DAO layer should not be passed to presentation layer. Print the stack
 *  trace corresponding to the exception passed by DAO layer and throw a new exception of type Exception
 *  with a message "Some unexpected error occurred!"
 */

public class UserServiceImpl {

}

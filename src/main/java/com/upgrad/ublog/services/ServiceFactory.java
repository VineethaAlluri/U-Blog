package com.upgrad.ublog.services;

/**
 * TODO: 6.14. Provide a factory method which returns PostServiceImpl object. (Hint: Return type
 *  of this method should be PostService. You will implement the PostService interface to the PostServiceImpl
 *  later in the project.)
 * TODO: 6.15. Provide a factory method which returns UserServiceImpl object. (Hint: Return type
 *  of this method should be UserService. It should return the object of UserServiceImpl using the
 *  getInstance() method of UserServiceImpl class.)
 */

public class ServiceFactory {

    public PostService createPostService() {
        return PostServiceImpl.getInstance();
    }

    public UserService createUserService() {
        return UserServiceImpl.getInstance();
    }
}

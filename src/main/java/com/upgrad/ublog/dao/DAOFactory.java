package com.upgrad.ublog.dao;

import com.upgrad.ublog.dto.PostDTO;

/**
 * TODO: 6.8. Provide a factory method which returns PostDAOImpl object. (Hint: Return type
 *  of this method should be PostDAO. You will implement the PostDAO interface to the PostDAOImpl
 *  later in the project.)
 * TODO: 6.9. Provide a factory method which returns UserDAOImpl object. (Hint: Return type
 *  of this method should be UserDAO. It should return the object of UserDAOImpl using the
 *  getInstance() method of UserDAOImpl class.
 */

public class DAOFactory {
    public PostDAO createPostDAO() {
        return PostDAOImpl.getInstance();
    }

    public UserDAO createUserDAO() {
        return UserDAOImpl.getInstance();
    }
}

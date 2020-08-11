package com.upgrad.ublog.services;

/**
 * TODO: 6.22. Implement the PostService interface and implement this class using the Singleton pattern.
 *  (Hint: Should have a private no-arg Constructor, a private static instance attribute of type
 *  PostServiceImpl and a public static getInstance() method which returns the instance attribute.)
 *   Note: getPostService() method of the ServiceFactory should return the PostServiceImpl object using
 *   getInstance() method of the PostServiceImpl class
 * TODO: 6.23. Provide an attribute of type PostDAO and instantiate it using the DAOFactory class.
 *  Note: You should not have any reference to PostDAOImpl in this class.
 * TODO: 6.24. Define the following methods and return null for each of them. You will provide a
 *  proper implementation for each of these methods, later in this project.
 *  a. getPostsByEmail()
 *  b. getPostsByTag()
 *  c. getAllTags()
 *  d. deletePost() (return false for this method for now)
 * TODO: 6.25. save() method should take post details as input and insert these details into
 *  the database using the create() method of PostDAO interface. Return the PostDTO object which
 *  was returned by the create() method.
 *  Note: The exception passed by DAO layer should not be passed to presentation layer. Print the stack
 *  trace corresponding to the exception passed by DAO layer and throw a new exception of type Exception
 *  with a message "Some unexpected error occurred!"
 */

/**
 * TODO: 7.2. Implement getPostsByEmail() method which takes email id as an input parameter and
 *  returns all the posts corresponding to the email id using the findByEmail() method of PostDAO interface.
 *  Note: The exception passed by DAO layer should not be passed to presentation layer. Print the stack
 *  trace corresponding to the exception passed by DAO layer and throw a new exception of type Exception
 *  with a message "Some unexpected error occurred!"
 */

/**
 * TODO: 7.15. Implement deletePost() method which takes post id and email id as an input parameter.
 *  1. Get the post corresponding to the post id using the findById() method of the PostDAO interface.
 *  2. If no post exists corresponding the post id, then throw a new PostNotFoundException with
 *   "No Post exist with the given Post Id" message.
 *  3. If the post was created by the same user whose email id is passed as an input argument, then delete
 *   the post using deleteById() method of PostDAO and return the same boolean value returned by the deleteById()
 *   method.
 *  4. If the post was not created by the same user whose email id is passed as an input argument, don't delete
 *   the post, and return false.
 *  Note: The exception passed by DAO layer should not be passed to presentation layer. Print the stack
 *  trace corresponding to the exception passed by DAO layer and throw a new exception of type Exception
 *  with a message "Some unexpected error occurred!"
 */

/**
 * TODO: 7.24. Implement the getAllTags() method which retrieves the list of all the tags from the database using the
 *  findAllTags() method of PostDAO interface and return a set of unique tags.
 *  Note: The exception passed by DAO layer should not be passed to presentation layer. Print the stack
 *  trace corresponding to the exception passed by DAO layer and throw a new exception of type Exception
 *  with a message "Some unexpected error occurred!"
 */

import com.upgrad.ublog.dao.DAOFactory;
import com.upgrad.ublog.dao.PostDAO;
import com.upgrad.ublog.dto.PostDTO;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/**
 * TODO: 7.25. Implement getPostsByTag() method which takes tag as an input parameter and
 *  returns all the posts corresponding to the tag using the findByTag() method of PostDAO interface.
 *  Note: The exception passed by DAO layer should not be passed to presentation layer. Print the stack
 *  trace corresponding to the exception passed by DAO layer and throw a new exception of type Exception
 *  with a message "Some unexpected error occurred!"
 */

public class PostServiceImpl implements PostService{

    private PostServiceImpl() {}

    private static PostServiceImpl instance;

    public static PostServiceImpl getInstance() {
        return instance;
    }

    DAOFactory daoFactory = new DAOFactory();
    PostDAO postDAO = daoFactory.createPostDAO();

    @Override
    public PostDTO save(PostDTO postDTO) throws Exception {
        try {
            return postDAO.create(postDTO);
        } catch(SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Some unexpected error occurred!");
        }
    }

    @Override
    public List<PostDTO> getPostsByEmail(String emailId) throws Exception {
        return null;
    }

    @Override
    public List<PostDTO> getPostsByTag(String tag) throws Exception {
        return null;
    }

    @Override
    public Set<String> getAllTags() throws Exception {
        return null;
    }

    @Override
    public boolean deletePost(int id, String emailId) throws Exception {
        return false;
    }
}

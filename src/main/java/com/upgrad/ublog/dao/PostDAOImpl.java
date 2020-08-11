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

import com.upgrad.ublog.db.DatabaseConnection;
import com.upgrad.ublog.dto.PostDTO;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO: 7.22. Implement findAllTags() method which returns a list of all unique tags in the UBLOG_POSTS
 *  table.
 * TODO: 7.23. Implement findByTag() method which takes "tag" as an input argument and returns all the
 *  posts corresponding to the input "tag" from the UBLOG_POSTS table defined in the database.
 */

public class PostDAOImpl implements PostDAO{

    private PostDAOImpl() {}

    private static PostDAOImpl instance;

    public static PostDAOImpl getInstance() {
        return instance;
    }

    @Override
    public List<PostDTO> findByEmail(String emailId) throws SQLException {
        List<PostDTO> postDTOS = new ArrayList<>();
        Connection connection = DatabaseConnection.getConnection();
        String query = "SELECT * FROM UBLOG_POSTS WHERE email_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, emailId);
        ResultSet resultSet = statement.executeQuery();
        PostDTO postDTO = new PostDTO();
        while(resultSet.next()) {
            postDTO.setPostId(resultSet.getInt("id"));
            postDTO.setTimestamp((LocalDateTime) resultSet.getObject("timestamp"));
            postDTO.setTitle(resultSet.getString("title"));
            postDTO.setTag(resultSet.getString("tag"));
            postDTO.setDescription(resultSet.getString("description"));
            postDTO.setEmailId(resultSet.getString("email_id"));
            postDTOS.add(postDTO);
        }
        return postDTOS;
    }

    @Override
    public List<PostDTO> findByTag(String tag) throws SQLException {
        List<PostDTO> postDTOS = new ArrayList<>();
        Connection connection = DatabaseConnection.getConnection();
        String query = "SELECT * FROM UBLOG_POSTS WHERE tag = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, tag);
        ResultSet resultSet = statement.executeQuery();
        PostDTO postDTO = new PostDTO();
        while(resultSet.next()) {
            postDTO.setPostId(resultSet.getInt("id"));
            postDTO.setTimestamp((LocalDateTime) resultSet.getObject("timestamp"));
            postDTO.setTitle(resultSet.getString("title"));
            postDTO.setTag(resultSet.getString("tag"));
            postDTO.setDescription(resultSet.getString("description"));
            postDTO.setEmailId(resultSet.getString("email_id"));
            postDTOS.add(postDTO);
        }
        return postDTOS;
    }

    @Override
    public PostDTO create(PostDTO postDTO) throws SQLException {
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = "INSERT INTO UBLOG_POSTS(id, email_id, title, description, tag, timestamp)" + "VALUES (?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            Timestamp timestamp = Timestamp.valueOf(postDTO.getTimestamp());
            statement.setInt(1, postDTO.getPostId());
            statement.setString(2, postDTO.getEmailId());
            statement.setString(3, postDTO.getTitle());
            statement.setString(4, postDTO.getDescription());
            statement.setString(5, postDTO.getTag());
            statement.setTimestamp(6, timestamp);
            statement.executeUpdate();
            return postDTO;
        } catch(SQLException ex) {
            throw new SQLException(ex);
        }
    }

    @Override
    public List<String> findAllTags() throws SQLException {
        try {
            List<String> tags = new ArrayList<>();
            Connection connection = DatabaseConnection.getConnection();
            String query = "SELECT tag FROM UBLOG_POSTS ";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()) {
                tags.add(resultSet.getString("tag"));
            }
            return tags;
        } catch(SQLException ex) {
            throw new SQLException(ex);
        }
    }

    @Override
    public PostDTO findById(int id) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "SELECT * FROM UBLOG_POSTS WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        PostDTO postDTO = new PostDTO();
        while(resultSet.next()) {
            postDTO.setPostId(resultSet.getInt("id"));
            postDTO.setTimestamp((LocalDateTime) resultSet.getObject("timestamp"));
            postDTO.setTitle(resultSet.getString("title"));
            postDTO.setTag(resultSet.getString("tag"));
            postDTO.setDescription(resultSet.getString("description"));
            postDTO.setEmailId(resultSet.getString("email_id"));

        }
        return postDTO;
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = "DELETE FROM UBLOG_POSTS WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            int count = statement.executeUpdate();
            if (count == 1)
                return true;
        } catch(SQLException ex) {
            throw new SQLException(ex);
        }
        return false;
    }
}

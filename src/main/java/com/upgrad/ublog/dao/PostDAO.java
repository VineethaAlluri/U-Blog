package com.upgrad.ublog.dao;

import com.upgrad.ublog.dto.PostDTO;

import java.sql.SQLException;
import java.util.List;

public interface PostDAO {
    PostDTO create(PostDTO postDTO) throws SQLException;
    List<PostDTO> findByEmail(String emailId) throws SQLException;
    List<PostDTO> findByTag(String tag) throws SQLException;
    PostDTO findById(int id) throws SQLException;
    List<String> findAllTags() throws SQLException;
    boolean deleteById(int id) throws SQLException;
}

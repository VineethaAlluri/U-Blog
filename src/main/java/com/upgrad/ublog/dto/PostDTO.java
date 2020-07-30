package com.upgrad.ublog.dto;
import java.time.LocalDateTime;
/**
 * TODO: 2.1. Declare 6 private instance variables in this class named as postId,
 *  emailId, tag, title, description, timestamp. Out of these 6 variables, postId
 *  will be of type int and timestamp will be of type LocalDateTime
 *  (import java.time.LocalDateTime). Other four variables will be of type String.
 *
 * TODO: 2.2. Provide getters and setters for each of the instance variables.
 *
 * Note: Uncomment the toString() method given below, instead of writing a new one.
 */

public class PostDTO {

    private int postId;
    private String emailId;
    private String tag;
    private String title;
    private String description;
    private LocalDateTime timestamp;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    @Override
    public String toString() {
        return "PostDTO{" +
                "postId=" + postId +
                ", emailId='" + emailId + '\'' +
                ", tag='" + tag + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

    public static void main(String[] args) {
		PostDTO postDTO = new PostDTO();
		postDTO.setPostId(1);
		postDTO.setEmailId("dummy@dummy.com");
		postDTO.setTag("tag");
		postDTO.setTitle("title");
		postDTO.setDescription("Description");
		postDTO.setTimestamp(LocalDateTime.now());

		System.out.println(postDTO);

		 //Your output should be similar to as shown below.
		 //PostDTO{postId=1, emailId='dummy@dummy.com', tag='tag', title='title', description='Description', timestamp=2020-05-22T21:01:34.483363800}

	}
}

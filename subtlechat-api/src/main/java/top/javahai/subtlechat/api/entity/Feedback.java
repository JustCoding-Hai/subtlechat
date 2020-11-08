package top.javahai.subtlechat.api.entity;

import java.io.Serializable;

/**
 * (Feedback)实体类
 *
 * @author makejava
 * @since 2020-10-02 12:14:15
 */
public class Feedback implements Serializable {
    private static final long serialVersionUID = 550979088670747783L;
    
    private String id;
    
    private String userId;
    
    private String username;
    
    private String nickname;
    
    private String content;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
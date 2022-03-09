package com.venuebooking.venuebookingwork.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Comment {

    //唯一标识评论的ID
    @Id
    @GeneratedValue
    @Column(unique = true)
    private Long commentID;

    //评论的内容，为html文本格式
    private String content;
    //评论者昵称
    private String reviewer;
    //评论发布时间，字符串格式
    private String publishTime;
    //评论发布时间，Date格式
    private Date publishDate;

    public Comment() {
    }

    public Comment(String content, String reviewer, String publishTime, Date publishDate) {
        this.content = content;
        this.reviewer = reviewer;
        this.publishTime = publishTime;
        this.publishDate = publishDate;
    }

    public Long getCommentID() {
        return commentID;
    }

    public void setCommentID(Long commentID) {
        this.commentID = commentID;
    }



    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
}

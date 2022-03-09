package com.venuebooking.venuebookingwork.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Essay {

    //唯一标识新闻的ID
    @Id
    @GeneratedValue
    @Column(unique = true)
    private Long essayID;
    //新闻标题
    private String title;
    //新闻的文本内容，是html格式的文本
    private String content;
    //新闻发布的时间，字符串格式
    private String publishTime;
    //新闻发布的时间，Date格式
    private Date publishDate;
    //属于新闻的评论
    @ElementCollection
    @OrderColumn(name = "position")
    private List<Comment> comments;


    public Essay() {
    }

    public Essay(String title, String content, String publishTime, Date publishDate) {
        this.title = title;
        this.content = content;
        this.publishTime = publishTime;
        this.publishDate = publishDate;
        this.comments = new ArrayList<>();
    }

    public Long getEssayID() {
        return essayID;
    }

    public void setEssayID(Long essayID) {
        this.essayID = essayID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}

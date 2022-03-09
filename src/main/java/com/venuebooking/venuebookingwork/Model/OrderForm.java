package com.venuebooking.venuebookingwork.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class OrderForm {

    //唯一标识订单的ID
    @Id
    @GeneratedValue
    @Column(unique = true)
    private Long orderFormID;
    //订单生成时间，Date格式
    private Date submitDate;
    //订单生成时间，字符串格式
    private String submitTime;
    //订单提交者的ID
    private Long uid;
    //订单提交者的用户名
    private String submitUserName;
    //预约场馆的ID
    private Long venueID;
    //预约场馆的名字
    private String venueName;
    //预约的日期，精确到日，字符串格式
    private String orderDay;
    //预约开始的时间，字符串格式
    private String startTime;
    //预约结束的时间，字符串格式
    private String endTime;
    //预约总时间，字符串格式
    private String totalTime;
    //花费金额
    private double rent;

    public OrderForm() {
    }

    public OrderForm(Date submitDate, String submitTime, Long uid, String submitUserName, Long venueID, String venueName, String orderDay, String startTime, String endTime, String totalTime, double rent) {
        this.submitDate = submitDate;
        this.submitTime = submitTime;
        this.uid = uid;
        this.submitUserName = submitUserName;
        this.venueID = venueID;
        this.venueName = venueName;
        this.orderDay = orderDay;
        this.startTime = startTime;
        this.endTime = endTime;
        this.totalTime = totalTime;
        this.rent = rent;
    }

    public Long getOrderFormID() {
        return orderFormID;
    }

    public void setOrderFormID(Long orderFormID) {
        this.orderFormID = orderFormID;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public String getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(String submitTime) {
        this.submitTime = submitTime;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getSubmitUserName() {
        return submitUserName;
    }

    public void setSubmitUserName(String submitUserName) {
        this.submitUserName = submitUserName;
    }

    public Long getVenueID() {
        return venueID;
    }

    public void setVenueID(Long venueID) {
        this.venueID = venueID;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getOrderDay() {
        return orderDay;
    }

    public void setOrderDay(String orderDay) {
        this.orderDay = orderDay;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }
}

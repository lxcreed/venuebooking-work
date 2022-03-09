package com.venuebooking.venuebookingwork.Model;


import javax.persistence.*;

@Entity
public class VenueDay {


    //唯一标识场馆预约日的ID
    @Id
    @GeneratedValue
    @Column(unique = true)
    private Long venueDayID;
    //日期，精确到日，字符串格式
    private String date;
    //一天开放的16个小时，用布尔类型表示，假为尚未被预约，真为已被预约
    @ElementCollection
    @OrderColumn(name = "position")
    private boolean[] timeParts;

    public VenueDay() {
    }

    public VenueDay(String date) {
        this.date = date;
        this.timeParts = new boolean[16];
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean[] getTimeParts() {
        return timeParts;
    }

    public void setTimeParts(boolean[] timeParts) {
        this.timeParts = timeParts;
    }

    public Long getVenueDayID() {
        return venueDayID;
    }

    public void initialTimeParts() {
        this.timeParts = new boolean[16];
    }

    public boolean conflictCheck(int startTime, int endTime) {
        for (int i = startTime; i < endTime; i++) {
            if (timeParts[i]) {
                return true;
            }
        }
        return false;
    }

    public void updateTime(int startTime, int endTime) {
        for (int i = startTime; i < endTime; i++) {
            timeParts[i] = true;
        }
    }

    public void deleteTime(int startTime, int endTime) {
        for (int i = startTime; i < endTime; i++) {
            timeParts[i] = false;
        }
    }
}







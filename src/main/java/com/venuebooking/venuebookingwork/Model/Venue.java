package com.venuebooking.venuebookingwork.Model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Venue {

    //唯一标识场馆的ID
    @Id
    @GeneratedValue
    @Column(unique = true)
    private Long venueID;
    //场馆名称
    private String venueName;
    //场馆地点
    private String location;
    //场馆描述
    private String description;
    //租赁一小时所需金额
    private double hourRent;
    //可以租赁场馆的日期
    @ElementCollection
    @OrderColumn(name = "position")
    private List<VenueDay> rentDays;

    public Venue() {
    }

    public Venue(String venueName, String location, String description, double hourRent, List<VenueDay> rentDays) {
        this.venueName = venueName;
        this.location = location;
        this.description = description;
        this.hourRent = hourRent;
        this.rentDays = rentDays;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getHourRent() {
        return hourRent;
    }

    public void setHourRent(double hourRent) {
        this.hourRent = hourRent;
    }

    public List<VenueDay> getRentDays() {
        return rentDays;
    }

    public void setRentDays(List<VenueDay> rentDays) {
        this.rentDays = rentDays;
    }
}

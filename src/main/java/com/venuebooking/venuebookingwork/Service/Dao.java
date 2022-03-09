package com.venuebooking.venuebookingwork.Service;

import com.venuebooking.venuebookingwork.Model.*;
import com.venuebooking.venuebookingwork.Util.TimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class Dao {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EssayRepository essayRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private VenueRepository venueRepository;
    @Autowired
    private VenueDayRepository venueDayRepository;
    @Autowired
    private OrderFormRepository orderFormRepository;


    public User GetUserByUID(Long uid) {
        return userRepository.findByUid(uid);
    }

    public ArrayList<Essay> GetAllEssays() {
        return essayRepository.findAll();
    }

    public Essay GetEssayByEssayID(Long essayID) {
        return essayRepository.findByEssayID(essayID);
    }

    public void UpdateEssay(Essay newEssay) {
        essayRepository.save(newEssay);
    }

    public void AddEssay(Essay newEssay) {
        essayRepository.save(newEssay);
    }

    public void DeleteEssayByEssayID(Long essayID) {
        essayRepository.deleteByEssayID(essayID);
    }

    public void AddComment(Comment newComment) {
        commentRepository.save(newComment);
    }

    public void DeleteCommentByCommentID(Long commentID) {
        commentRepository.deleteByCommentID(commentID);
    }

    public ArrayList<Venue> GetAllVenues() {
        return venueRepository.findAll();
    }

    public Venue GetVenueByVenueID(Long venueID) {
        return venueRepository.findByVenueID(venueID);
    }

    public void AddVenue(Venue newVenue) {
        venueRepository.save(newVenue);
    }

    public void UpdateVenue(Venue newVenue) {
        venueRepository.save(newVenue);
    }

    public void DeleteVenueByVenueID(Long venueID) {
        venueRepository.deleteByVenueID(venueID);
    }

    public void AddVenueDay(VenueDay newVenueDay) {
        venueDayRepository.save(newVenueDay);
    }

    public void UpdateVenueDay(VenueDay newVenueDay) {
        venueDayRepository.save(newVenueDay);
    }

    public VenueDay GetVenueDayByVenueDayID(Long venueDayID) {
        return venueDayRepository.findByVenueDayID(venueDayID);
    }

    public boolean orderTwice(Long uid, String orderDay) {
        return orderFormRepository.existsByUidAndOrderDay(uid, orderDay);
    }

    public void GenerateOrderForm(Long uid, Long venueDayId, Long venueID, int startT, int endT) {
        Date submitDate = new Date();
        String submitTime = TimeFormat.YearMonthDayHourMinSec(submitDate);
        String submitUserName = userRepository.findByUid(uid).getUserName();

        String venueName = venueRepository.findByVenueID(venueID).getVenueName();
        String orderDay = venueDayRepository.findByVenueDayID(venueDayId).getDate();
        String startTime = TimeFormat.DigitToTime(startT);
        String endTime = TimeFormat.DigitToTime(endT);
        String totalTime = TimeFormat.DigitToTimePart(endT - startT);
        double rent = (endT - startT) * venueRepository.findByVenueID(venueID).getHourRent();
        OrderForm newOrderForm = new OrderForm(submitDate, submitTime, uid, submitUserName, venueID, venueName, orderDay, startTime, endTime, totalTime, rent);
        orderFormRepository.save(newOrderForm);
    }

    public ArrayList<OrderForm> GetAllOrderFormsByVenueID(Long venueID) {
        return orderFormRepository.findAllByVenueID(venueID);
    }

    public ArrayList<OrderForm> GetAllOrderFormByUID(Long uid) {
        return orderFormRepository.findAllByUid(uid);
    }

    public OrderForm GetOrderFormByOrderFormID(Long orderFormID) {
        return orderFormRepository.findByOrderFormID(orderFormID);
    }

    public void DeleteOrderFormByOrderFormID(Long orderFormID) {
        orderFormRepository.deleteByOrderFormID(orderFormID);
    }

}

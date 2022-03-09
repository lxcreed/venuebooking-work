package com.venuebooking.venuebookingwork.Controller.UserController;


import com.venuebooking.venuebookingwork.Model.ParaPasser;
import com.venuebooking.venuebookingwork.Model.Venue;
import com.venuebooking.venuebookingwork.Model.VenueDay;
import com.venuebooking.venuebookingwork.Service.Dao;
import com.venuebooking.venuebookingwork.Util.SessionTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UVenueInformationController {

    @Autowired
    Dao dao;

    @GetMapping("/venueInformation_user/{venueID}")
    public String UVenueInformationPage(HttpSession session, @PathVariable("venueID") Long venueID, Model model) {
        if (!SessionTool.IsUserLogging(session)) {
            return "login";
        }

        Venue returnVenue = dao.GetVenueByVenueID(venueID);
        model.addAttribute("venue", returnVenue);

        return "user/venueInformation_user";
    }


    @PostMapping("/venueInformation_user/{venueDayID}/orderSubmit")
    public String OrderSubmit(HttpSession session, ParaPasser paraPasser, @PathVariable("venueDayID") Long venueDayID, Model model) {
        int startTime = paraPasser.getStartTime();
        int endTime = paraPasser.getEndTime();
        Long venueID = paraPasser.getVenueID();

        Venue returnVenue = dao.GetVenueByVenueID(venueID);
        model.addAttribute("venue", returnVenue);

        if (dao.orderTwice((Long) session.getAttribute("uid"), dao.GetVenueDayByVenueDayID(venueDayID).getDate())) {
            model.addAttribute("alert_type","<script>$('#order_twice').modal();</script>");

            return "user/venueInformation_user";
        }
        if (dao.GetVenueDayByVenueDayID(venueDayID).conflictCheck(startTime, endTime)) {
            model.addAttribute("alert_type","<script>$('#conflict_error').modal();</script>");

            return "user/venueInformation_user";
        }

        session.setAttribute("error", false);

        VenueDay venueDay = dao.GetVenueDayByVenueDayID(venueDayID);
        venueDay.updateTime(startTime, endTime);
        dao.UpdateVenueDay(venueDay);

        dao.GenerateOrderForm((Long) session.getAttribute("uid"), venueDayID, venueID, startTime, endTime);

        return "redirect:/venueInformation_user/" + venueID;

    }


}

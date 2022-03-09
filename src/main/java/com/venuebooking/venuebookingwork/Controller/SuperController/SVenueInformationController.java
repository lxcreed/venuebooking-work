package com.venuebooking.venuebookingwork.Controller.SuperController;


import com.venuebooking.venuebookingwork.Model.OrderForm;
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
import java.util.ArrayList;
import java.util.List;

@Controller
public class SVenueInformationController {

    @Autowired
    private Dao dao;

    @GetMapping("/venueInformation_super/{venueID}")
    public String SVenueInformationPage(HttpSession session, @PathVariable("venueID") Long venueID, Model model) {
        if (!SessionTool.IsSuperLogging(session)) {
            return "login";
        }

        Venue returnVenue = dao.GetVenueByVenueID(venueID);
        model.addAttribute("venue", returnVenue);

        List<OrderForm> orderForms = dao.GetAllOrderFormsByVenueID(venueID);
        model.addAttribute("orderForms", orderForms);

        return "super/venueInformation_super";
    }

    @PostMapping("/venueInformation_super/{venueID}/addVenueDaySubmit")
    public String NewVenueDaySubmit(VenueDay newVenueDay, @PathVariable("venueID") Long venueID) {
        Venue targetVenue = dao.GetVenueByVenueID(venueID);
        List<VenueDay> venueDays = targetVenue.getRentDays();
        newVenueDay.initialTimeParts();
        dao.AddVenueDay(newVenueDay);
        venueDays.add(newVenueDay);
        targetVenue.setRentDays(venueDays);
        dao.UpdateVenue(targetVenue);

        return "redirect:/venueInformation_super/" + venueID;
    }

}

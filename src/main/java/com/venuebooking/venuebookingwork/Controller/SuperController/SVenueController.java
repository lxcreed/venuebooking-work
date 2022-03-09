package com.venuebooking.venuebookingwork.Controller.SuperController;


import com.venuebooking.venuebookingwork.Model.OrderForm;
import com.venuebooking.venuebookingwork.Model.Venue;
import com.venuebooking.venuebookingwork.Service.Dao;
import com.venuebooking.venuebookingwork.Util.SessionTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class SVenueController {

    @Autowired
    Dao dao;

    @GetMapping("/venue_super")
    public String SVenuePage(HttpSession session, Model model) {
        if (!SessionTool.IsSuperLogging(session)) {
            return "login";
        }

        ArrayList<Venue> venues = dao.GetAllVenues();
        model.addAttribute("venues", venues);

        return "super/venue_super";
    }

    @GetMapping("/venue_delete/{venueID}")
    public String VenueDelete(@PathVariable("venueID") Long venueID, Model model) {
        ArrayList<OrderForm> orderForms = dao.GetAllOrderFormsByVenueID(venueID);
        if (!orderForms.isEmpty()) {
            model.addAttribute("alert_type", "<script>$('#delete_error').modal();</script>");
            ArrayList<Venue> venues = dao.GetAllVenues();
            model.addAttribute("venues", venues);
            return "super/venue_super";
        }

        dao.DeleteVenueByVenueID(venueID);

        return "redirect:/venue_super";
    }

}

package com.venuebooking.venuebookingwork.Controller.SuperController;


import com.venuebooking.venuebookingwork.Model.Venue;
import com.venuebooking.venuebookingwork.Service.Dao;
import com.venuebooking.venuebookingwork.Util.SessionTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class OrderFormViewController {

    @Autowired
    private Dao dao;

    @GetMapping("/orderForm_super")
    public String OrderViewPage(HttpSession session, Model model) {
        if (!SessionTool.IsSuperLogging(session)) {
            return "login";
        }

        ArrayList<Venue> allVenues = dao.GetAllVenues();
        ArrayList<Venue> orderedVenues = new ArrayList<>();

        for (Venue venue : allVenues) {
            if (!dao.GetAllOrderFormsByVenueID(venue.getVenueID()).isEmpty()) {
                orderedVenues.add(venue);
            }
        }

        model.addAttribute("orderedVenues", orderedVenues);
        return "super/orderForm_super";
    }


}

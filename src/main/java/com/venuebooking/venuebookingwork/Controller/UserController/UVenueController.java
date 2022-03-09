package com.venuebooking.venuebookingwork.Controller.UserController;


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
public class UVenueController {

    @Autowired
    private Dao dao;

    @GetMapping("/venue_user")
    public String UVenuePage(HttpSession session, Model model) {
        if (!SessionTool.IsUserLogging(session)) {
            return "login";
        }

        ArrayList<Venue> venues = dao.GetAllVenues();
        model.addAttribute("venues", venues);

        return "user/venue_user";
    }


}

package com.venuebooking.venuebookingwork.Controller.SuperController;


import com.venuebooking.venuebookingwork.Model.Venue;
import com.venuebooking.venuebookingwork.Service.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AddVenueController {

    @Autowired
    private Dao dao;

    @PostMapping("/newVenueSubmit")
    public String NewVenueSubmit(Venue newVenue) {
        dao.AddVenue(newVenue);

        return "redirect:/venue_super";
    }

}

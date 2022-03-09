package com.venuebooking.venuebookingwork.Controller.CommonController;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class ExitController {

    @GetMapping("/exit")
    public String Exit(HttpSession session) {
        session.invalidate();

        return "redirect:/login";
    }

}

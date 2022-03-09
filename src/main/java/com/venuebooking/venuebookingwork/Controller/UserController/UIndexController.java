package com.venuebooking.venuebookingwork.Controller.UserController;


import com.venuebooking.venuebookingwork.Model.Essay;
import com.venuebooking.venuebookingwork.Service.Dao;
import com.venuebooking.venuebookingwork.Util.SessionTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class UIndexController {

    @Autowired
    Dao dao;

    @GetMapping("/index_user")
    public String UIndexPage(HttpSession session, Model model)
    {
        if(!SessionTool.IsUserLogging(session)) {
            return "login";
        }

        ArrayList<Essay> allEssays=dao.GetAllEssays();
        model.addAttribute("essays",allEssays);

        return "user/index_user";
    }



}

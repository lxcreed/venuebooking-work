package com.venuebooking.venuebookingwork.Controller.SuperController;


import com.venuebooking.venuebookingwork.Model.Essay;
import com.venuebooking.venuebookingwork.Service.Dao;
import com.venuebooking.venuebookingwork.Util.SessionTool;
import com.venuebooking.venuebookingwork.Util.TimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class SIndexController {


    @Autowired
    private Dao dao;

    @GetMapping("/index_super")
    public String SIndexPage(HttpSession session, Model model) {
        if (!SessionTool.IsSuperLogging(session)) {
            return "login";
        }

        ArrayList<Essay> allEssays = dao.GetAllEssays();
        model.addAttribute("essays", allEssays);

        return "super/index_super";
    }

    @PostMapping("/essaySubmit")
    public String EssaySubmit(Essay newEssay) {
        Date date = new Date();
        newEssay.setPublishDate(date);
        newEssay.setPublishTime(TimeFormat.YearMonthDayHourMin(date));

        dao.AddEssay(newEssay);

        return "redirect:/index_super";
    }

    @GetMapping("/essay_delete/{essayID}")
    public String EssayDelete(@PathVariable("essayID") Long essayID) {

        dao.DeleteEssayByEssayID(essayID);

        return "redirect:/index_super";
    }


}

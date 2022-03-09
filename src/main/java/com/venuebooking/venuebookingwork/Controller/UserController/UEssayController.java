package com.venuebooking.venuebookingwork.Controller.UserController;


import com.venuebooking.venuebookingwork.Model.Comment;
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
import java.util.Date;
import java.util.List;

@Controller
public class UEssayController {

    @Autowired
    private Dao dao;


    @GetMapping("/essay_user/{essayID}")
    public String UEssayPage(HttpSession session, @PathVariable("essayID") Long essayID, Model model) {
        if (!SessionTool.IsUserLogging(session)) {
            return "login";
        }

        Essay essay = dao.GetEssayByEssayID(essayID);
        model.addAttribute("essay", essay);

        return "user/essay_user";
    }

    @PostMapping("/commentSubmit/{essayID}")
    public String CommentSubmit(HttpSession session, @PathVariable("essayID") Long essayID, Comment newComment) {
        newComment.setReviewer(dao.GetUserByUID((Long) session.getAttribute("uid")).getNickName());
        Date date = new Date();
        String time = TimeFormat.YearMonthDayHourMin(date);
        newComment.setPublishDate(date);
        newComment.setPublishTime(time);
        dao.AddComment(newComment);

        Essay targetEssay = dao.GetEssayByEssayID(essayID);
        List<Comment> comments = targetEssay.getComments();
        comments.add(newComment);
        targetEssay.setComments(comments);
        dao.UpdateEssay(targetEssay);

        return "redirect:/essay_user/" + essayID;
    }

}

package com.venuebooking.venuebookingwork.Controller.SuperController;


import com.venuebooking.venuebookingwork.Model.Comment;
import com.venuebooking.venuebookingwork.Model.Essay;
import com.venuebooking.venuebookingwork.Service.Dao;
import com.venuebooking.venuebookingwork.Util.SessionTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class SEssayController {

    @Autowired
    private Dao dao;

    @GetMapping("/essay_super/{essayID}")
    public String SEssayPage(HttpSession session, @PathVariable("essayID") Long essayID, Model model) {
        if (!SessionTool.IsSuperLogging(session)) {
            return "login";
        }

        Essay essay = dao.GetEssayByEssayID(essayID);
        model.addAttribute("essay", essay);

        return "super/essay_super";
    }

    @GetMapping("/comment_delete/{essayID}/{commentID}")
    public String CommentDelete(@PathVariable("commentID") Long commentID, @PathVariable("essayID") Long essayID) {

        Essay essay = dao.GetEssayByEssayID(essayID);
        List<Comment> comments = essay.getComments();
        int i = 0;
        for (i = 0; i < comments.size(); i++) {
            if (commentID.equals(comments.get(i).getCommentID())) {
                break;
            }
        }
        comments.remove(i);
        essay.setComments(comments);
        dao.UpdateEssay(essay);

        dao.DeleteCommentByCommentID(commentID);

        return "redirect:/essay_super/" + essayID;
    }

}

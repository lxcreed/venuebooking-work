package com.venuebooking.venuebookingwork.Controller.CommonController;

import com.venuebooking.venuebookingwork.Model.Administrator;
import com.venuebooking.venuebookingwork.Model.AdministratorRepository;
import com.venuebooking.venuebookingwork.Model.User;
import com.venuebooking.venuebookingwork.Model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AdministratorRepository administratorRepository;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/userLoginSubmit")
    public String userLogin(User user, Model model, HttpSession session) {
        if (!userRepository.existsByUserName(user.getUserName())) {
            model.addAttribute("alert_type", "<script>$('#no_user').modal();</script>");
            return "login";
        }
        if (user.getPassword().compareTo(userRepository.findByUserName(user.getUserName()).getPassword()) != 0) {
            model.addAttribute("alert_type", "<script>$('#password_error').modal();</script>");
            return "login";
        }

        session.setAttribute("uid",userRepository.findByUserName(user.getUserName()).getUid());

        return "redirect:/index_user";
    }

    @PostMapping("/superLoginSubmit")
    public String superLogin(Administrator administrator,Model model,HttpSession session){
        if(!administratorRepository.existsBySuperName(administrator.getSuperName())){
            model.addAttribute("alert_type", "<script>$('#no_administrator').modal();</script>");
            return "login";
        }
        if(administrator.getPassword().compareTo(administratorRepository.findBySuperName(administrator.getSuperName()).getPassword())!=0){
            model.addAttribute("alert_type", "<script>$('#password_error').modal();</script>");
            return "login";
        }

        session.setAttribute("superID",administratorRepository.findBySuperName(administrator.getSuperName()).getSuperID());

        return "redirect:/index_super";
    }

}

package com.venuebooking.venuebookingwork.Controller.UserController;


import com.venuebooking.venuebookingwork.Model.User;
import com.venuebooking.venuebookingwork.Model.UserRepository;
import com.venuebooking.venuebookingwork.Service.UserRegis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class RegisController {

    @Autowired
    private UserRegis UserRegis;
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/userRegister")
    public String registerPage() {
        return "userRegister";
    }


    @PostMapping("/userRegisterSubmit")
    public String userRegister(User regUser, Model model, HttpSession session) {
        if (UserRegis.userNameExist(regUser.getUserName())) {
            model.addAttribute("alert_type", "<script>$('#userName_exist').modal();</script>");
            return "userRegister";
        }

        UserRegis.register(regUser);
        session.setAttribute("uid",userRepository.findByUserName(regUser.getUserName()).getUid());

        return "registerSuccess";
    }

}

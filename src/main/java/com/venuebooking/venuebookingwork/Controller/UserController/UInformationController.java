package com.venuebooking.venuebookingwork.Controller.UserController;


import com.venuebooking.venuebookingwork.Model.OrderForm;
import com.venuebooking.venuebookingwork.Model.User;
import com.venuebooking.venuebookingwork.Model.VenueDay;
import com.venuebooking.venuebookingwork.Service.Dao;
import com.venuebooking.venuebookingwork.Util.TimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UInformationController {


    @Autowired
    private Dao dao;

    @GetMapping("/information_user")
    public String UserInformationPage(HttpSession session, Model model) {
        Long uid = (Long) session.getAttribute("uid");
        User user = dao.GetUserByUID(uid);
        model.addAttribute("user", user);

        ArrayList<OrderForm> orderForms = dao.GetAllOrderFormByUID(uid);
        model.addAttribute("orderForms", orderForms);

        return "user/information_user";
    }

    @GetMapping("/orderForm_delete/{orderFormID}")
    public String orderFormDelete(@PathVariable("orderFormID") Long orderFormID) {
        OrderForm orderForm = dao.GetOrderFormByOrderFormID(orderFormID);
        int startTime = TimeFormat.TimeToDigit(orderForm.getStartTime()) - 7;
        int endTime = TimeFormat.TimeToDigit(orderForm.getEndTime()) - 7;
        String date = orderForm.getOrderDay();
        List<VenueDay> venueDays = dao.GetVenueByVenueID(orderForm.getVenueID()).getRentDays();
        VenueDay targetVenueDay = venueDays.get(0);
        for (int i = 0; i < venueDays.size(); i++) {
            if (venueDays.get(i).getDate().equals(date)) {
                targetVenueDay = venueDays.get(i);
                break;
            }
        }
        targetVenueDay.deleteTime(startTime, endTime);
        dao.UpdateVenueDay(targetVenueDay);
        dao.DeleteOrderFormByOrderFormID(orderFormID);

        return "redirect:/information_user";
    }


}

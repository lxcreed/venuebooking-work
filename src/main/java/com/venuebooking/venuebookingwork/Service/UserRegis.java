package com.venuebooking.venuebookingwork.Service;

import com.venuebooking.venuebookingwork.Model.User;
import com.venuebooking.venuebookingwork.Model.UserRepository;
import com.venuebooking.venuebookingwork.Util.TimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserRegis {

    @Autowired
    private UserRepository userRepository;

    public void register(String userName, String nickName, String password) {


        String regTime = TimeFormat.YearMonthDayHourMinSec(new Date());
        User newUser = new User(userName, nickName, password, regTime);

        userRepository.save(newUser);
    }

    public void register(User newUser) {
        String regTime = TimeFormat.YearMonthDayHourMinSec(new Date());
        newUser.setRegTime(regTime);

        userRepository.save(newUser);
    }

    public boolean userNameExist(String userName) {
        return userRepository.existsByUserName(userName);
    }

}

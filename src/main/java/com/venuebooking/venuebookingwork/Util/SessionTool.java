package com.venuebooking.venuebookingwork.Util;

import javax.servlet.http.HttpSession;

public class SessionTool {

    public static boolean IsUserLogging(HttpSession session) {
        if (session.getAttribute("uid") != null) {
            return true;
        }

        return false;
    }

    public static boolean IsSuperLogging(HttpSession session){
        if(session.getAttribute("superID")!=null){
            return true;
        }

        return false;
    }

}

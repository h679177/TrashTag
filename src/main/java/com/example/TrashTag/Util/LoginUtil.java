package com.example.TrashTag.Util;

import com.example.TrashTag.Model.Bruker;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LoginUtil {
    public static void loggUtBruker(HttpSession sesjon) {
        if (sesjon != null) {
            sesjon.invalidate();
        }
    }

    public static void loggInnBruker(HttpServletRequest request, Bruker bruker) {
        loggUtBruker(request.getSession());
        HttpSession session = request.getSession();
        session.setAttribute("bruker", bruker);
        session.setAttribute("username", bruker.getBrukernavn());
        session.setMaxInactiveInterval(200);
    }

    public static boolean erInnlogget(HttpSession sesjon) {
        return sesjon != null && sesjon.getAttribute("username") != null;
    }
}

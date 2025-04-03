package com.example.TrashTag.Util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LoginUtil {
    public static void loggUtBruker(HttpSession sesjon) {
        if (sesjon != null) {
            sesjon.invalidate();
        }
    }

    public static void loggInnBruker(HttpServletRequest request, String brukernavn) {
        loggUtBruker(request.getSession());
        HttpSession session = request.getSession();
        session.setAttribute("username", brukernavn);
        session.setMaxInactiveInterval(200);
    }

    public static boolean erInnlogget(HttpSession sesjon) {
        return sesjon != null && sesjon.getAttribute("username") != null;
    }
}

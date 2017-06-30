/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author guilh
 */
public class FlashUtils {
    public static void setFlash(HttpServletRequest request, Object obj) {
        HttpSession session = request.getSession(true);
        session.setAttribute("request.flash", obj);
    }
    
    public static Object getFlash(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            Object flash = session.getAttribute("request.flash");
            session.removeAttribute("request.flash");
            return flash;
        }
        
        return null;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.util;

import br.unesp.rc.habilidades.beans.Membro;
import br.unesp.rc.habilidades.beans.Permissao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author guilh
 */
public class PermissaoUtils {
    private PermissaoUtils() {
        
    }
    
    public static boolean hasPermissao(HttpServletRequest request, Permissao permissao) {
        HttpSession session = request.getSession();
        Membro membro = (Membro)session.getAttribute("membro");
        return membro.hasPermissao(permissao);
    }
}

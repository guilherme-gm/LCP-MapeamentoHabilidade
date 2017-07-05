/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.commands;

import br.unesp.rc.habilidades.beans.Projeto;
import br.unesp.rc.habilidades.beans.StatusProjeto;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author guilh
 */
public class DoCriarProjeto implements ICommand {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        Projeto projeto = new Projeto();
        try {
            BeanUtils.populate(projeto, request.getParameterMap());
            projeto.setStatus(StatusProjeto.valueOf(request.getParameter("pstatus")));
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DoCriarProjeto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(DoCriarProjeto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        HttpSession session = request.getSession(true);
        session.setAttribute("projeto", projeto);
        
        request.setAttribute("menu", "adminproj");

        return new CommandResult(request, "SelecionaTecnologia");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.commands;

import br.unesp.rc.habilidades.beans.Acesso;
import br.unesp.rc.habilidades.beans.Membro;
import br.unesp.rc.habilidades.dao.MembroDAO;
import br.unesp.rc.habilidades.dao.MembroDAOImpl;
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
public class DoLogin implements ICommand {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        Acesso acesso = new Acesso();
        try {
            BeanUtils.populate(acesso, request.getParameterMap());
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DoLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(DoLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        MembroDAO membroDao = new MembroDAOImpl();
        Membro membro = membroDao.select(acesso.getUsuario(), acesso.getSenha());
        
        if (membro == null) {
            request.setAttribute("erro", "Nome de usuário ou senha incorretos.");
            return new CommandResult("home");
        }
        
        HttpSession session = request.getSession(true);
        session.setAttribute("membro", membro);
        
        request.setAttribute("menu", "home");
        request.getSession().setAttribute("membro", membro);
        
        return new CommandResult(request, "Usuario");
    }
    
}

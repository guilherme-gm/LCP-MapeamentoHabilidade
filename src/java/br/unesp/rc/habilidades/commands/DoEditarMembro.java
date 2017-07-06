/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.commands;

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
 * @author Raphael
 */
public class DoEditarMembro implements ICommand{

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        Membro membro = (Membro) session.getAttribute("membro"); 
        MembroDAO membroDao = new MembroDAOImpl();
        
        membro.setEmail(request.getParameter("email"));
        membro.setTelefone(request.getParameter("telefone"));        
       
        membroDao.update(membro);
        
        request.setAttribute("msg_tipo", "alert-success");
        request.setAttribute("msg", "Membro atualizado com sucesso.");
        request.setAttribute("menu", "adminmembro");
        return new CommandResult(request, "ListarMembro");
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.commands;

import br.unesp.rc.habilidades.beans.Membro;
import br.unesp.rc.habilidades.dao.MembroDAO;
import br.unesp.rc.habilidades.dao.MembroDAOImpl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Raphael
 */
public class EditarPerfil implements ICommand{

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        // int id = Integer.parseInt(request.getParameter("idMembro")); mudar ID
        
        MembroDAO membroDao = new MembroDAOImpl();
       // Membro membro = membroDao.select(id);
        
       // request.setAttribute("membro", membro);
        request.setAttribute("menu", "adminmembro");
        return new CommandResult("editar_membro");
    }
    
}

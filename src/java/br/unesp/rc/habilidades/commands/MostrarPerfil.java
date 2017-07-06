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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Raphael
 */
public class MostrarPerfil implements ICommand{

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        Membro membro = (Membro) session.getAttribute("membro");              
        
        MembroDAO membroDao = new MembroDAOImpl();
        membro = membroDao.select(membro.getIdMembro());
            
        request.setAttribute("membro", membro);       
        request.setAttribute("menu", "adminmembro");
        return new CommandResult("listar_membro");
    }   
}

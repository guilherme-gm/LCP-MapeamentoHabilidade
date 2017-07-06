/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.commands;

import br.unesp.rc.habilidades.beans.Projeto;
import br.unesp.rc.habilidades.beans.StatusProjeto;
import br.unesp.rc.habilidades.dao.ProjetoDAO;
import br.unesp.rc.habilidades.dao.ProjetoDAOImpl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aluno
 */
public class EditarProjeto implements ICommand{

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        if (request.getParameter("id") != null) {
            long idProjeto = Long.parseLong(request.getParameter("id"));
            ProjetoDAO projetoDao = new ProjetoDAOImpl();

            Projeto projeto = projetoDao.select(idProjeto);
            
            HttpSession session = request.getSession();
            session.setAttribute("projeto", projeto);
        }
        
        request.setAttribute("menu", "adminproj");
        request.setAttribute("status", StatusProjeto.values());
        return new CommandResult("editar_projeto");
    }
    
    
}

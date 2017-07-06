/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.commands;

import br.unesp.rc.habilidades.dao.ProjetoDAO;
import br.unesp.rc.habilidades.dao.ProjetoDAOImpl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guilh
 */
public class DoFinalizarProjeto implements ICommand {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        long id = Integer.parseInt(request.getParameter("idProjeto"));
        
        ProjetoDAO projetoDao = new ProjetoDAOImpl();
        projetoDao.finaliza(id);
        
        request.setAttribute("msg_tipo", "alert-success");
        request.setAttribute("msg", "Projeto finalizado com sucesso");
        request.setAttribute("menu", "adminproj");
        return new CommandResult(request, "ListarProjeto");
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.commands;

import br.unesp.rc.habilidades.beans.Membro;
import br.unesp.rc.habilidades.beans.Permissao;
import br.unesp.rc.habilidades.dao.MembroDAO;
import br.unesp.rc.habilidades.dao.MembroDAOImpl;
import br.unesp.rc.habilidades.util.PermissaoUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Raphael
 */
public class EditarMembro implements ICommand{

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        if (!PermissaoUtils.hasPermissao(request, Permissao.GERENCIAR_MEMBROS))
        {
             return new CommandResult("forbidden");
        }
        
        int id = Integer.parseInt(request.getParameter("idMembro"));
        
        MembroDAO membroDao = new MembroDAOImpl();
        Membro membro = membroDao.select(id);
        
        request.setAttribute("membro", membro);
        request.setAttribute("menu", "adminmembro");
        return new CommandResult("editar_membro");
    }    
}

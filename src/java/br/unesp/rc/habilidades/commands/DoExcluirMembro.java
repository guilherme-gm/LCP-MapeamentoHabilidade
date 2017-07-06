/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.commands;

import br.unesp.rc.habilidades.beans.Permissao;
import br.unesp.rc.habilidades.dao.MembroDAO;
import br.unesp.rc.habilidades.dao.MembroDAOImpl;
import br.unesp.rc.habilidades.util.PermissaoUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guilh
 */
public class DoExcluirMembro implements ICommand {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        
        if (!PermissaoUtils.hasPermissao(request, Permissao.GERENCIAR_MEMBROS))
        {
             return new CommandResult("forbidden");
        }
        
        System.out.println("HELLO WORLD");
        int id = Integer.parseInt(request.getParameter("idMembro"));
        
        System.out.println("HELLO WORLD" + id);
        MembroDAO membroDao = new MembroDAOImpl();
        membroDao.remove(id);
        System.out.println("HELLO WORLD");     
        
        request.setAttribute("msg_tipo", "alert-success");
        request.setAttribute("msg", "Membro excluído com sucesso");
        request.setAttribute("menu", "adminmembro");
        return new CommandResult(request, "ListarMembro");
        
    }
    
}

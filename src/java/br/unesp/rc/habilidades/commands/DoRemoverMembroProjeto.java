/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.commands;

import br.unesp.rc.habilidades.beans.Membro;
import br.unesp.rc.habilidades.beans.Permissao;
import br.unesp.rc.habilidades.beans.Projeto;
import br.unesp.rc.habilidades.beans.Tecnologia;
import br.unesp.rc.habilidades.dao.MembroDAO;
import br.unesp.rc.habilidades.dao.MembroDAOImpl;
import br.unesp.rc.habilidades.util.PermissaoUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author guilh
 */
public class DoRemoverMembroProjeto implements ICommand {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        if (!PermissaoUtils.hasPermissao(request, Permissao.GERENCIAR_MEMBROS) || (!PermissaoUtils.hasPermissao(request, Permissao.GERENCIAR_PROJETOS)))
        {
             return new CommandResult("forbidden");
        }
        
        int idMembro = Integer.parseInt(request.getParameter("id"));
        
        HttpSession session = request.getSession();
        Projeto projeto = (Projeto) session.getAttribute("projeto");
        
        MembroDAO membroDao = new MembroDAOImpl();
        Membro membro = membroDao.select(idMembro);
        
        if (projeto.hasMembro(membro)) {
            projeto.delMembro(membro);
        }
    
        request.setAttribute("menu", "adminproj");

        if (request.getParameter("e") == null) {
            return new CommandResult(request, "SelecionaMembro");
        } else {
            return new CommandResult(request, "EditarSelecionaMembro");
        }
    }
}

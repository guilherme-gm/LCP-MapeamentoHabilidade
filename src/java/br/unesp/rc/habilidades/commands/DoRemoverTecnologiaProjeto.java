/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.commands;

import br.unesp.rc.habilidades.beans.Permissao;
import br.unesp.rc.habilidades.beans.Projeto;
import br.unesp.rc.habilidades.beans.Tecnologia;
import br.unesp.rc.habilidades.dao.TecnologiaDAO;
import br.unesp.rc.habilidades.dao.TecnologiaDAOImpl;
import br.unesp.rc.habilidades.util.PermissaoUtils;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author guilh
 */
public class DoRemoverTecnologiaProjeto implements ICommand {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        if (!PermissaoUtils.hasPermissao(request, Permissao.GERENCIAR_HABILIDADES) || (!PermissaoUtils.hasPermissao(request, Permissao.GERENCIAR_PROJETOS)))
        {
             return new CommandResult("forbidden");
        }
        
        int tecnologiaId = Integer.parseInt(request.getParameter("id"));
        
        HttpSession session = request.getSession();
        Projeto projeto = (Projeto) session.getAttribute("projeto");
        
        TecnologiaDAO tecnologiaDao = new TecnologiaDAOImpl();
        List<Tecnologia> tecnologias = tecnologiaDao.select();
        
        request.setAttribute("tecnologias", tecnologias);
        
        int i = 0;
        while (i < tecnologias.size() && tecnologias.get(i).getIdTecnologia() != tecnologiaId) {
            i++;
        }
        
        if (i == tecnologias.size()) {
            // TODO : Erro, nao encontrou
            return null;
        }
        
        Tecnologia tec = tecnologias.get(i);
        if (projeto.hasTecnologia(tec)) {
            projeto.delTecnologia(tec);
        }
    
        request.setAttribute("menu", "adminproj");

        return new CommandResult(request, "SelecionaTecnologia");
    }
}

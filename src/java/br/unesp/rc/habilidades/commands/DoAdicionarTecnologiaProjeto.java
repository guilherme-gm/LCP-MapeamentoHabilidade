/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.commands;

import br.unesp.rc.habilidades.beans.Projeto;
import br.unesp.rc.habilidades.beans.Tecnologia;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author guilh
 */
public class DoAdicionarTecnologiaProjeto implements ICommand {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        int tecnologiaId = Integer.parseInt(request.getParameter("id"));
        
        HttpSession session = request.getSession();
        Projeto projeto = (Projeto) session.getAttribute("projeto");
        List<Tecnologia> tecnologias = (List<Tecnologia>) session.getAttribute("tecnologias");
        
        int i = 0;
        while (i < tecnologias.size() && tecnologias.get(i).getIdTecnologia() != tecnologiaId) {
            i++;
        }
        
        if (i == tecnologias.size()) {
            // TODO : Erro, nao encontrou
            return null;
        }
        
        Tecnologia tec = tecnologias.get(i);
        if (!projeto.hasTecnologia(tec)) {
            projeto.addTecnologia(tec);
        }
    
        request.setAttribute("menu", "adminproj");

        return new CommandResult(request, "SelecionaTecnologia");
    }
}
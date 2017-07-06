/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.commands;

import br.unesp.rc.habilidades.beans.Projeto;
import br.unesp.rc.habilidades.dao.ProjetoDAO;
import br.unesp.rc.habilidades.dao.ProjetoDAOImpl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author guilh
 */
public class DoSalvarProjeto implements ICommand {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        Projeto projeto = (Projeto) session.getAttribute("projeto");
        //projeto.validate();

        ProjetoDAO projetoDao = new ProjetoDAOImpl();
        projetoDao.insert(projeto);

        request.setAttribute("msg_tipo", "alert-success");
        request.setAttribute("msg", "Projeto criado com sucesso.");
        request.setAttribute("menu", "adminproj");

        return new CommandResult(request, "ListarProjeto");
    }
}

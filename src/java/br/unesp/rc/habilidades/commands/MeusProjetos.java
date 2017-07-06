/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.commands;

import br.unesp.rc.habilidades.beans.Membro;
import br.unesp.rc.habilidades.beans.Projeto;
import br.unesp.rc.habilidades.dao.ProjetoDAO;
import br.unesp.rc.habilidades.dao.ProjetoDAOImpl;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author guilh
 */
public class MeusProjetos implements ICommand {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Membro membro = (Membro) session.getAttribute("membro");

        ProjetoDAO projetoDao = new ProjetoDAOImpl();
        List<Projeto> projetos = projetoDao.selectProjetoMembro(membro);

        request.setAttribute("projetos", projetos);
        request.setAttribute("menu", "adminproj");
        return new CommandResult("meus_projetos");
    }

}

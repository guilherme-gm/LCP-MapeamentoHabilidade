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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bioestat
 */
public class EditarSelecionaMembro implements ICommand {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Projeto projeto = (Projeto) session.getAttribute("projeto");

        ProjetoDAO projetoDao = new ProjetoDAOImpl();
        List<Membro> membros = projetoDao.select_membros(projeto.getTecnologia());

        for (Membro membro : membros) {
            try {
                membro.calculaRank(projeto.getTecnologia());
            } catch (Exception ex) {
                // TODO : ERRo
            }
        }
        
        Collections.sort(membros, new Comparator<Membro>() {
            @Override
            public int compare(Membro o1, Membro o2) {
                if (o1.getRank() < o2.getRank()) {
                    return 1;
                } else if (o1.getRank() > o2.getRank()) {
                    return -1;
                }
                return 0;
            }
        });

        request.setAttribute("membros", membros);
        return new CommandResult("editar_seleciona_membro");
    }

}

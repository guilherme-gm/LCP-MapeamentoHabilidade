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
import br.unesp.rc.habilidades.dao.TecnologiaMembroDAO;
import br.unesp.rc.habilidades.dao.TecnologiaMembroDaoImpl;
import br.unesp.rc.habilidades.util.PermissaoUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guilh
 */
public class ListarHabilidadesMembro implements ICommand {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
       
        if (!PermissaoUtils.hasPermissao(request, Permissao.GERENCIAR_HABILIDADES) || (!PermissaoUtils.hasPermissao(request, Permissao.GERENCIAR_MEMBROS)))
        {
             return new CommandResult("forbidden");
        }
        
        long idMembro = Long.parseLong(request.getParameter("id"));
        
        MembroDAO membroDao = new MembroDAOImpl();
        TecnologiaMembroDAO tecMembroDao = new TecnologiaMembroDaoImpl();
        Membro membro = membroDao.select(idMembro);
        //List<TecnologiaMembro> tecMembro = membroDao.select(membro);

        request.setAttribute("membro", membro);
        request.setAttribute("menu", "adminmembro");
        return new CommandResult("listar_habilidadesMembro");
    }

}

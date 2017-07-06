/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.commands;

import br.unesp.rc.habilidades.beans.Permissao;
import br.unesp.rc.habilidades.dao.TecnologiaMembroDAO;
import br.unesp.rc.habilidades.dao.TecnologiaMembroDaoImpl;
import br.unesp.rc.habilidades.util.PermissaoUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guilh
 */
public class DoExcluirTecnologiaMembro implements ICommand {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        
        if (!PermissaoUtils.hasPermissao(request, Permissao.GERENCIAR_HABILIDADES) || (!PermissaoUtils.hasPermissao(request, Permissao.GERENCIAR_MEMBROS)))
        {
             return new CommandResult("forbidden");
        }
        
        long id = Long.parseLong(request.getParameter("idTecno"));
      
        TecnologiaMembroDAO tecMembroDao = new TecnologiaMembroDaoImpl();
        
        tecMembroDao.delete(id);
        
        request.setAttribute("msg_tipo", "alert-success");
        request.setAttribute("msg", "Tecnologia excluída com sucesso");
        request.setAttribute("menu", "admintec");
        return new CommandResult(request, "ListarHabilidadesMembro");
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.commands;

import br.unesp.rc.habilidades.beans.Membro;
import br.unesp.rc.habilidades.beans.Permissao;
import br.unesp.rc.habilidades.beans.TecnologiaMembro;
import br.unesp.rc.habilidades.dao.MembroDAO;
import br.unesp.rc.habilidades.dao.MembroDAOImpl;
import br.unesp.rc.habilidades.dao.TecnologiaMembroDAO;
import br.unesp.rc.habilidades.dao.TecnologiaMembroDaoImpl;
import br.unesp.rc.habilidades.util.PermissaoUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jheny
 */
public class DoEditarTecnologiaMembro implements ICommand{

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        
        if (!PermissaoUtils.hasPermissao(request, Permissao.GERENCIAR_HABILIDADES) || (!PermissaoUtils.hasPermissao(request, Permissao.GERENCIAR_MEMBROS)))
        {
             return new CommandResult("forbidden");
        }
        
        TecnologiaMembro tecMembro = new TecnologiaMembro();
        tecMembro.setNivel(Short.parseShort(request.getParameter("nivel")));
        tecMembro.setIdTecnologiaMembro(Long.parseLong(request.getParameter("idTecnologiaMembro")));
        
        
        TecnologiaMembroDAO tecMembroDao = new TecnologiaMembroDaoImpl();
        
        MembroDAO membroDao = new MembroDAOImpl();
        Membro membro = membroDao.select(Long.parseLong(request.getParameter("idMembro")));
        tecMembro.setMembro(membro);
        
        tecMembroDao.update(tecMembro);
       
        request.setAttribute("msg_tipo", "alert-success");
        request.setAttribute("msg", "Tecnologia atualizada com sucesso.");
        request.setAttribute("menu", "admintec");
        
        return new CommandResult(request, "ListarHabilidadesMembro?id="+membro.getIdMembro());
    }
    
    
}

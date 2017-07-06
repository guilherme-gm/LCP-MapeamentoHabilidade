/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.commands;

import br.unesp.rc.habilidades.beans.Membro;
import br.unesp.rc.habilidades.beans.TecnologiaMembro;
import br.unesp.rc.habilidades.dao.TecnologiaMembroDAO;
import br.unesp.rc.habilidades.dao.TecnologiaMembroDaoImpl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author guilh
 */
public class DoExcluirTecnologiaMembro implements ICommand {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
                
        long id = Long.parseLong(request.getParameter("idTecno"));
      
        TecnologiaMembroDAO tecMembroDao = new TecnologiaMembroDaoImpl();
        
        tecMembroDao.delete(id);
        
        request.setAttribute("msg_tipo", "alert-success");
        request.setAttribute("msg", "Tecnologia excluída com sucesso");
        request.setAttribute("menu", "admintec");
        return new CommandResult(request, "ListarHabilidadesMembro");
    }
    
}

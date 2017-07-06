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
 * @author Jheny
 */
public class DoEditarTecnologiaMembro implements ICommand{

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        
        TecnologiaMembro tecMembro = new TecnologiaMembro();
        tecMembro.setNivel(Short.parseShort(request.getParameter("nivel")));
        tecMembro.setIdTecnologiaMembro(Long.parseLong(request.getParameter("idTecnologiaMembro")));
        
        
        TecnologiaMembroDAO tecMembroDao = new TecnologiaMembroDaoImpl();
        
        HttpSession session = request.getSession(true);
        Membro membro = (Membro) session.getAttribute("membro");
        tecMembro.setMembro(membro);
        
        tecMembroDao.update(tecMembro);
       
        request.setAttribute("msg_tipo", "alert-success");
        request.setAttribute("msg", "Tecnologia atualizada com sucesso.");
        request.setAttribute("menu", "admintec");
        
        return new CommandResult(request, "ListarHabilidadesMembro");
    }
    
    
}

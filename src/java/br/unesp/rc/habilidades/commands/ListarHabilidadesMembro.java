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
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author guilh
 */
public class ListarHabilidadesMembro implements ICommand {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        Membro membro = (Membro) session.getAttribute("membro");
        
        TecnologiaMembroDAO membroDao = new TecnologiaMembroDaoImpl();
        
        List<TecnologiaMembro> tecMembro = membroDao.select(membro);

        request.setAttribute("tecMembro", tecMembro);
        request.setAttribute("menu", "adminmembro");
        return new CommandResult("listar_habilidadesMembro");
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.commands;

import br.unesp.rc.habilidades.beans.Tecnologia;
import br.unesp.rc.habilidades.dao.TecnologiaDAO;
import br.unesp.rc.habilidades.dao.TecnologiaDAOImpl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jheny
 */
public class DoCriarTecnologia implements ICommand{

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        Tecnologia tec = new Tecnologia();
        tec.setNome(request.getParameter("nome"));
        
        TecnologiaDAO tecDao = new TecnologiaDAOImpl();
        
        tecDao.insert(tec);
        
        request.setAttribute("msg_tipo", "alert-success");
        request.setAttribute("msg", "Tecnologia inserido com sucesso.");
        request.setAttribute("menu", "admintec");
        
        return new CommandResult(request, "ListarTecnologia");
    }
    
    
}

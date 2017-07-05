/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.commands;

import br.unesp.rc.habilidades.beans.Tecnologia;
import br.unesp.rc.habilidades.dao.TecnologiaDAO;
import br.unesp.rc.habilidades.dao.TecnologiaDAOImpl;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guilh
 */
public class ListarTecnologia implements ICommand {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        
        TecnologiaDAO tecDao = new TecnologiaDAOImpl();
        List<Tecnologia> tec  = tecDao.select();
        
        request.setAttribute("tecnologias", tec);
        request.setAttribute("menu", "admintec");
        return new CommandResult("listar_tecnologia");
    }
    
}

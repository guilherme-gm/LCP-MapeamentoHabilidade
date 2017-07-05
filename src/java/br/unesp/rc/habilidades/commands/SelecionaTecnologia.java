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
 * @author bioestat
 */
public class SelecionaTecnologia implements ICommand{

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        
        TecnologiaDAO tecnologiaDao = new TecnologiaDAOImpl();
        List<Tecnologia> tecnologias = tecnologiaDao.select();
        
        request.setAttribute("tecnologias", tecnologias);
        
        request.setAttribute("menu", "adminproj");
        return new CommandResult("seleciona_tecnologia");
    }
    
}

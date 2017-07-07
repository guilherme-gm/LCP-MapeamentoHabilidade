/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.commands;

import br.unesp.rc.habilidades.beans.Permissao;
import br.unesp.rc.habilidades.beans.Tecnologia;
import br.unesp.rc.habilidades.dao.TecnologiaDAO;
import br.unesp.rc.habilidades.dao.TecnologiaDAOImpl;
import br.unesp.rc.habilidades.exception.ValidateException;
import br.unesp.rc.habilidades.util.PermissaoUtils;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jheny
 */
public class DoCriarTecnologia implements ICommand{

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        if (!PermissaoUtils.hasPermissao(request, Permissao.GERENCIAR_HABILIDADES)) {
            return new CommandResult("forbidden");
        }
        
        Tecnologia tec = new Tecnologia();
        tec.setNome(request.getParameter("nome"));
        
        TecnologiaDAO tecDao = new TecnologiaDAOImpl();
        
        try {        
            tec.validate();
        } catch (ValidateException ex) {
            StringBuilder sb = new StringBuilder();
            sb.append("Erros na inserção: <br /><ul>");
            for (String erro : ex.getErros()) {
                sb.append("<li>").append(erro).append("</li>");
            }
            sb.append("</ul>");
            
            request.setAttribute("msg_tipo", "alert-danger");
            request.setAttribute("msg", sb.toString());
            request.setAttribute("menu", "admintec");
            return new CommandResult(request, "CriarTecnologia");
        }
        
        tecDao.insert(tec);
        
        request.setAttribute("msg_tipo", "alert-success");
        request.setAttribute("msg", "Tecnologia inserido com sucesso.");
        request.setAttribute("menu", "admintec");
        
        return new CommandResult(request, "ListarTecnologia");
    }
    
    
}

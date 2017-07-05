/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.commands;

import br.unesp.rc.habilidades.beans.Tecnologia;
import br.unesp.rc.habilidades.dao.TecnologiaDAO;
import br.unesp.rc.habilidades.dao.TecnologiaDAOImpl;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author Jheny
 */
public class DoEditarTecnologia implements ICommand{

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        Tecnologia tec = new Tecnologia();
        
        try {
            BeanUtils.populate(tec, request.getParameterMap());
            tec.setAtivo(true);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DoLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(DoLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        TecnologiaDAO tecDao = new TecnologiaDAOImpl();
        
        tecDao.update(tec);
        
        request.setAttribute("msg_tipo", "alert-success");
        request.setAttribute("msg", "Tecnologia atualizada com sucesso.");
        request.setAttribute("menu", "admintec");
        
        return new CommandResult(request, "ListarTecnologia");
    }
    
    
}

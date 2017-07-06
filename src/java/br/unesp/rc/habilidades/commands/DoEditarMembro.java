/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.commands;

import br.unesp.rc.habilidades.beans.Cargo;
import br.unesp.rc.habilidades.beans.Membro;
import br.unesp.rc.habilidades.beans.Permissao;
import br.unesp.rc.habilidades.dao.CargoDAO;
import br.unesp.rc.habilidades.dao.CargoDAOImpl;
import br.unesp.rc.habilidades.dao.MembroDAO;
import br.unesp.rc.habilidades.dao.MembroDAOImpl;
import br.unesp.rc.habilidades.exception.ValidateException;
import br.unesp.rc.habilidades.util.PermissaoUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author Raphael
 */
public class DoEditarMembro implements ICommand{

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        
        if (!PermissaoUtils.hasPermissao(request, Permissao.GERENCIAR_MEMBROS))
        {
             return new CommandResult("forbidden");
        }
        
        MembroDAO membroDao = new MembroDAOImpl();
        Membro membro = membroDao.select(Long.parseLong(request.getParameter("idMembro")));
        
        try {
            BeanUtils.populate(membro, request.getParameterMap());
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DoLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(DoLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        CargoDAO cargoDao = new CargoDAOImpl();
        int idCargo = Integer.parseInt(request.getParameter("idCargo"));
        Cargo cargo = cargoDao.select(idCargo);
        membro.setCargo(cargo);
        
        try {
            membro.validate();
        } catch (ValidateException ex) {

            StringBuilder sb = new StringBuilder();
            sb.append("Erros na inserção: <br /><ul>");
            for (String erro : ex.getErros()) {
                sb.append("<li>").append(erro).append("</li>");
            }
            sb.append("</ul>");

            request.setAttribute("msg_tipo", "alert-danger");
            request.setAttribute("msg", sb.toString());
            request.setAttribute("menu", "adminmembro");
            return new CommandResult(request, "EditarMembro?idMembro="+membro.getIdMembro());
        }
       
        
        membroDao.update(membro);
        
        request.setAttribute("msg_tipo", "alert-success");
        request.setAttribute("msg", "Membro atualizado com sucesso.");
        request.setAttribute("menu", "adminmembro");
        return new CommandResult(request, "ListarMembro");
    }
    
    
}

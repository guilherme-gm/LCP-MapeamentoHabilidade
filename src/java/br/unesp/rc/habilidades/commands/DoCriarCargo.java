/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.commands;

import br.unesp.rc.habilidades.beans.Cargo;
import br.unesp.rc.habilidades.dao.CargoDAO;
import br.unesp.rc.habilidades.dao.CargoDAOImpl;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author guilh
 */
public class DoCriarCargo implements ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Cargo cargo = new Cargo();
        try {
            BeanUtils.populate(cargo, request.getParameterMap());
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DoLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(DoLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        CargoDAO cargoDao = new CargoDAOImpl();
        cargoDao.insert(cargo);
        
        request.setAttribute("msg_tipo", "alert-success");
        request.setAttribute("msg", "Cargo inserido com sucesso.");
        request.setAttribute("menu", "admincargo");
        return "listar_cargos";
    }
    
    
//     Acesso acesso = new Acesso();
//        try {
//            BeanUtils.populate(acesso, request.getParameterMap());
//        } catch (IllegalAccessException ex) {
//            Logger.getLogger(DoLogin.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (InvocationTargetException ex) {
//            Logger.getLogger(DoLogin.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        MembroDAO membroDao = new MembroDAOImpl();
//        Membro membro = membroDao.select(acesso.getUsuario(), acesso.getSenha());
//        
//        if (membro == null) {
//            request.setAttribute("erro", "Nome de usuário ou senha incorretos.");
//            return "home";
//        }
//        
//        request.setAttribute("menu", "home");
//        request.getSession().setAttribute("membro", membro);
//        
//        return "painel";
}

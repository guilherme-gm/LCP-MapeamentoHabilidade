/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.commands;

import br.unesp.rc.habilidades.beans.Cargo;
import br.unesp.rc.habilidades.beans.Permissao;
import br.unesp.rc.habilidades.dao.CargoDAO;
import br.unesp.rc.habilidades.dao.CargoDAOImpl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guilh
 */
public class DoEditarCargo implements ICommand {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        Cargo cargo = new Cargo();
        cargo.setIdCargo(Integer.parseInt(request.getParameter("idCargo")));
        cargo.setNome(request.getParameter("nome"));
        String[] permissoes = request.getParameterValues("permissao");
        cargo.setPermissao(Permissao.fromArray(permissoes));
        
        CargoDAO cargoDao = new CargoDAOImpl();
        cargoDao.update(cargo);
        
        request.setAttribute("msg_tipo", "alert-success");
        request.setAttribute("msg", "Cargo atualizado com sucesso.");
        request.setAttribute("menu", "admincargo");
        return new CommandResult(request, "ListarCargo");
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
//            return new CommandResult("home");
//        }
//        
//        request.setAttribute("menu", "home");
//        request.getSession().setAttribute("membro", membro);
//        
//        return new CommandResult("painel");
}

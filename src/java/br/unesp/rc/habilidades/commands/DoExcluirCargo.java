/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.commands;

import br.unesp.rc.habilidades.dao.CargoDAO;
import br.unesp.rc.habilidades.dao.CargoDAOImpl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guilh
 */
public class DoExcluirCargo implements ICommand {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        
        System.out.println("HELLO WORLD");
        int id = Integer.parseInt(request.getParameter("idCargo"));
        
        System.out.println("HELLO WORLD" + id);
        CargoDAO cargoDao = new CargoDAOImpl();
        cargoDao.delete(id);
        System.out.println("HELLO WORLD");
        request.setAttribute("msg_tipo", "alert-success");
        request.setAttribute("msg", "Cargo excluído com sucesso");
        request.setAttribute("menu", "admincargo");
        return new CommandResult(request, "ListarCargo");
    }
    
}

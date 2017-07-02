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
public class EditarCargo implements ICommand {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        
        int id = Integer.parseInt(request.getParameter("idCargo"));
        
        CargoDAO cargoDao = new CargoDAOImpl();
        Cargo cargo = cargoDao.select(id);
        
        request.setAttribute("cargo", cargo);
        request.setAttribute("permissoes", Permissao.values());
        request.setAttribute("menu", "admincargo");
        
        return new CommandResult("editar_cargos");
    }
    
}

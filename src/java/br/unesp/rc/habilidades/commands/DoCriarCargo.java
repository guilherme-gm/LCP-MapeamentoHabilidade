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
public class DoCriarCargo implements ICommand {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        Cargo cargo = new Cargo();
        cargo.setNome(request.getParameter("nome"));
        String[] permissoes = request.getParameterValues("permissao");
        cargo.setPermissao(Permissao.fromArray(permissoes));
        
        // TODO:
        // cargo.validate();

        CargoDAO cargoDao = new CargoDAOImpl();
        cargoDao.insert(cargo);

        request.setAttribute("msg_tipo", "alert-success");
        request.setAttribute("msg", "Cargo inserido com sucesso.");
        request.setAttribute("menu", "admincargo");

        return new CommandResult(request, "ListarCargo");
    }
}

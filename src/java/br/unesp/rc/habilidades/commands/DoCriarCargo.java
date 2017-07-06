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
import br.unesp.rc.habilidades.exception.ValidateException;
import br.unesp.rc.habilidades.util.PermissaoUtils;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guilh
 */
public class DoCriarCargo implements ICommand {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {

        if (!PermissaoUtils.hasPermissao(request, Permissao.GERENCIAR_CARGOS)) {
            return new CommandResult("forbidden");
        }

        Cargo cargo = new Cargo();
        cargo.setNome(request.getParameter("nome"));
        String[] permissoes = request.getParameterValues("permissao");
        cargo.setPermissao(Permissao.fromArray(permissoes));

        try {
            cargo.validate();
        } catch (ValidateException ex) {
            StringBuilder sb = new StringBuilder();
            sb.append("Erros na inserção: <br /><ul>");
            for (String erro : ex.getErros()) {
                sb.append("<li>").append(erro).append("</li>");
            }
            sb.append("</ul>");
            
            request.setAttribute("msg_tipo", "alert-danger");
            request.setAttribute("msg", sb.toString());
            request.setAttribute("menu", "admincargo");
            return new CommandResult("criar_cargos");
        }

        CargoDAO cargoDao = new CargoDAOImpl();
        cargoDao.insert(cargo);

        request.setAttribute("msg_tipo", "alert-success");
        request.setAttribute("msg", "Cargo inserido com sucesso.");
        request.setAttribute("menu", "admincargo");

        return new CommandResult(request, "ListarCargo");
    }
}

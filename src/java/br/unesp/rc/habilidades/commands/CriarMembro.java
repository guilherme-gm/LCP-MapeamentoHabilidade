/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.commands;

import br.unesp.rc.habilidades.beans.Permissao;
import br.unesp.rc.habilidades.beans.Cargo;
import br.unesp.rc.habilidades.util.PermissaoUtils;
import br.unesp.rc.habilidades.dao.CargoDAO;
import br.unesp.rc.habilidades.dao.CargoDAOImpl;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aluno
 */
public class CriarMembro implements ICommand{

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        
        if (!PermissaoUtils.hasPermissao(request, Permissao.GERENCIAR_MEMBROS))
        {
             return new CommandResult("forbidden");
        }        
        
        CargoDAO cargoDao = new CargoDAOImpl();
        List<Cargo> cargos = cargoDao.select();        
        
        request.setAttribute("Cargos", cargos);
        request.setAttribute("menu", "adminmembro");
        return new CommandResult("criar_membro");
    }
    
}

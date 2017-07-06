/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.commands;

import br.unesp.rc.habilidades.beans.Permissao;
import br.unesp.rc.habilidades.util.PermissaoUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aluno
 */
public class CriarCargos implements ICommand{

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        if (!PermissaoUtils.hasPermissao(request, Permissao.GERENCIAR_CARGOS)) {
            return new CommandResult("forbidden");
        }
        
        request.setAttribute("menu", "admincargo");
        request.setAttribute("permissoes", Permissao.values());
        
        return new CommandResult("criar_cargos");
    }
    
}

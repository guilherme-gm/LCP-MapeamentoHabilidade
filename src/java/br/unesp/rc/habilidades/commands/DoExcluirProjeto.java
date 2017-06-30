/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guilh
 */
public class DoExcluirProjeto implements ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("msg_tipo", "alert-success");
        request.setAttribute("msg", "Projeto excluído com sucesso");
        return "listar_projeto";
    }
    
}

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
public class ListarCargos implements ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("menu", "admincargo");
        return "listar_cargos";
    }
    
}

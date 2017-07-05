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
public class DoExcluirTecnologiaMembro implements ICommand {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        
        int id = Integer.parseInt(request.getParameter("idTecno"));
      
      
        request.setAttribute("msg_tipo", "alert-success");
        request.setAttribute("msg", "Tecnologia excluída com sucesso");
        request.setAttribute("menu", "admintec");
        return new CommandResult(request, "ListarHabilidadesMembro");
    }
    
}

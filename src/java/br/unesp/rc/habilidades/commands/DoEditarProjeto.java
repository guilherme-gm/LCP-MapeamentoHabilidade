/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.commands;

import br.unesp.rc.habilidades.beans.Permissao;
import br.unesp.rc.habilidades.beans.Projeto;
import br.unesp.rc.habilidades.beans.StatusProjeto;
import br.unesp.rc.habilidades.exception.ValidateException;
import br.unesp.rc.habilidades.util.PermissaoUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author guilh
 */
public class DoEditarProjeto implements ICommand {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        if (!PermissaoUtils.hasPermissao(request, Permissao.GERENCIAR_PROJETOS)) {
            return new CommandResult("forbidden");
        }        
        
        HttpSession session = request.getSession();
        Projeto projeto;
        projeto = (Projeto) session.getAttribute("projeto");

        try {
            BeanUtils.populate(projeto, request.getParameterMap());
            projeto.setStatus(StatusProjeto.valueOf(request.getParameter("pstatus")));
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DoEditarProjeto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(DoEditarProjeto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {        
            projeto.validate();
        } catch (ValidateException ex) {
            StringBuilder sb = new StringBuilder();
            sb.append("Erros na inserção: <br /><ul>");
            for (String erro : ex.getErros()) {
                sb.append("<li>").append(erro).append("</li>");
            }
            sb.append("</ul>");
            
            request.setAttribute("msg_tipo", "alert-danger");
            request.setAttribute("msg", sb.toString());
            request.setAttribute("menu", "adminproj");
            return new CommandResult(request, "EditarProjeto?id=" + projeto.getIdProjeto());
        }

        request.setAttribute("menu", "adminproj");

        return new CommandResult(request, "EditarSelecionaMembro");
    }
}

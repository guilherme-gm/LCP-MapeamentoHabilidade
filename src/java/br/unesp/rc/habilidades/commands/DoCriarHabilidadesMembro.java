/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.commands;

import br.unesp.rc.habilidades.beans.Membro;
import br.unesp.rc.habilidades.beans.Permissao;
import br.unesp.rc.habilidades.beans.Tecnologia;
import br.unesp.rc.habilidades.beans.TecnologiaMembro;
import br.unesp.rc.habilidades.dao.MembroDAO;
import br.unesp.rc.habilidades.dao.MembroDAOImpl;
import br.unesp.rc.habilidades.dao.TecnologiaDAO;
import br.unesp.rc.habilidades.dao.TecnologiaDAOImpl;
import br.unesp.rc.habilidades.dao.TecnologiaMembroDAO;
import br.unesp.rc.habilidades.dao.TecnologiaMembroDaoImpl;
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
public class DoCriarHabilidadesMembro implements ICommand {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {

        if (!PermissaoUtils.hasPermissao(request, Permissao.GERENCIAR_HABILIDADES) || (!PermissaoUtils.hasPermissao(request, Permissao.GERENCIAR_MEMBROS))) {
            return new CommandResult("forbidden");
        }

        long idMembro = Long.parseLong(request.getParameter("idMembro"));
        
        TecnologiaMembro tecMembro = new TecnologiaMembro();
        tecMembro.setNivel(Short.parseShort(request.getParameter("nivel")));

        TecnologiaDAO tecDao = new TecnologiaDAOImpl();
        Tecnologia tec = tecDao.select(Integer.parseInt(request.getParameter("tecnologia")));
        tecMembro.setTecnologia(tec);

        MembroDAO membroDao = new MembroDAOImpl();
        Membro membro = membroDao.select(idMembro);
        tecMembro.setMembro(membro);

        TecnologiaMembroDAO tecMembroDao = new TecnologiaMembroDaoImpl();
        
        
        
        try {
            tecMembro.validate();
        } catch (ValidateException ex) {

            StringBuilder sb = new StringBuilder();
            sb.append("Erros na inserção: <br /><ul>");
            for (String erro : ex.getErros()) {
                sb.append("<li>").append(erro).append("</li>");
            }
            sb.append("</ul>");

            request.setAttribute("msg_tipo", "alert-danger");
            request.setAttribute("msg", sb.toString());
            request.setAttribute("menu", "adminmembro");
            return new CommandResult(request, "CriarHabilidadesMembro?id="+idMembro);
        }
        tecMembroDao.insert(tecMembro);
        request.setAttribute("msg_tipo", "alert-success");
        request.setAttribute("msg", "Tecnologia inserido com sucesso no membro.");
        request.setAttribute("menu", "adminmembro");

        return new CommandResult(request, "ListarHabilidadesMembro?id="+idMembro);
    }
}

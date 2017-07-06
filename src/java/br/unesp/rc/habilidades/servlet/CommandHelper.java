/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.servlet;

import br.unesp.rc.habilidades.commands.CriarCargos;
import br.unesp.rc.habilidades.commands.CriarHabilidadesMembro;
import br.unesp.rc.habilidades.commands.CriarMembro;
import br.unesp.rc.habilidades.commands.CriarProjetos;
import br.unesp.rc.habilidades.commands.CriarTecnologia;
import br.unesp.rc.habilidades.commands.DoAdicionarMembroProjeto;
import br.unesp.rc.habilidades.commands.DoAdicionarTecnologiaProjeto;
import br.unesp.rc.habilidades.commands.DoCancelarProjeto;
import br.unesp.rc.habilidades.commands.DoCriarCargo;
import br.unesp.rc.habilidades.commands.DoCriarHabilidadesMembro;
import br.unesp.rc.habilidades.commands.DoCriarProjeto;
import br.unesp.rc.habilidades.commands.DoCriarTecnologia;
import br.unesp.rc.habilidades.commands.DoEditarCargo;
import br.unesp.rc.habilidades.commands.DoEditarProjeto;
import br.unesp.rc.habilidades.commands.DoEditarTecnologia;
import br.unesp.rc.habilidades.commands.DoEditarTecnologiaMembro;
import br.unesp.rc.habilidades.commands.DoExcluirCargo;
import br.unesp.rc.habilidades.commands.DoExcluirMembro;
import br.unesp.rc.habilidades.commands.DoExcluirProjeto;
import br.unesp.rc.habilidades.commands.DoExcluirTecnologia;
import br.unesp.rc.habilidades.commands.DoExcluirTecnologiaMembro;
import br.unesp.rc.habilidades.commands.DoFinalizarProjeto;
import br.unesp.rc.habilidades.commands.DoLogin;
import br.unesp.rc.habilidades.commands.DoLogout;
import br.unesp.rc.habilidades.commands.DoRemoverMembroProjeto;
import br.unesp.rc.habilidades.commands.DoRemoverTecnologiaProjeto;
import br.unesp.rc.habilidades.commands.DoSalvarEditarProjeto;
import br.unesp.rc.habilidades.commands.DoSalvarProjeto;
import br.unesp.rc.habilidades.commands.EditarCargo;
import br.unesp.rc.habilidades.commands.EditarProjeto;
import br.unesp.rc.habilidades.commands.EditarSelecionaMembro;
import br.unesp.rc.habilidades.commands.EditarSelecionaTecnologia;
import br.unesp.rc.habilidades.commands.EditarTecnologia;
import br.unesp.rc.habilidades.commands.EditarUsuario;
import br.unesp.rc.habilidades.commands.Home;
import br.unesp.rc.habilidades.commands.ICommand;
import br.unesp.rc.habilidades.commands.ListarCargos;
import br.unesp.rc.habilidades.commands.ListarHabilidadesMembro;
import br.unesp.rc.habilidades.commands.ListarMembro;
import br.unesp.rc.habilidades.commands.ListarProjeto;
import br.unesp.rc.habilidades.commands.ListarTecnologia;
import br.unesp.rc.habilidades.commands.MinhasTecnologias;
import br.unesp.rc.habilidades.commands.MeusProjetos;
import br.unesp.rc.habilidades.commands.NotFound;
import br.unesp.rc.habilidades.commands.SelecionaMembro;
import br.unesp.rc.habilidades.commands.SelecionaTecnologia;
import br.unesp.rc.habilidades.commands.Usuario;

/**
 *
 * @author guilh
 */
public class CommandHelper {

    public static ICommand getCommand(String context) {
        switch (context) {
            case "/":
            case "/Home":
                return new Home();

            case "/Usuario":
                return new Usuario();

            case "/EditarUsuario":
                return new EditarUsuario();
                
            case "/ListarHabilidadesMembro":
                return new ListarHabilidadesMembro();

            case "/CriarHabilidadesMembro":
                return new CriarHabilidadesMembro();
                
            case "/DoCriarHabilidadesMembro":
                return new DoCriarHabilidadesMembro();
                
            case "/DoEditarTecnologiaMembro":
                return new DoEditarTecnologiaMembro();
            
            case "/DoExcluirTecnologiaMembro":
                return new DoExcluirTecnologiaMembro();
                
            case "/doLogin":
                return new DoLogin();

            case "/DoLogout":
                return new DoLogout();

            case "/ListarCargo":
                return new ListarCargos();

            case "/DoExcluirCargo":
                return new DoExcluirCargo();

            case "/CriarCargos":
                return new CriarCargos();

            case "/DoCriarCargo":
                return new DoCriarCargo();

            case "/EditarCargo":
                return new EditarCargo();

            case "/DoEditarCargo":
                return new DoEditarCargo();

            case "/CriarTecnologia":
                return new CriarTecnologia();

            case "/ListarMembro":
                return new ListarMembro();

            case "/DoExcluirMembro":
                return new DoExcluirMembro();

            case "/CriarMembro":
                return new CriarMembro();

            case "/ListarProjeto":
                return new ListarProjeto();

            case "/DoExcluirProjeto":
                return new DoExcluirProjeto();

            case "/CriarProjetos":
                return new CriarProjetos();

            case "/DoCriarProjeto":
                return new DoCriarProjeto();

            case "/ListarTecnologia":
                return new ListarTecnologia();

            case "/DoExcluirTecnologia":
                return new DoExcluirTecnologia();
             
            case "/DoCriarTecnologia":
                return new DoCriarTecnologia();
               
            case "/DoEditarTecnologia":
                return new DoEditarTecnologia();
                
            case "/EditarTecnologia":
                return new EditarTecnologia();

            case "/SelecionaMembro":
                return new SelecionaMembro();

            case "/DoAdicionarMembroProjeto":
                return new DoAdicionarMembroProjeto();

            case "/DoRemoverMembroProjeto":
                return new DoRemoverMembroProjeto();

            case "/SelecionaTecnologia":
                return new SelecionaTecnologia();

            case "/DoAdicionarTecnologiaProjeto":
                return new DoAdicionarTecnologiaProjeto();

            case "/DoRemoverTecnologiaProjeto":
                return new DoRemoverTecnologiaProjeto();
                
            case "/DoSalvarProjeto":
                return new DoSalvarProjeto();
                
            case "/DoFinalizarProjeto":
                return new DoFinalizarProjeto();
                
            case "/DoCancelarProjeto":
                return new DoCancelarProjeto();

            case "/EditarProjeto":
                return new EditarProjeto();
                
            case "/DoEditarProjeto":
                return new DoEditarProjeto();
                
            case "/EditarSelecionaTecnologia":
                return new EditarSelecionaTecnologia();
                
            case "/EditarSelecionaMembro":
                return new EditarSelecionaMembro();
             
            case "/DoSalvarEditarProjeto":
                return new DoSalvarEditarProjeto();
             
            case "/MinhasTecnologias":
                return new MinhasTecnologias();
                
            case "/MeusProjetos":
                return new MeusProjetos();
        }
        return new NotFound();
    }
}

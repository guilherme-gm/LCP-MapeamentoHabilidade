/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.servlet;

import br.unesp.rc.habilidades.commands.CriarCargos;
import br.unesp.rc.habilidades.commands.CriarMembro;
import br.unesp.rc.habilidades.commands.CriarProjetos;
import br.unesp.rc.habilidades.commands.CriarTecnologia;
import br.unesp.rc.habilidades.commands.DoExcluirCargo;
import br.unesp.rc.habilidades.commands.DoExcluirMembro;
import br.unesp.rc.habilidades.commands.DoExcluirProjeto;
import br.unesp.rc.habilidades.commands.DoExcluirTecnologia;
import br.unesp.rc.habilidades.commands.DoLogin;
import br.unesp.rc.habilidades.commands.EditarUsuario;
import br.unesp.rc.habilidades.commands.Home;
import br.unesp.rc.habilidades.commands.ICommand;
import br.unesp.rc.habilidades.commands.ListarCargos;
import br.unesp.rc.habilidades.commands.ListarMembro;
import br.unesp.rc.habilidades.commands.ListarProjeto;
import br.unesp.rc.habilidades.commands.ListarTecnologia;
import br.unesp.rc.habilidades.commands.NotFound;
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

            case "/doLogin":
                return new DoLogin();

            case "/ListarCargo":
                return new ListarCargos();

            case "/DoExcluirCargo":
                return new DoExcluirCargo();

            case "/CriarCargos":
                return new CriarCargos();

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

            case "/ListarTecnologia":
                return new ListarTecnologia();

            case "/DoExcluirTecnologia":
                return new DoExcluirTecnologia();
        }
        return new NotFound();
    }
}

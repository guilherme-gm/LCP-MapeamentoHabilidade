/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.servlet;

import br.unesp.rc.habilidades.commands.CriarCargos;
import br.unesp.rc.habilidades.commands.CriarProjetos;
import br.unesp.rc.habilidades.commands.CriarTecnologia;
import br.unesp.rc.habilidades.commands.DoLogin;
import br.unesp.rc.habilidades.commands.Home;
import br.unesp.rc.habilidades.commands.ICommand;
import br.unesp.rc.habilidades.commands.ListarCargos;
import br.unesp.rc.habilidades.commands.NotFound;

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

            case "/doLogin":
                return new DoLogin();
                
            case "/ListarCargos":
                return new ListarCargos();
            
            case "/CriarCargos":
                return new CriarCargos();
                
            case "/CriarTecnologia":
                return new CriarTecnologia();
            
            case "/CriarProjetos":
                return new CriarProjetos();
        }

        return new NotFound();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.servlet;

import br.unesp.rc.habilidades.commands.Home;
import br.unesp.rc.habilidades.commands.ICommand;
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
        }
        
        return new NotFound();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.exception;

import java.util.List;

/**
 *
 * @author guilh
 */
public class ValidateException extends Exception {

    private final List<String> erros;

    public ValidateException(List<String> erros) {
        this.erros = erros;
    }
    
    public List<String> getErros() {
        return this.erros;
    }
}

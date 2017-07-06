/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.beans;

import java.util.EnumSet;

/**
 *
 * @author guilh
 */
public enum StatusProjeto {
    EM_ANDAMENTO,
    CANCELADO,
    CONCLUIDO;

    public String getDisplayName() {
        switch (this) {
            case EM_ANDAMENTO:
                return "Em Andamento";
            case CANCELADO:
                return "Cancelado";
            case CONCLUIDO:
                return "Finalizado";
        }
        return "";
    }
}

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
public enum Permissao {
    GERENCIAR_CARGOS,
    GERENCIAR_PROJETOS,
    GERENCIAR_HABILIDADES;

    public String getDisplayName() {
        switch (this) {
            case GERENCIAR_PROJETOS:
                return "Gerenciar Projetos";
            case GERENCIAR_CARGOS:
                return "Gerenciar Cargos";
            case GERENCIAR_HABILIDADES:
                return "Gerenciar Habilidades";
        }
        return "";
    }

    public static String serialize(EnumSet<Permissao> set) {
        StringBuilder strBuilder = new StringBuilder();
        for (Permissao p : set) {
            strBuilder.append(p.toString()).append(",");
        }

        String serialized = strBuilder.toString();
        if (serialized.length() > 0) {
            return serialized.substring(0, serialized.lastIndexOf(","));
        } else {
            return serialized;
        }
    }

    public static EnumSet<Permissao> fromArray(String[] permissoes) {
        EnumSet<Permissao> permissao = EnumSet.noneOf(Permissao.class);

        if (permissoes != null && permissoes.length > 0) {
            if (!permissoes[0].equals("")) {
                for (String p : permissoes) {
                    permissao.add(Permissao.valueOf(p));
                }
            }
        }

        return permissao;
    }

    public static EnumSet<Permissao> deserialize(String serialized) {
        String[] permissoes = serialized.split(",");
        return fromArray(permissoes);
    }
}

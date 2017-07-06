package br.unesp.rc.habilidades.beans;

import br.unesp.rc.habilidades.exception.ValidateException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public class Cargo {

    private int idCargo;

    private String nome;

    private EnumSet<Permissao> permissao = EnumSet.noneOf(Permissao.class);

    public void validate() throws ValidateException {
        List<String> erros = new ArrayList<>();
        
        if (this.nome.length() == 0) {
            erros.add("O nome é obrigatório");
        } else if (this.nome.length() >= 50) {
            erros.add("O nome deve ter menos de 50 caracteres");
        }
                
        if (erros.size() > 0) {
            throw new ValidateException(erros);
        }
    }

    public int getIdCargo() {
        return idCargo;
    }

    public String getNome() {
        return nome;
    }

    public EnumSet<Permissao> getPermissao() {
        return permissao;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPermissao(EnumSet<Permissao> permissao) {
        this.permissao = permissao;
    }
    
    public boolean hasPermissao(Permissao permissao) {
        return this.permissao.contains(permissao);
    }

}

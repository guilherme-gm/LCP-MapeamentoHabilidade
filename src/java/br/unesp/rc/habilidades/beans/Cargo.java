package br.unesp.rc.habilidades.beans;

import br.unesp.rc.habilidades.exception.ValidateException;
import java.util.ArrayList;
import java.util.List;

public class Cargo {

    private int idCargo;

    private String nome;

    private int permissao;

    public void validate() throws ValidateException {
        List<String> erros = new ArrayList<>();
        
        if (this.nome.length() == 0) {
            erros.add("O nome é obrigatório");
        } else if (this.nome.length() >= 50) {
            erros.add("O nome deve ter menos de 50 caracteres");
        }
        
        if (this.permissao == 0) {
            erros.add("Pelo menos uma permissão deve ser definida");
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

    public int getPermissao() {
        return permissao;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPermissao(int permissao) {
        this.permissao = permissao;
    }

}

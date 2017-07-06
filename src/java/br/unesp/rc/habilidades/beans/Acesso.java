package br.unesp.rc.habilidades.beans;

import br.unesp.rc.habilidades.exception.ValidateException;
import java.util.ArrayList;
import java.util.List;

public class Acesso {

    private long idAcesso;

    private String usuario;

    private String senha;

    public void validate() throws ValidateException {

        List<String> erros = new ArrayList<>();

        if (this.usuario.length() == 0) {
            erros.add("O usuário é obrigatório");
        }else if (this.usuario.length() >= 50) {
            erros.add("O usuário deve ter menos de 50 caracteres");
        }
        
        if(this.senha.length() < 4){
            erros.add("Senha inválida");
        }
        
        if (erros.size() > 0) {
            throw new ValidateException(erros);
        }
    }

    public long getIdAcesso() {
        return idAcesso;
    }

    public void setIdAcesso(long idAcesso) {
        this.idAcesso = idAcesso;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}

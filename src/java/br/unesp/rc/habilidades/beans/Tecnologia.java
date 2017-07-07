package br.unesp.rc.habilidades.beans;

import br.unesp.rc.habilidades.exception.ValidateException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tecnologia {

    private int idTecnologia;

    private String nome;
    
    private boolean ativo;

    public void validate() throws ValidateException {
        
        List<String> erros = new ArrayList<>();
        
        if(this.nome.length() == 0)
        {
            erros.add("Nome de Tecnologia Inválido!");
        }
        if(this.nome.length() > 50)
        {
            erros.add("Nome Deve Ter Menos de 50 caracteres");
        }
        if (erros.size() > 0) {
            throw new ValidateException(erros);
        }

    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public int getIdTecnologia() {
        return idTecnologia;
    }

    public void setIdTecnologia(int idTecnologia) {
        this.idTecnologia = idTecnologia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tecnologia other = (Tecnologia) obj;
        if (this.idTecnologia != other.idTecnologia) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.idTecnologia;
        hash = 17 * hash + Objects.hashCode(this.nome);
        hash = 17 * hash + (this.ativo ? 1 : 0);
        return hash;
    }

    

    
}

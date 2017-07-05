package br.unesp.rc.habilidades.beans;

import java.util.Objects;

public class Tecnologia {

    private int idTecnologia;

    private String nome;
    
    private boolean ativo;

    public void validate() {

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

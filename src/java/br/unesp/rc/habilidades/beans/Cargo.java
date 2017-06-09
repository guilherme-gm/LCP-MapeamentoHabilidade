package br.unesp.rc.habilidades.beans;

public class Cargo {

    private int idCargo;

    private String nome;

    private int permissao;

    public void validate() {

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

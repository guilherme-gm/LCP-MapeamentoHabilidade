package br.unesp.rc.habilidades.beans;

public class Acesso {

	private long idAcesso;

	private String usuario;

	private String senha;

	public void validate() {

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

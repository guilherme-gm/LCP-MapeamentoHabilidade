package br.unesp.rc.habilidades.beans;

public class Tecnologia {

	private int idTecnologia;

	private String nome;

	private TecnologiaMembro[] tecnologiaMembro;

	private Projeto projeto;
        
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

    public TecnologiaMembro[] getTecnologiaMembro() {
        return tecnologiaMembro;
    }

    public void setTecnologiaMembro(TecnologiaMembro[] tecnologiaMembro) {
        this.tecnologiaMembro = tecnologiaMembro;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }
        
}

package br.unesp.rc.habilidades.beans;

public class Projeto {

	private long idProjeto;

	private String nome;

	private String descricao;

	private Date dataInicio;

	private Date dataFim;

	private String status;

	private Membro[] membro;

	private Tecnologia tecnologia;

	private Tecnologia[] tecnologia;

	public void validate() {

	}

}

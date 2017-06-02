package br.unesp.rc.habilidades.beans;

import java.util.Date;

public class Projeto {

	private long idProjeto;

	private String nome;

	private String descricao;

	private Date dataInicio;

	private Date dataFim;

	private String status;

	private Membro[] membro;

	private Tecnologia[] tecnologia;

	public void validate() {

	}

}

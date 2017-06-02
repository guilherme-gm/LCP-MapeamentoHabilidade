package br.unesp.rc.habilidades.beans;

import java.util.Date;

public class Membro {

	private long idMembro;

	private String nome;

	private String telefone;

	private String email;

	private Date dataContratacao;

	private Acesso acesso;

	private Cargo cargo;

	private TecnologiaMembro[] tecnologiaMembro;

	private Projeto[] projeto;

	public void validate() {

	}

}

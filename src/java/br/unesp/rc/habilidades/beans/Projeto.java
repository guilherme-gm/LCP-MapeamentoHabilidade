package br.unesp.rc.habilidades.beans;

import java.sql.Date;

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

    public long getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(long idProjeto) {
        this.idProjeto = idProjeto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Membro[] getMembro() {
        return membro;
    }

    public void setMembro(Membro[] membro) {
        this.membro = membro;
    }

    public Tecnologia[] getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(Tecnologia[] tecnologia) {
        this.tecnologia = tecnologia;
    }

}

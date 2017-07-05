package br.unesp.rc.habilidades.beans;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Projeto {

    private long idProjeto;

    private String nome;

    private String descricao;

    private Date dataInicio;

    private Date dataFim;

    private String status;

    private List<Membro> membro;

    private List<Tecnologia> tecnologia;

    public Projeto() {
        this.membro = new ArrayList<>();
        this.tecnologia = new ArrayList<>();
    }

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

    public List<Membro> getMembro() {
        return membro;
    }

    public void setMembro(List<Membro> membro) {
        this.membro = membro;
    }

    public List<Tecnologia> getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(List<Tecnologia> tecnologia) {
        this.tecnologia = tecnologia;
    }

    public boolean hasTecnologia(Tecnologia tecnologia) {
        return this.tecnologia.contains(tecnologia);
    }

    public void addTecnologia(Tecnologia tecnologia) {
        this.tecnologia.add(tecnologia);
    }
    
    public void delTecnologia(Tecnologia tecnologia) {
        this.tecnologia.remove(tecnologia);
    }

}

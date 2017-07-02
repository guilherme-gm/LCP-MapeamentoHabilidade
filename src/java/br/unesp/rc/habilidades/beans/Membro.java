package br.unesp.rc.habilidades.beans;

import java.sql.Date;

public class Membro {

    private long idMembro;

    private String nome;

    private String telefone;

    private String email;

    private Date dataContratacao;

    private Acesso acesso;

    private Cargo cargo;

    private boolean ativo;

    private TecnologiaMembro[] tecnologiaMembro;

    private Projeto[] projeto;

    public void validate() {

    }
    
    public boolean hasPermissao(Permissao permissao) {
        return this.cargo.hasPermissao(permissao);
    }

    public long getIdMembro() {
        return idMembro;
    }

    public void setIdMembro(long idMembro) {
        this.idMembro = idMembro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(Date dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public Acesso getAcesso() {
        return acesso;
    }

    public void setAcesso(Acesso acesso) {
        this.acesso = acesso;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public TecnologiaMembro[] getTecnologiaMembro() {
        return tecnologiaMembro;
    }

    public void setTecnologiaMembro(TecnologiaMembro[] tecnologiaMembro) {
        this.tecnologiaMembro = tecnologiaMembro;
    }

    public Projeto[] getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto[] projeto) {
        this.projeto = projeto;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}

package br.unesp.rc.habilidades.beans;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

public class Membro {

    private long idMembro;

    private String nome;//

    private String telefone;//

    private String email;//

    private Date dataContratacao;//

    private Acesso acesso;

    private Cargo cargo;//

    private boolean ativo;//

    private List<TecnologiaMembro> tecnologiaMembro;
    
    private int rank;

    public void validate() {

    }
    
    public boolean hasPermissao(Permissao permissao) {
        return this.cargo.hasPermissao(permissao);
    }
    
    public boolean hasPermissao(String permissao) {
        return this.cargo.hasPermissao(Permissao.valueOf(permissao));
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

    public List<TecnologiaMembro> getTecnologiaMembro() {
        return tecnologiaMembro;
    }

    public void setTecnologiaMembro(List<TecnologiaMembro> tecnologiaMembro) {
        this.tecnologiaMembro = tecnologiaMembro;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    public void calculaRank(List<Tecnologia> tecnologias) throws Exception {
        this.rank = 0;
        for (Tecnologia tecnologia : tecnologias) {
            int i = 0;
            while (i < this.tecnologiaMembro.size() && this.tecnologiaMembro.get(i).getTecnologia().getIdTecnologia() != tecnologia.getIdTecnologia())
                i++;
            
            if (i == this.tecnologiaMembro.size()) {
                throw new Exception("Membro nãoa possui uma tecnologia requerida!");
            }
            
            this.rank += this.tecnologiaMembro.get(i).getNivel();
        }
    }

    public int getRank() {
        return rank;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + (int) (this.idMembro ^ (this.idMembro >>> 32));
        hash = 47 * hash + Objects.hashCode(this.nome);
        hash = 47 * hash + Objects.hashCode(this.telefone);
        hash = 47 * hash + Objects.hashCode(this.email);
        hash = 47 * hash + Objects.hashCode(this.dataContratacao);
        hash = 47 * hash + Objects.hashCode(this.acesso);
        hash = 47 * hash + Objects.hashCode(this.cargo);
        hash = 47 * hash + (this.ativo ? 1 : 0);
        return hash;
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
        final Membro other = (Membro) obj;
        if (this.idMembro != other.idMembro) {
            return false;
        }
        return true;
    }

}

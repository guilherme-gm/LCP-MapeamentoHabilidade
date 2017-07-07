package br.unesp.rc.habilidades.beans;

import br.unesp.rc.habilidades.exception.ValidateException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Projeto {

    private long idProjeto;

    private String nome;

    private String descricao;

    private Date dataInicio;

    private Date dataFim;

    private StatusProjeto status;

    private List<Membro> membro;

    private List<Tecnologia> tecnologia;

    public Projeto() {
        this.membro = new ArrayList<>();
        this.tecnologia = new ArrayList<>();
    }

    public void validate() throws ValidateException {

        List<String> erros = new ArrayList<>();

        if(this.nome.length() == 0)
        {
            erros.add("Nome de Projeto Inválido!");
        }
        if(this.nome.length() > 50)
        {
            erros.add("Nome Deve Ter Menos de 50 caracteres");
        }        
        if(this.dataFim.before(dataInicio))
        {
            erros.add("Data de Entrega Deve Ser Alguma Data Após a Data Inicial!");
        }
        if(this.descricao.length() == 0)
        {
            erros.add("Descrição Necessária!");
        }        
        if (erros.size() > 0) {
            throw new ValidateException(erros);
        }
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

    public StatusProjeto getStatus() {
        return status;
    }

    public void setStatus(StatusProjeto status) {
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
    
    public boolean hasMembro(Membro membro) {
        return this.membro.contains(membro);
    }
    
    public void addMembro(Membro membro) {
        this.membro.add(membro);
    }
    
    public void delMembro(Membro membro) {
        this.membro.remove(membro);
    }
}

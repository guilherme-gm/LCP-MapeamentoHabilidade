package br.unesp.rc.habilidades.beans;

import br.unesp.rc.habilidades.exception.ValidateException;
import java.util.ArrayList;
import java.util.List;

public class TecnologiaMembro {

    private long idTecnologiaMembro;

    private short nivel;

    private Tecnologia tecnologia;

    private Membro membro;

    public void validate() throws ValidateException {

        List<String> erros = new ArrayList<>();

        if (this.nivel < 0 || this.nivel > 10) {
            erros.add("Nível inválido");
        }
        if (this.tecnologia == null) {
            erros.add("Tecnologia invalida");
        }

        if (erros.size() > 0) {
            throw new ValidateException(erros);
        }
    }

    public long getIdTecnologiaMembro() {
        return idTecnologiaMembro;
    }

    public void setIdTecnologiaMembro(long idTecnologiaMembro) {
        this.idTecnologiaMembro = idTecnologiaMembro;
    }

    public short getNivel() {
        return nivel;
    }

    public Membro getMembro() {
        return membro;
    }

    public void setMembro(Membro membro) {
        this.membro = membro;
    }

    public void setNivel(short nivel) {
        this.nivel = nivel;
    }

    public Tecnologia getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(Tecnologia tecnologia) {
        this.tecnologia = tecnologia;
    }

}

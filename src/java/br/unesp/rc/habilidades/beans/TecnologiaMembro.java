package br.unesp.rc.habilidades.beans;

public class TecnologiaMembro {

	private long idTecnologiaMembro;

	private short nivel;

	private Tecnologia tecnologia;
        
        private Membro membro;

	public void validate() {

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

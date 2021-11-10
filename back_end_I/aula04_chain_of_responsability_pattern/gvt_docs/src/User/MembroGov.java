package User;

import Documento.Doc;

public abstract class MembroGov {

    protected int nivelAcesso;
    protected MembroGov proxMembroGov;

    public abstract void lerDoc (Doc doc);

    public int getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(int nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    public MembroGov getMembroGov() {
        return proxMembroGov;
    }

    public void setProxMembroGov (MembroGov proxMembroGov) {
        this.proxMembroGov = proxMembroGov;
    }
    //tanto faz??? qual a diferença afinal???
//    public MembroGov setProxMembroGov(MembroGov proxMembroGov) {
//        this.proxMembroGov = proxMembroGov;
//        return this;
//    }
}

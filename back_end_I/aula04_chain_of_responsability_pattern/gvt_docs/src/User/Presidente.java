package User;

import Documento.Doc;

public class Presidente extends MembroGov{

    public Presidente() {
        this.nivelAcesso = 3;
    }

    @Override
    public void lerDoc(Doc doc) {
        System.out.println("Acesso concedido ao Presidente.\n");
    }
}

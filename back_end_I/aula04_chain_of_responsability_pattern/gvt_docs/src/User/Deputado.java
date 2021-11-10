package User;

import Documento.Doc;

public class Deputado extends MembroGov{

    public Deputado() {
        this.nivelAcesso = 1;
    }

    @Override
    public void lerDoc(Doc doc) {
        switch (doc.getTipo()){
            case 1:
                System.out.println("Acesso concedido ao Deputado.");
                this.proxMembroGov.lerDoc(doc);
                break;
            case 2:
            case 3:
                System.out.println("Acesso negado ao Deputado.");
                this.proxMembroGov.lerDoc(doc);
                break;
            default:
                System.out.println("Pane no sistema, alguém me desconfigurou. Aonde estão meus olhos de robô?");
        }
    }
}

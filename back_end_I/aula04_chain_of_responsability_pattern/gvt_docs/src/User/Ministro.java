package User;

import Documento.Doc;

public class Ministro extends MembroGov{

    public Ministro() {
        this.nivelAcesso = 2;
    }

    @Override
    public void lerDoc(Doc doc) {
        switch (doc.getTipo()){
            case 1:
            case 2:
                System.out.println("Acesso concedido ao Ministro.");
                this.proxMembroGov.lerDoc(doc);
                break;
            case 3:
                System.out.println("Acesso negado ao Ministro.");
                this.proxMembroGov.lerDoc(doc);
                break;
            default:
                System.out.println("Pane no sistema, alguém me desconfigurou. Aonde estão meus olhos de robô?");
        }
    }
}

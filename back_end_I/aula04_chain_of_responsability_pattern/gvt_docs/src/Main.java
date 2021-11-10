import Documento.Doc;
import User.MembroGov;
import User.Deputado;
import User.Ministro;
import User.Presidente;

public class Main {
    public static void main(String[] args) {

        //Criando docs
        Doc doc1 = new Doc("Carta do Presidente da Angola", 3);
        Doc doc2 = new Doc("PL nº 654/2021", 1);
        Doc doc3 = new Doc("Ata de Reunião Interministerial nº 003/2019", 2);

        //Criando membros do gov
        MembroGov dpt = new Deputado();
        MembroGov min = new Ministro();
        MembroGov pr = new Presidente();

        //Estabelecendo hierarquia
        dpt.setProxMembroGov(min);
        min.setProxMembroGov(pr);

        //solicitando leitura de docs
        dpt.lerDoc(doc1);
        min.lerDoc(doc3);
        pr.lerDoc(doc2);
    }
}

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        //criação de filmes
        Filme bacurau = new Filme("Bacurau");
        Filme animalCordial = new Filme("O Animal Cordial");
        Filme desertoParticular = new Filme("Deserto Particular");
        Filme somAoRedor = new Filme("O Som Ao Redor");
        Filme aquarius = new Filme("Aquarius");


        //armazenando filmes em lista
        List<Filme> listaFilmes = new ArrayList<>();
        listaFilmes.add(bacurau);
        listaFilmes.add(animalCordial);
        listaFilmes.add(desertoParticular);
        listaFilmes.add(somAoRedor);
        listaFilmes.add(aquarius);


        //magia da serialização acontecendo -> saída de fluxo de dados para um arquivo .ser

        try {
            FileOutputStream fileOut = new FileOutputStream("lista_filmes.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(listaFilmes);
            out.close(); //Deixei anotado, mas cumpre registrar que é dispensável e que só faz sentido num contexto de banco de dados, para não manter a conexão
            fileOut.close();
        } catch (FileNotFoundException e) {
            System.err.println("ERROR: Erro de arquivo não encontrado!");
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }


        //bruxaria da desserialização agora -> entrada de fluxo de dados, recebe arquivo .ser e extrai seu conteúdo

        List<Filme> nacionaisFavoritos;

            try {
                FileInputStream fileIn = new FileInputStream("C:\\Users\\Pedro Brito\\Desktop\\CTD\\ano01\\bimestre03\\back_end\\modulo02_testes_unitarios_logging_e_acesso_a_dados\\aula14_serializacao_de_objetos_e_io_de_arquivos\\exercicios\\lista_filmes\\lista_filmes.ser"); //lembrar que no endereço deve-se utilizar "\\" em vez de somente uma
                ObjectInputStream in = new ObjectInputStream(fileIn);
                nacionaisFavoritos = (ArrayList<Filme>) in.readObject(); //fazendo casting do nacionaisFavoritos, que é do tipo List, como ArrayList
                in.close();
                fileIn.close(); //Deixei anotado, mas cumpre registrar que é dispensável e que só faz sentido num contexto de banco de dados, para não manter a conexão

                //vamos ver se rolou
                System.out.println(nacionaisFavoritos.toString());

                //de brinde, vamos ver o serialVersionUID de nacionaisFavoritos
                long serialVersionUID = ObjectStreamClass.lookup(nacionaisFavoritos.getClass()).getSerialVersionUID();
                System.out.println(serialVersionUID);

            } catch (FileNotFoundException e) {
                System.err.println("ERROR: Erro de arquivo não encontrado!");
            } catch (Exception e) {
                System.err.println("ERROR: " + e.getMessage());
            }
    }
}

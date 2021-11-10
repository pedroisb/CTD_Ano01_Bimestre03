package Filmes;

import java.util.ArrayList;
import java.util.List;

public class GradeFilmes implements IGradeFilmes{

    private List<Filme> filmes;

    public GradeFilmes() {
        this.filmes = new ArrayList<>();
    }

    @Override
    public Filme getFilme(String nome) throws FilmeNaoHabilitadoException {

        Filme filmeSelecionado = this.filmes.stream().filter(filme -> filme.getNome().equals(nome)).findFirst().orElse(null);

        System.out.println("Você selecionou "+nome+". Acesse o link "+filmeSelecionado.getLink()+" e bom filme! \n");

        return filmeSelecionado;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }
}

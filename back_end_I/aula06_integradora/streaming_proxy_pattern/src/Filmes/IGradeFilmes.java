package Filmes;

public interface IGradeFilmes {

    public Filme getFilme(String nome) throws FilmeNaoHabilitadoException;
}

package Filmes;

import UsuarioIP.Ip;

public class GradeFilmesProxy implements IGradeFilmes{

    private Ip ip;
    private GradeFilmes gradeFilmes;

    public GradeFilmesProxy(Ip ip, GradeFilmes gradeFilmes) {
        this.ip = ip;
        this.gradeFilmes = gradeFilmes;
    }

    @Override
    public Filme getFilme(String nome) throws FilmeNaoHabilitadoException {

        Filme filmeSelecionado = gradeFilmes.getFilmes().stream().filter(filme -> filme.getNome().equals(nome)).findFirst().orElse(null);

        if (
            !(filmeSelecionado.getPais().equals("Argentina")) && (this.ip.getNumIp().get(0) >= 0 && this.ip.getNumIp().get(0) < 50) ||
            !(filmeSelecionado.getPais().equals("Brasil")) && (this.ip.getNumIp().get(0) >= 50 && this.ip.getNumIp().get(0) < 100) ||
            !(filmeSelecionado.getPais().equals("Colômbia")) && (this.ip.getNumIp().get(0) >= 100 && this.ip.getNumIp().get(0) < 150)
        ){
            throw new FilmeNaoHabilitadoException("O filme "+nome+" não se encontra disponível em seu país.\n");
        } else if (this.ip.getNumIp().get(0) >= 150)
            throw new FilmeNaoHabilitadoException("Você não reside em um dos países atendidos por nossos serviços. Sentimos muito.\n");

        return this.gradeFilmes.getFilme(nome);
    }
}

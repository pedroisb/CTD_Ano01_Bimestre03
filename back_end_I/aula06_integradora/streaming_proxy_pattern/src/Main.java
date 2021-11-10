import Filmes.*;
import Series.*;
import UsuarioIP.Ip;

public class Main {
    public static void main(String[] args) {

        //CRIAÇÃO USUÁRIOS
        Ip userArg = new Ip(32,185,255,55);
        Ip userBr = new Ip(50,201,255,102);
        Ip userCol = new Ip(136,100,255,6);
        Ip userOutro = new Ip(222,65,255,3);


        //CRIAÇÃO DOS FILMES
        Filme bacurau = new Filme("Bacurau","Brasil","www.bacurau.com.br");
        Filme medianeras = new Filme("Medianeras","Argentina","www.medianeras.com.ar");
        Filme elPatron = new Filme ("El Patrón", "Colômbia", "www.elpatron.com.co");

        //ADIÇÃO DOS FILMES À GRADE DE FILMES
        GradeFilmes gradeFilmes = new GradeFilmes();
        gradeFilmes.getFilmes().add(medianeras);
        gradeFilmes.getFilmes().add(bacurau);
        gradeFilmes.getFilmes().add(elPatron);


        //CRIAÇÃO DAS SERIES
        Serie laCasaDePapel = new Serie("La Casa de Papel","Espanha", "www.lacasadepapel.com.es");
        Serie rickAndMorty = new Serie("Rick and Morty","EUA", "www.rickandmorty.com");
        Serie sexEducation = new Serie("Sex Education","Reino Unido", "www.sexeducation.com.uk");
        Serie dixPourCent = new Serie("Dix pour Cent","França", "www.dixpourcent.com.fr");
        Serie onePunchMan = new Serie("One Punch Man","Japão", "www.onepunchman.com.jp");
        Serie bomDiaVeronica = new Serie("Bom dia, Verônica","Brasil", "www.bomdiaveronica.com.br");

        //ADIÇÃO DAS SERIES À GRADE DE SERIES
        GradeSeries gradeSeries = new GradeSeries();
        gradeSeries.getSeries().add(laCasaDePapel);
        gradeSeries.getSeries().add(rickAndMorty);
        gradeSeries.getSeries().add(sexEducation);
        gradeSeries.getSeries().add(dixPourCent);
        gradeSeries.getSeries().add(onePunchMan);
        gradeSeries.getSeries().add(bomDiaVeronica);


        //CRIAÇÃO PROXYS

        //PARA FILMES
        IGradeFilmes proxy01 = new GradeFilmesProxy(userArg, gradeFilmes);
        IGradeFilmes proxy02 = new GradeFilmesProxy(userBr, gradeFilmes);
        IGradeFilmes proxy03 = new GradeFilmesProxy(userCol, gradeFilmes);
        IGradeFilmes proxy04 = new GradeFilmesProxy(userOutro, gradeFilmes);

        //PARA SERIES
        IGradeSeries proxy05 = new GradeSeriesProxy(userBr, gradeSeries);


        //EXECUTADOS TRY E CATCH COM FILMES

        //usuario da Arg seleciona filme Br
        try {
            proxy01.getFilme("Bacurau");
        } catch (FilmeNaoHabilitadoException exception) {
            System.err.println(exception);
        }

        //usuario Br seleciona filme Br
        try {
            proxy02.getFilme("Bacurau");
        } catch (FilmeNaoHabilitadoException exception) {
            System.err.println(exception);
        }

        //usuario Col tenta acessar filme Arg
        try {
            proxy03.getFilme("Medianeras");
        } catch (FilmeNaoHabilitadoException exception) {
            System.err.println(exception);
        }

        //usuario de outro pais tenta acessar filme Col
        try {
            proxy04.getFilme("El Patrón");
        } catch (FilmeNaoHabilitadoException exception) {
            System.err.println(exception);
        }


        //EXECUTADOS TRY E CATCH COM SÉRIES
        //01
        try {
            System.out.println("\nSegue o link para acesso: "+proxy05.getSerie("La Casa de Papel")+". Prepare a pipoca e boa série!");
        } catch (SerieNaoHabilitadaException exception) {
            System.err.println(exception);
        }

        //02
        try {
            System.out.println("\nSegue o link para acesso: "+proxy05.getSerie("Rick and Morty")+". Prepare a pipoca e boa série!");
        } catch (SerieNaoHabilitadaException exception) {
            System.err.println(exception);
        }

        //03
        try {
            System.out.println("\nSegue o link para acesso: "+proxy05.getSerie("Sex Education")+". Prepare a pipoca e boa série!");
        } catch (SerieNaoHabilitadaException exception) {
            System.err.println(exception);
        }

        //04
        try {
            System.out.println("\nSegue o link para acesso: "+proxy05.getSerie("Dix pour Cent")+". Prepare a pipoca e boa série!");
        } catch (SerieNaoHabilitadaException exception) {
            System.err.println(exception);
        }

        //05
        try {
            System.out.println("\nSegue o link para acesso: "+proxy05.getSerie("One Punch Man")+". Prepare a pipoca e boa série!");
        } catch (SerieNaoHabilitadaException exception) {
            System.err.println(exception);
        }

        //06
        try {
            System.out.println("\nSegue o link para acesso: "+proxy05.getSerie("Bom dia, Verônica")+". Prepare a pipoca e boa série!");
        } catch (SerieNaoHabilitadaException exception) {
            System.err.println(exception);
        }

    }
}

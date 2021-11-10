package Filmes;

public class FilmeNaoHabilitadoException extends Exception{

    public FilmeNaoHabilitadoException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "A seguinte exceção ocorreu: "+this.getClass().getName()+"\n"+"Mensagem: "+this.getMessage();
    }
}

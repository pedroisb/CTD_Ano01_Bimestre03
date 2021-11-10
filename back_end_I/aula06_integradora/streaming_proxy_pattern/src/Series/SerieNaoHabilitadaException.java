package Series;

public class SerieNaoHabilitadaException extends Exception{

    public SerieNaoHabilitadaException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "\nA seguinte exceção ocorreu: "+this.getClass().getName()+"\n"+"Mensagem: "+this.getMessage();
    }
}

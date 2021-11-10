public class IdadeNegativa extends Exception{

    public IdadeNegativa() {
    }

    public IdadeNegativa(String message) {
        super(message);
    }

/*    @Override
    public String toString() {
        return "A seguinte exceção ocorreu: "+this.getClass().getName()+"\n"+"Mensagem: "+this.getMessage();
    }*/
}

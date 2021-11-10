package Documento;

public class Doc {

    private String conteudo;
    private int tipo;

    public Doc(String conteudo, int tipo) {
        this.conteudo = conteudo;
        this.tipo = tipo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}

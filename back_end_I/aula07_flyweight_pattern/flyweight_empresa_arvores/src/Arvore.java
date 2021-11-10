public class Arvore {

    private int altura;
    private int largura;
    private String cor;

    public Arvore(int altura, int largura, String cor) {
        this.altura = altura;
        this.largura = largura;
        this.cor = cor;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}

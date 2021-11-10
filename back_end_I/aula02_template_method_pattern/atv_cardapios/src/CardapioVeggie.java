public class CardapioVeggie extends Cardapio{

    private double precoEmbalagem;
    private int qntCondimnentos;

    public CardapioVeggie(double precoBase, double precoEmbalagem, int qntCondimnentos) {
        super(precoBase);
        this.precoEmbalagem = precoEmbalagem;
        this.qntCondimnentos = qntCondimnentos;
    }

    @Override
    protected void montar() {
        System.out.println("Adicionar embalagem especial!");
    }

    @Override
    protected void calcPrecoVenda() {
        double precoVenda = getPrecoBase()+this.precoEmbalagem+(precoEmbalagem*qntCondimnentos/100);
        System.out.println("O preço total será de: R$ "+precoVenda+"\n");
    }

    public double getPrecoEmbalagem() {
        return precoEmbalagem;
    }

    public void setPrecoEmbalagem(double precoEmbalagem) {
        this.precoEmbalagem = precoEmbalagem;
    }

    public int getQntCondimnentos() {
        return qntCondimnentos;
    }

    public void setQntCondimnentos(int qntCondimnentos) {
        this.qntCondimnentos = qntCondimnentos;
    }
}

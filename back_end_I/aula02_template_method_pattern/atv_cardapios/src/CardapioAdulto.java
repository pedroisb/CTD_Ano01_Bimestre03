public class CardapioAdulto extends Cardapio{

    public CardapioAdulto(double precoBase) {
        super(precoBase);
    }

    @Override
    protected void montar() {}

    @Override
    protected void calcPrecoVenda() {
        System.out.println("O preço total será de: R$ "+getPrecoBase()+"\n");
    }
}

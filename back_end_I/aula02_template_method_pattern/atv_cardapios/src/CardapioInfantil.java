public class CardapioInfantil extends Cardapio{

    private double precoBrinquedo;

    public CardapioInfantil(double precoBase, double precoBrinquedo) {
        super(precoBase);
        this.precoBrinquedo = precoBrinquedo;
    }

    @Override
    protected void montar() {
        System.out.println("Adicionar brinquedo surpresa!");
    }

    @Override
    protected void calcPrecoVenda() {
        double precoVenda = getPrecoBase()+this.precoBrinquedo;
        System.out.println("O preço total será de: R$ "+precoVenda+"\n");
    }

    public double getPrecoBrinquedo() {
        return precoBrinquedo;
    }

    public void setPrecoBrinquedo(double precoBrinquedo) {
        this.precoBrinquedo = precoBrinquedo;
    }
}

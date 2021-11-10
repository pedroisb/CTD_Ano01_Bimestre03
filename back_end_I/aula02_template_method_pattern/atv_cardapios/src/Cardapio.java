public abstract class Cardapio {

    private double precoBase;

    public Cardapio(double precoBase) {
        this.precoBase = precoBase;
    }

    public void preparar(){
        montar();
        calcPrecoVenda();
    }

    protected abstract void montar();
    protected abstract void calcPrecoVenda();

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    }
}

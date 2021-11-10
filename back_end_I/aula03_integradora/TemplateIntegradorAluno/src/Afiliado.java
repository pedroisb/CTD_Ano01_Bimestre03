public class Afiliado extends Vendedor{

    public Afiliado(String nome) {
        super(nome);
        this.pts_por_venda = 15;
    }

    @Override
    public int calcPts() {
        this.ptsTotal = this.vendas * pts_por_venda;
        return ptsTotal;
    }
}

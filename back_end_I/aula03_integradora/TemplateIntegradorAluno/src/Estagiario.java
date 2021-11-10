public class Estagiario extends Vendedor{

    public Estagiario(String nome) {
        super(nome);
        this.pts_por_venda = 5;
    }

    @Override
    public int calcPts() {
        this.ptsTotal = this.vendas * pts_por_venda;
        return ptsTotal;
    }

    @Override
    public String categorizar() {
        int p = this.ptsTotal;
        if (p<50)
            setCategoria("Estagiário Novato");
        else if (p>=50)
            setCategoria("Estagiário Experiente");
        else
            return null;
        return this.categoria;
    }
}

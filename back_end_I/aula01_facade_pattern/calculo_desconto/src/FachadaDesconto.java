public class FachadaDesconto implements IFachadaDesconto{

    private ApiCartao apiCartao;
    private ApiProduto apiProduto;
    private ApiQnt apiQnt;

    public FachadaDesconto() {
        this.apiCartao = new ApiCartao();
        this.apiProduto = new ApiProduto();
        this.apiQnt = new ApiQnt();
    }

    @Override
    public int desconto(Cartao cartao, Produto prod, int qnt) {
/*        int desconto = 0;
        desconto += apiQnt.desconto(qnt)
                + apiProduto.desconto(prod)
                + apiCartao.desconto(cartao);
        return desconto;*/

        return apiQnt.desconto(qnt)
                + apiProduto.desconto(prod)
                + apiCartao.desconto(cartao);
    }
}

import java.util.ArrayList;

public class Funcionario extends Vendedor {

    private int anosAntiguidade;
    private ArrayList<Vendedor> afiliados;

    //Semelhante à classe abstrata, inicialização do Array afiliados para dentro da construtora
    public Funcionario(String nome, int anosAntiguidade) {
        super(nome);
        this.pts_por_venda = 5;
        this.anosAntiguidade = anosAntiguidade;
        this.afiliados = new ArrayList<>();
    }

    /*agrega um afiliado ao funcionario, e por sua vez soma os pontos*/
     public void addAfiliado(Vendedor afiliado){
        this.afiliados.add(afiliado);
        System.out.println(afiliado.nome+ " agora é afiliado de "+super.nome+".");
     }

    /*implementação do método abstrato*/
    /*por cada ano de antiguidade obtem 5 pontos, por cada afiliado obtem 5*/
    @Override
    public int calcPts() {
        //incluído calc de pts pelas vendas
        this.ptsTotal = (this.vendas*this.pts_por_venda) + (this.afiliados.size()*10) + (this.anosAntiguidade*5);
        return ptsTotal;
    }
}

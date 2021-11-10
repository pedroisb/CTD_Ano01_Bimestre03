
//validação que usa propriedades de subclasse apenas!!
//Classe abstrata Vendedor - aqui vai o Template Method
public abstract class Vendedor {
    protected String nome;
    protected int vendas;
    protected int pts_por_venda;

    //Decidi acrescentar estes dois atributos para abrigar valores a serem retornados pelos métodos calcPts() e recategorizar()
    protected int ptsTotal;
    protected String categoria;

    //criei método construtor e passei inicialização dos variáveis vendas e ptsTotal para dentro dele
    public Vendedor(String nome) {
        this.nome = nome;
        this.vendas = 0;
        this.ptsTotal = 0;
    }

    public void vender(int qtdVendas){
        this.vendas += qtdVendas;
        System.out.println(this.nome +" realizou "+ qtdVendas + " venda(s).");
    }

    /*Método que calcula os pontos do Vendedor de acordo com seus aspectos a serem considerados*/
    public abstract int calcPts();

    public String categorizar() {
        int p = this.ptsTotal;
        if (p<20)
            setCategoria("Novato");
        else if (p>=20 && p<=30)
            setCategoria("Aprendiz");
        else if (p>=31 && p<=40)
            setCategoria("Bom");
        else if (p>40)
            setCategoria("Mestre");
        else
            return null; //não deve entrar nesse caso, mas, por eventualidade, botei um return null para não parar execução do código
        return this.categoria;
    }

    /*TEMPLATE METHOD - recebe o total de pontos calculados a partir da subclasse e valida cada item para retornar a categoria*/
    public String mostrarCategoria(){
        calcPts();
        categorizar();
        return this.nome+" possui um total de "+this.ptsTotal+" pontos e pertence à categoria "+this.categoria+".";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVendas() {
        return vendas;
    }

    public void setVendas(int vendas) {
        this.vendas = vendas;
    }

    public int getPts_por_venda() {
        return pts_por_venda;
    }

    public void setPts_por_venda(int pts_por_venda) {
        this.pts_por_venda = pts_por_venda;
    }

    public int getPtsTotal() {
        return ptsTotal;
    }

    public void setPtsTotal(int ptsTotal) {
        this.ptsTotal = ptsTotal;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}






public class Leao {

    private String nome;
    private int idade;
    private boolean alfa;

    public Leao(String nome, int idade, boolean alfa) {
        this.nome = nome;
        this.idade = idade;
        this.alfa = alfa;
    }

    public String correr(){
       return "O leão "+this.nome+" está correndo";
    }

    public void verificarAtributos() throws IdadeNegativa{
        if(this.idade>10 && alfa==true)
            System.out.println("O leão "+this.nome+" tem mais de 10 anos e é alfa");
        else if (this.idade < 0)
            throw new IdadeNegativa();
    }
}

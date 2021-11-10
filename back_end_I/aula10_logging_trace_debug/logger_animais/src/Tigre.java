public class Tigre {

    private String nome;
    private int idade;

    public Tigre(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String correr(){
        return "Tigre(sa) "+this.nome+" está correndo";
    }

    public void verificarAtributos() throws IdadeNegativa{
        if(this.idade>10)
            System.out.println("Tigre(sa) "+this.nome+" tem mais de 10 anos");
        else if (this.idade < 0)
            throw new IdadeNegativa("A idade de "+this.nome+" está incorreta");
    }
}

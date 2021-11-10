import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Pessoa {

    private String nome;
    private LocalDate dataNasc;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getIdade() {
        return dataNasc;
    }

    public void setIdade(LocalDate idade) {
        this.dataNasc = idade;
    }

    public boolean calcNome(){
        return this.nome.length() >= 5;
    }

    public boolean maiorDeIdade(){
        return Period.between(this.dataNasc, LocalDate.now()).getYears() >= 18;
    }

    public List<Pessoa> verificarPessoas (List<Pessoa> pessoas){
        List<Pessoa> pessoasMaior = new ArrayList<>();
        pessoas.forEach(pessoa -> {
            if(pessoa.calcNome() && pessoa.maiorDeIdade())
                pessoasMaior.add(pessoa);
        });
        return pessoasMaior;
    }
}

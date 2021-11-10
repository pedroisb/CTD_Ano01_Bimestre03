import java.time.LocalDate;
import java.util.Scanner;

public abstract class Cartao {

    Scanner leitor = new Scanner(System.in);

    private String num;
    private String codSeguranca;
    private LocalDate dataValidade;

    public Cartao(String num, String codSeguranca, LocalDate dataValidade) {
        this.num = num;
        this.codSeguranca = codSeguranca;
        this.dataValidade = dataValidade;
    }

    public void processarPagamento (){
        double valor = Double.parseDouble(leitor.nextLine());
        validarData();
        if (validarData())
            autorizarPagamento(valor);
        else
            System.out.println("Validade expirada");
    }

    private boolean validarData(){
        if(this.dataValidade.compareTo(LocalDate.now())>0){
            return true;
        }
        return false;
    }

    protected abstract boolean autorizarPagamento(double valor);

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getCodSeguranca() {
        return codSeguranca;
    }

    public void setCodSeguranca(String codSeguranca) {
        this.codSeguranca = codSeguranca;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }
}



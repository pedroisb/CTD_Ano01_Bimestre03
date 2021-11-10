import java.time.LocalDate;

public class CartaoDebito extends Cartao{

    private double saldoDisponivel;

    public CartaoDebito(String num, String codSeguranca, LocalDate dataValidade, double saldoDisponivel) {
        super(num, codSeguranca, dataValidade);
        this.saldoDisponivel = saldoDisponivel;
    }

    @Override
    protected boolean autorizarPagamento(double valor) {
        if (this.saldoDisponivel >= valor) {
            System.out.println("Pagamento autorizado");
            return true;
        }
        System.out.println("Saldo insuficiente");
        return false;
    }
}

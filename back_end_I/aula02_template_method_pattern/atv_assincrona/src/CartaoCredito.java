import java.time.LocalDate;
import java.util.Scanner;

public class CartaoCredito extends Cartao{

    private double limite;
    private double saldoUtilizado;

    public CartaoCredito(String num, String codSeguranca, LocalDate dataValidade, double limite, double saldoUtilizado) {
        super(num, codSeguranca, dataValidade);
        this.limite = limite;
        this.saldoUtilizado = saldoUtilizado;
    }

    @Override
    protected boolean autorizarPagamento(double valor){
        if (valor <= (this.limite-this.saldoUtilizado)){
            System.out.println("Pagamento autorizado");
            return true;
        }
        System.out.println("Limite insuficiente");
        return false;
    }
}

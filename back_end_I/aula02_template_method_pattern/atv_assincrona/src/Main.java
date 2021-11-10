import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Cartao cartao01 = new CartaoDebito("15615651651", "462", LocalDate.of(2020, 6, 15), 1000.00);

        Cartao cartao02 = new CartaoCredito("98497849", "420", LocalDate.of(2022, 6, 15), 5000.00, 2000.00);

//        cartao01.processarPagamento();

        cartao02.processarPagamento();

    }
}

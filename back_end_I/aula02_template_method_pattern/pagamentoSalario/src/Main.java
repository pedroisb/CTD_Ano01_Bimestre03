public class Main {
    public static void main(String[] args) {

        Funcionario funcionario = new Efetivo("Odair", "Antunes", "12354698", 5000.0, 1000.0, 500.0);

        funcionario.pagamentoSalario();

        funcionario = new Contratado("Marlene", "Peixoto", "5649684", 100.0, 80);

        funcionario.pagamentoSalario();
    }
}

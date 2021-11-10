public class Main {
    public static void main(String[] args) {
        ComputadorFactory computador = new ComputadorFactory();
        Computador mac = computador.getComputador(8,500,1);
        Computador janelas = computador.getComputador(16,500,2);
        Computador mac2 = computador.getComputador(8,500,3);
        Computador janelas2 = computador.getComputador(16,500,2);

        System.out.println(mac.toString());
        System.out.println(janelas.toString());
        System.out.println(mac2.toString());
        System.out.println(janelas2.toString());

    }
}

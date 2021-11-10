public class Main {
    public static void main(String[] args) {

        Cardapio menu = new CardapioAdulto(15.00);
        menu.preparar();

        menu = new CardapioInfantil(10.00, 2.50);
        menu.preparar();

        menu = new CardapioVeggie(15.00, 2.00, 3);
        menu.preparar();

    }
}

public class Main {
    public static void main(String[] args) {

        /*Mofidicar o main para testar a lógica com o template method */

        Vendedor func1 = new Funcionario("Pedro",2);
        Vendedor func2 = new Funcionario("Maria",1);

        Vendedor afi1 = new Afiliado("Ramon");
        Vendedor afi2 = new Afiliado("Paulo");
        Vendedor afi3 = new Afiliado("José");

        Vendedor estag1 = new Estagiario("João");
        Vendedor estag2 = new Estagiario("Cláudia");


        func1.vender(2);
        ((Funcionario) func1).addAfiliado(afi1); //mudei o tipo do objeto para a classe abstrata na criação e fiz um downcast para praticar um pouco
        System.out.println(func1.mostrarCategoria()+"\n");

        func2.vender(1);
        System.out.println(func2.mostrarCategoria()+"\n");

        afi1.vender(4);
        System.out.println(afi1.mostrarCategoria()+"\n");

        afi2.vender(1);
        System.out.println(afi2.mostrarCategoria()+"\n");

        afi3.vender(2);
        System.out.println(afi3.mostrarCategoria()+"\n");

        estag1.vender(6);
        System.out.println(estag1.mostrarCategoria()+"\n");

        estag2.vender(10);
        System.out.println(estag2.mostrarCategoria()+"\n");

    }
}
